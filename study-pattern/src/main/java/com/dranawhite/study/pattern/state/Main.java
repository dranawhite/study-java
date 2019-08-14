package com.dranawhite.study.pattern.state;

/**
 * 状态机模式
 * <pre>
 *     执行结果：
 *     Closing!
 *     Stopping
 *     Opening!
 *
 *     当期状态是OPEN，所以不执行RUN，执行CLOSE后，状态改变，继续向下执行
 * </pre>
 *
 *
 * @author dranawhite
 * @version : Main.java, v 0.1 2019-08-14 14:41 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        LiftContext ctx = new LiftContext(LiftStatusEnum.OPEN);
        ctx.process(LiftAction.RUN);
        ctx.process(LiftAction.CLOSE);
        ctx.process(LiftAction.STOP);
        ctx.process(LiftAction.OPEN);
    }
}
