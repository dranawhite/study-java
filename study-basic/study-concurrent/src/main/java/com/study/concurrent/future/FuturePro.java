package com.study.concurrent.future;

import com.dranawhite.common.common.ThreadUnit;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Future 获取结果
 * <pre>
 *     Future, Callable, FutureTask
 * </pre>
 *
 * @author dranawhite
 * @version $Id: FuturePro.java, v 0.1 2019-01-11 19:41 dranawhite Exp $$
 */
public class FuturePro {

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Task task = new Task();
        FutureTask<String> futureTask = new FutureTask<>(task);
        Thread thread = new Thread(futureTask);
        thread.start();
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.isCancelled());
        System.out.println(futureTask.get());
        System.out.println(futureTask.isDone());
        System.out.println(futureTask.isCancelled());
    }

}

class Task implements Callable<String> {

    @Override
    public String call() {
        int counter = 0;
        while (true) {
            ThreadUnit.sleep(5);
            if (counter++ == 4) {
                return "success";
            }
        }
    }
}
