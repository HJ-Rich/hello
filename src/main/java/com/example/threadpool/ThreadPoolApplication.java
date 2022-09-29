package com.example.threadpool;

import java.util.concurrent.Future;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class ThreadPoolApplication {

    public static void main(String[] args) {
        // 쓰레드 풀 생성
        final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(
                4,
                8,
                120L,
                TimeUnit.SECONDS,
                new SynchronousQueue<>()
        );

        // 두 비동기 작업 결과가 저장될 객체 선언
        final ResultDto resultDto = new ResultDto();

        // 두 비동기 작업 생성, 작업 결과를 저장할 객체도 함께 전달
        final Job job = new Job(resultDto, 3, "hello", "world");
        final Job job2 = new Job(resultDto, 5, "nickname", "richard");

        // 두 비동기 작업을 스레드풀 작업 큐에 전달.
        // 두번째 매개변수로 객체를 주면 Future.get()의 결과로 그 객체를 돌려줌
        // 두 비동기 작업의 run 메서드 내부에서 해당 객체에 값을 넣는 로직을 담았기에 의미가 있음
        final Future<ResultDto> future = threadPoolExecutor.submit(job, resultDto);
        final Future<ResultDto> future2 = threadPoolExecutor.submit(job2, resultDto);

        // 두 비동기 작업을 block으로 기다린 뒤에 결과를 출력하는 작업 생성
        final ResultCallback resultCallback = new ResultCallback(future, future2, threadPoolExecutor);

        // 두 비동기 작업을 block으로 기다린 뒤 결과를 출력하는 작업을 쓰레드풀 작업큐에 전달
        threadPoolExecutor.submit(resultCallback);

        // block으로 기다리는 작업도 쓰레드풀에서 다른 스레드로 실행하기에 메인스레드는 바로 이어서 다음 작업을 수행할 수 있음
        System.out.println("명령 전달 완료!");
    }
}
