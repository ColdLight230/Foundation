package rxjava;

import io.reactivex.Observable;
import io.reactivex.Observer;
import io.reactivex.disposables.Disposable;

public class BasicRxJavaTest {

    /*
     * 打印结果：
     * 开始采用subscribe连接
     * 发射事件1
     * 对事件 1 做出响应
     * 发射事件2
     * 对事件 2 做出响应
     * 发射事件错误
     * 对事件 java.lang.RuntimeException: 错误了。。。 做出响应
     * 发射事件3
     * 发射onComplete事件
     *
     * 1. 可以看到在执行onError后，就不会再执行onNext了
     * 2. onError和onComplete事件是相斥的
     *      如果先执行了onError，后面发射的complete事件不会被处理。
     *      如果先执行了onComplete，再调用onError会crash
     */
    public static void main(String[] args) {
        Observable<Integer> observable = Observable.create(observableEmitter -> {
            System.out.println("发射事件1");
            observableEmitter.onNext(1);
            System.out.println("发射事件2");
            observableEmitter.onNext(2);
            System.out.println("发射事件3");
            observableEmitter.onNext(3);
            System.out.println("发射事件错误");
            observableEmitter.onError(new RuntimeException("错误了。。。"));
            System.out.println("发射onComplete事件");
            observableEmitter.onComplete();
            //            while (true){
            //                observableEmitter.onNext(10);
            //            }
        });

        observable.subscribe(new Observer<Integer>() {
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


    }
}
