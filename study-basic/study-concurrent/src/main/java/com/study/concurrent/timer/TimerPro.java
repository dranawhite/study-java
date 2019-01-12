package com.study.concurrent.timer;

import com.dranawhite.common.util.ThreadUnit;

import java.io.IOException;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

/**
 * 计时器
 * <pre>
 *     Timer, TimerTask
 * </pre>
 *
 * @author dranawhite
 * @version $Id: TimerPro.java, v 0.1 2019-01-12 10:37 dranawhite Exp $$
 */
public class TimerPro {

    public static void main(String[] args) throws IOException {
        Task task = new Task();
        Timer timer = new Timer();
        System.out.println(new Date());
        timer.schedule(task, 10000, 5000);
        ThreadUnit.sleep(30);
        // 清除任务队列
        task.cancel();
        // 清除任务队列，并将执行任务字段改为false
        timer.cancel();
        System.out.println("End Up!");
    }
}

class Task extends TimerTask {

    @Override
    public void run() {
        System.out.println(new Date());
        System.out.println("I am Coming !");
    }
}