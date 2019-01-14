package com.java.java8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.*;

/**
 * @auther: wynnzuo
 * @date: 2019/1/14 14:28
 * @description:通过手动使用线程模拟掷骰子事件 掷两次骰子得分概率
 */
public class ManualDiceRolls1 {
    private static final int N = 100000000;
    private final double fraction;
    private final Map<Integer, Double> results;
    private final int numberOfThreads;
    private final ExecutorService executor;
    private final int workPerThread;
    public static void main(String[] args) {
        ManualDiceRolls1 roles = new ManualDiceRolls1();
        roles.simulateDiceRoles();
    }

    public ManualDiceRolls1() {
        fraction = 1.0 / N;
        results = new ConcurrentHashMap<>();
        numberOfThreads = Runtime.getRuntime().availableProcessors();
        executor = Executors.newFixedThreadPool(numberOfThreads);
        workPerThread = N / numberOfThreads;
    }
    public void simulateDiceRoles() {
        List<Future<?>> futures = new ArrayList<>();
        for (int i = 0; i < numberOfThreads; i++) {
            futures.add(executor.submit(() -> {
                ThreadLocalRandom random = ThreadLocalRandom.current();
                for (int j = 0; j < workPerThread; j++) {
                    int firstThrow = random.nextInt(1, 7);
                    int secondThrow = random.nextInt(1, 7);
                    int entry = firstThrow + secondThrow;

                    results.compute(entry, (key, previous) ->
                            previous == null ? fraction
                                    : previous + fraction
                    );
                }
            }));
        }

        futures.forEach((future) -> {
            try {
                future.get();
            } catch (InterruptedException | ExecutionException e) {
                e.printStackTrace();
            }
        });
        executor.shutdown();
        results.entrySet().forEach(System.out::println);
    }


}