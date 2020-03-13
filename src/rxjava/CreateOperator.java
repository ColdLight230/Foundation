package rxjava;

import io.reactivex.Observable;
import io.reactivex.ObservableOnSubscribe;
import io.reactivex.ObservableSource;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;

/**
 * 创建型操作符
 */
public class CreateOperator {

    public static void main(String[] args) {
        //        new CreateOperator().testCreate();
        new CreateOperator().testDelayCreate();
    }

    private void testCreate() {

        //  region create  完整的创建被观察者对象
        Observable.create((ObservableOnSubscribe<Integer>) emitter -> {
            emitter.onNext(1);
            emitter.onComplete();
        }).subscribe(new Observer<Integer>() {
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
            public void onNext(Integer integer) {
                System.out.println("对事件 " + integer + " 做出响应");
            }

        });
        // ------------------- endregion ----------------------

        //  region just 快速创建被观察者对象，最多发送10个事件
        Observable.just(1, 2, 3, 4, 5, 6).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("对事件 " + integer + " 做出响应");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }
        });
        // ------------------- endregion ----------------------

        //  region fromArray 快速创建 被观察者对象（Observable） & 发送10个以上事件（数组形式）
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8};
        Observable.fromArray(array).subscribe(new Observer<Integer>() {
            @Override
            public void onSubscribe(Disposable disposable) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onNext(Integer integer) {
                System.out.println("对事件 " + integer + " 做出响应");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }
        });
        int[] intArray = new int[]{1, 2, 3, 4};
        Observable.fromArray(intArray).subscribe(new Observer<int[]>() {
            @Override
            public void onSubscribe(Disposable d) {
                System.out.println("开始采用subscribe连接");
            }

            @Override
            public void onNext(int[] ints) {
                System.out.println("对事件 " + ints + " 做出响应");
            }

            @Override
            public void onError(Throwable throwable) {
                System.out.println("对事件 " + throwable + " 做出响应");
            }

            @Override
            public void onComplete() {
                System.out.println("对事件 onComplete 做出响应");
            }
        });
        // ------------------- endregion ----------------------

        //  region fromIterable  快速创建 被观察者对象（Observable） & 发送10个以上事件（集合形式）
        List<String> strList = new ArrayList<>();
        strList.add("A");
        strList.add("B");
        strList.add("C");
        Observable.fromIterable(strList).subscribe(new Observer<String>() {
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
            public void onNext(String s) {
                System.out.println("对事件 " + s + " 做出响应");
            }

        });
        // ------------------- endregion ----------------------

        //  region empty 该方法创建的被观察者对象发送事件的特点：仅发送Complete事件，直接通知完成
        Observable.empty().subscribe(new Observer<Object>() {
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
            public void onNext(Object o) {
                System.out.println("对事件 " + o + " 做出响应");
            }

        });
        // ------------------- endregion ----------------------

        // region error 该方法创建的被观察者对象发送事件的特点：仅发送Error事件，直接通知异常
        Observable.error(new RuntimeException("直接报错")).subscribe(new Observer<Object>() {
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
            public void onNext(Object o) {
                System.out.println("对事件 " + o + " 做出响应");
            }

        });
        // ------------------- endregion ----------------------

        // region never 该方法创建的被观察者对象发送事件的特点：不发送任何事件
        Observable.never().subscribe(new Observer<Object>() {
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
            public void onNext(Object o) {
                System.out.println("对事件 " + o + " 做出响应");
            }

        });
        // ------------------- endregion ----------------------

    }

    private int i = 1;

    private void testDelayCreate() {
        // region defer 直到有观察者（Observer ）订阅时，才动态创建被观察者对象（Observable） & 发送事件
        Observable<Object> observable = Observable.defer(new Callable<ObservableSource<?>>() {
            @Override
            public ObservableSource<?> call() {
                return Observable.just(i);
            }
        });
        i = 10;
        observable.subscribe(new Observer<Object>() {
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
            public void onNext(Object o) {
                System.out.println("对事件 " + o + " 做出响应");
            }

        });
        // ------------------- endregion ----------------------

        // region timer 延迟指定时间后，发送1个数值0（Long类型）
        Observable.timer(1, TimeUnit.MILLISECONDS).subscribe(new Observer<Long>() {
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
            public void onNext(Long aLong) {
                System.out.println("对事件 " + aLong + " 做出响应");
            }

        });
        // ------------------- endregion ----------------------

        // region interval 发送的事件序列 = 从0开始、无限递增1的的整数序列
        Observable.interval(1, TimeUnit.SECONDS).subscribe(new Consumer<Long>() {
            @Override
            public void accept(Long aLong) throws Exception {
                System.out.println("accept ");
            }
        });
        // ------------------- endregion ----------------------

        // region intervalRange 发送的事件序列 = 从0开始、无限递增1的的整数序列 作用类似于interval（），但可指定发送的数据的数量
        // 参数1 = 事件序列起始点；
        // 参数2 = 事件数量；
        // 参数3 = 第1次事件延迟发送时间；
        // 参数4 = 间隔时间数字；
        // 参数5 = 时间单位
        Observable.intervalRange(1, 10, 0, 1, TimeUnit.SECONDS).subscribe(new Observer<Long>() {
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
            public void onNext(Long aLong) {
                System.out.println("对事件 " + aLong + " 做出响应");
            }
        });
        // ------------------- endregion ----------------------

        // region range 发送事件的特点：连续发送事件序列，可指定范围
        Observable.range(5, 11).subscribe(new Observer<Integer>() {
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
            public void onNext(Integer integer) {
                System.out.println("对事件 " + integer + " 做出响应");
            }
        });
        // ------------------- endregion ----------------------

        // region rangeLong 发送事件的特点：连续发送事件序列，可指定范围
        Observable.rangeLong(1222213123, 1222213125).subscribe(new Observer<Long>() {
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
            public void onNext(Long aLong) {
                System.out.println("对事件 " + aLong + " 做出响应");
            }
        });
        // ------------------- endregion ----------------------
    }
}
