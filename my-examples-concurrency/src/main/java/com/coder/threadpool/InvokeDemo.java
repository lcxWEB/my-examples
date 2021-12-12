package com.coder.threadpool;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author: lichunxia
 * @create: 2021-04-09 13:14
 */
public class InvokeDemo {

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        List<Callable<Integer>> callableList = new ArrayList<>(10);
        callableList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                System.out.println(1);
                return 1;
            }
        });
        callableList.add(new Callable<Integer>() {
            @Override
            public Integer call() throws Exception {
                try {
                    Thread.sleep(1000);
                    System.out.println(2);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                return 2;
            }
        });

        try {
            Integer integer = executorService.invokeAny(callableList);
            System.out.println(integer);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }
}
