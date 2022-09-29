package com.example.threadpool;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;
import java.util.concurrent.ThreadPoolExecutor;

public class ResultCallback implements Runnable {
    private final Future<ResultDto> job1;
    private final Future<ResultDto> job2;
    private final ThreadPoolExecutor threadPoolExecutor;

    public ResultCallback(final Future<ResultDto> job1, final Future<ResultDto> job2,
                          final ThreadPoolExecutor threadPoolExecutor) {
        this.job1 = job1;
        this.job2 = job2;
        this.threadPoolExecutor = threadPoolExecutor;
    }

    @Override
    public void run() {
        try {
            final ResultDto resultDto3 = job1.get();
            final ResultDto resultDto4 = job2.get();

            System.out.println();
            System.out.println("Future의 get메서드로 취합된 데이터");
            System.out.println(resultDto4.getData());

            System.out.println();
            System.out.println("I'm shutting down..");
            threadPoolExecutor.shutdown();
        } catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
