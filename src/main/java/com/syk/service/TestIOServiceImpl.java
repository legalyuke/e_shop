package com.syk.service;

import com.google.common.util.concurrent.*;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author liyuke
 * @date 2021-05-23 17:36
 */
@Slf4j
public class TestIOServiceImpl {
    //    class GuavaFutureDemo {
    final static int SLEEP_GAP = 500;

    static String getCurThreadName() {
        return Thread.currentThread().getName();
    }
//    }

    //业务逻辑：烧⽔
    static class HotwaterJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            //……省略，与使⽤FutureTask实现异步泡茶喝相同
            return true;
        }
    }

    //业务逻辑：清洗
    static class WashJob implements Callable<Boolean> {
        @Override
        public Boolean call() throws Exception {
            //……省略，与使⽤FutureTask实现异步泡茶喝相同
            return true;
        }
    }

    //新创建⼀个异步业务类型，作为泡茶喝主线程类
    static class MainJob implements Runnable {
        boolean waterOk = false;
        boolean cupOk = false;
        int gap = SLEEP_GAP / 10;

        @Override
        public void run() {
            while (true) {
                try {
                    Thread.sleep(gap);
                    log.info("读书中......");
                } catch (InterruptedException e) {
                    log.info(getCurThreadName() + "发⽣异常被中断.");
                }
                if (waterOk && cupOk) {
                    drinkTea(waterOk, cupOk);
                }
            }
        }

        public void drinkTea(Boolean wOk, Boolean cOK) {
            if (wOk && cOK) {
                log.info("泡茶喝，茶喝完");
                this.waterOk = false;
                this.gap = SLEEP_GAP * 100;
            } else if (!wOk) {
                log.info("烧⽔失败，没有茶喝了");
            } else if (!cOK) {
                log.info("杯⼦洗不了，没有茶喝了");
            }
        }
    }

    public static void main(String[] args) {
        //创建⼀个新的线程实例，作为泡茶主线程
        MainJob mainJob = new MainJob();
        Thread mainThread = new Thread(mainJob);
        mainThread.setName("主线程");
        mainThread.start();
        //烧⽔的业务逻辑实例
        Callable<Boolean> hotJob = new HotwaterJob();
        //清洗的业务逻辑实例
        Callable<Boolean> washJob = new WashJob();
        //创建Java 线程池
        ExecutorService jPool = Executors.newFixedThreadPool(10);
        //包装Java线程池，构造Guava 线程池
        ListeningExecutorService gPool
                = MoreExecutors.listeningDecorator(jPool);
        //提交烧⽔的业务逻辑实例，到Guava线程池获取异步任务
        ListenableFuture<Boolean> hotFuture = gPool.submit(hotJob);
        //绑定异步回调，烧⽔完成后，把喝⽔任务的waterOk标志设置为true
        Futures.addCallback(hotFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean r) {
                if (r) {
                    mainJob.waterOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                log.info("烧⽔失败，没有茶喝了");
            }
        });
        //提交清洗的业务逻辑实例，到Guava线程池获取异步任务
        ListenableFuture<Boolean> washFuture = gPool.submit(washJob);
        //绑定任务执⾏完成后的回调逻辑到异步任务
        Futures.addCallback(washFuture, new FutureCallback<Boolean>() {
            @Override
            public void onSuccess(Boolean r) {
                if (r) {
                    mainJob.cupOk = true;
                }
            }

            @Override
            public void onFailure(Throwable t) {
                log.info("杯⼦洗不了，没有茶喝了");
            }
        });
    }
}
