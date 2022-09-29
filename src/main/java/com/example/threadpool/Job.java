package com.example.threadpool;

public class Job implements Runnable {
    private final ResultDto resultDto;
    private final int seconds;
    private final String key;
    private final Object value;

    public Job(final ResultDto resultDto, final int seconds, final String key, final Object value) {
        this.resultDto = resultDto;
        this.seconds = seconds;
        this.key = key;
        this.value = value;
    }

    @Override
    public void run() {
        System.out.println("sleep for :" + 1000 * seconds);

        try {
            Thread.sleep(1000L * seconds);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }

        System.out.println();
        System.out.println("I'm awake after sleep for " + 1000 * seconds);
        System.out.println("putting data " + "key : " + key + " value : " + value);
        resultDto.addResult(this.key, this.value);
        System.out.println("job done!");
        System.out.println("current data status");
        System.out.println(resultDto.getData());
    }
}
