package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableEmitter;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.BiConsumer;
import io.reactivex.functions.BiFunction;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 组合、合并操作符
 */
public class CombinationAndMergeOperator {

    public static void main(String[] args) {
        new CombinationAndMergeOperator().testConcat();
        new CombinationAndMergeOperator().testMerge();
        new CombinationAndMergeOperator().testZip();

        // 操作符 combineLatest 当两个Observables中的任何一个发送了数据后，将先发送了数据的Observables 的最新（最后）一个数据 与 另外一个Observable发送的每个数据结合，最终基于该函数的结果发送数据
        Observable.combineLatest(Observable.just(1, 2, 3), Observable.just("A", "B", "C"), new BiFunction<Integer, String, String>() {
            @Override
            public String apply(Integer integer, String s) throws Exception {
                return integer + s;
            }
        }).subscribe(new Consumer<String>() {
            @Override
            public void accept(String s) throws Exception {
                System.out.println("combineLatest operator -> " + s);
            }
        });

        // 操作符 reduce 把被观察者需要发送的事件聚合成1个事件 & 发送
        // 聚合的逻辑根据需求撰写，但本质都是前2个数据聚合，然后与后1个数据继续进行聚合，依次类推
        Observable.just(1, 2, 3, 4, 5).reduce(new BiFunction<Integer, Integer, Integer>() {
            @Override
            public Integer apply(Integer integer, Integer integer2) throws Exception {
                System.out.println("reduce operator 本次处理的数据是 " + integer + " 和 " + integer2);
                return integer + integer2;
            }
        }).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("reduce operator 最终处理完的数据 " + integer);
            }
        });

        // 操作符 collect 被观察者Observable发送的数据事件收集到一个数据结构里
        Observable.just(1, 2, 3, 4).collect(new Callable<List<String>>() {
            @Override
            public List<String> call() throws Exception {
                return new ArrayList<>();
            }
        }, new BiConsumer<List<String>, Integer>() {
            @Override
            public void accept(List<String> strings, Integer integer) throws Exception {
                strings.add("Hello " + integer);
            }
        }).subscribe(new Consumer<List<String>>() {
            @Override
            public void accept(List<String> strings) throws Exception {
                System.out.println("collect operator 最终的数据是 " + strings);
            }
        });

        // 操作符 startWith 在一个被观察者发送事件前，追加发送一些数据 / 一个新的被观察者
        // 追加数据顺序 = 后调用先追加
        Observable.just(7, 8, 9).startWith(6).startWithArray(3, 4, 5).startWith(Observable.just(1, 2)).subscribe(new Consumer<Integer>() {
            @Override
            public void accept(Integer integer) throws Exception {
                System.out.println("startWith operator 顺序是: " + integer);
            }
        });

        // 操作符 count 统计被观察者发送事件的数量
        Observable.just(1, 2, 3, 4, 5).count().subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("count 最终统计事件数量为 " + aLong);
            }
        });
    }

    private void testConcat() {
        // 组合多个被观察者一起发送数据，合并后 按发送顺序串行执行
        // 二者区别：组合被观察者的数量，即concat（）组合被观察者数量≤4个，而concatArray（）则可＞4个
        Observable.concat(Observable.just(1, 2, 3), Observable.just(4, 5, 6), Observable.just(7, 8, 9), Observable.just(10, 11, 12)).subscribe(new Observer<Integer>() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("concat operator -> " + integer);
            }

        });
        Observable.concatArray(Observable.just(1, 2, 3), Observable.just(4, 5, 6), Observable.just(7, 8, 9), Observable.just(10, 11, 12), Observable.just(13, 14, 15)).subscribe(new Observer<Integer>() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("concat operator -> " + integer);
            }
        });

        // 操作符 concatArrayDelayError 第1个被观察者的Error事件将在第2个被观察者发送完事件后再继续发送
        Observable.concatArrayDelayError(Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onError(new RuntimeException("错误数据"));
            }
        }), Observable.just(3, 4, 5)).subscribe(new Observer<Integer>() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }


            @Override
            public void onNext(Integer integer) {
                System.out.println("concatArrayDelayError operator -> " + integer);
            }
        });
    }

    private void testMerge() {
        // 组合多个被观察者一起发送数据，合并后 按时间线并行执行
        // 二者区别：组合被观察者的数量，即merge（）组合被观察者数量≤4个，而mergeArray（）则可＞4个
        Observable.merge(Observable.intervalRange(0, 3, 1, 1, TimeUnit.SECONDS), Observable.intervalRange(2, 3, 1, 1, TimeUnit.SECONDS)).subscribe(new Observer<Long>() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }

            @Override
            public void onNext(Long aLong) {
                System.out.println("merge operator -> " + aLong);
            }
        });
    }

    private void testZip() {
        // 合并 多个被观察者（Observable）发送的事件，生成一个新的事件序列（即组合过后的事件序列），并最终发送
        Observable<String> observable1 = Observable.just("A", "B", "C", "D");
        Observable<Integer> observable2 = Observable.just(1, 2, 3);
        Observable.zip(observable1, observable2, new BiFunction<String, Integer, String>() {
            @Override
            public String apply(String s, Integer integer) throws Exception {
                return s + integer;
            }
        }).subscribe(new Observer<String>() {
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }

            @Override
            public void onNext(String string) {
                System.out.println("zip operator -> " + string);
            }
        });
    }
}
