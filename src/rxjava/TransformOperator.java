package rxjava;

import io.reactivex.*;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Function;

import java.util.ArrayList;
import java.util.List;

/**
 * 变换型操作符
 */
public class TransformOperator {

    public static void main(String[] args) {
        // region 操作符 map  将被观察者发送的事件转换为任意的类型事件
        Observable.create(new ObservableOnSubscribe<Integer>() {
            @Override
            public void subscribe(ObservableEmitter<Integer> emitter) throws Exception {
                emitter.onNext(1);
                emitter.onNext(2);
                emitter.onComplete();
            }
        }).map(new Function<Integer, String>() {
            @Override
            public String apply(Integer integer) throws Exception {
                return "使用 Map 将 Integer:" + integer + " 转换为 String";
            }
        }).subscribe(new Observer<String>() {
            @Override
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
                System.out.println("对事件 " + string + " 做出响应");
            }
        });
        // ------------------- endregion ----------------------

        // region 操作符 flatMap  无序的将被观察者发送的整个事件序列进行变换
        Observable.just(1, 2, 3).flatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> array = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    array.add("我是第 " + integer + " 个事件拆分出来的第 " + i + " 个子事件");
                }
                return Observable.fromIterable(array);
            }
        }).subscribe(new Observer<String>() {
            @Override
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
                System.out.println("对事件 " + string + " 做出响应");
            }
        });
        // ------------------- endregion ----------------------

        // region 操作符 concatMap  有序的将被观察者发送的整个事件序列进行变换
        Observable.just(1, 2, 3).concatMap(new Function<Integer, ObservableSource<String>>() {
            @Override
            public ObservableSource<String> apply(Integer integer) throws Exception {
                List<String> array = new ArrayList<>();
                for (int i = 0; i < 3; i++) {
                    array.add("我是第 " + integer + " 个事件拆分出来的第 " + i + " 个子事件");
                }
                return Observable.fromIterable(array);
            }
        }).subscribe(new Observer<String>() {
            @Override
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
                System.out.println("对事件 " + string + " 做出响应");
            }
        });
        // ------------------- endregion ----------------------

        // region 操作符 buffer  定期从 被观察者（Obervable）需要发送的事件中 获取一定数量的事件 & 放到缓存区中，最终发送
        Observable.just(1, 2, 3, 4, 5).buffer(3, 2).subscribe(new Observer<List<Integer>>() {
            @Override
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
            public void onNext(List<Integer> integers) {
                System.out.println(" 缓存区里的事件数量 = " + integers.size());
                for (Integer value : integers) {
                    System.out.println(" 事件 = " + value);
                }
            }
        });
        // ------------------- endregion ----------------------
    }
}
