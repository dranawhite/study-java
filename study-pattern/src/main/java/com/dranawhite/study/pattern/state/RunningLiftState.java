package com.dranawhite.study.pattern.state;

/**
 * @author dranawhite
 * @version : RunningState.java, v 0.1 2019-08-14 14:03 dranawhite Exp $$
 */
public class RunningLiftState extends AbstractLiftState implements LiftState {

    public RunningLiftState(LiftContext liftContext) {
        this.context = liftContext;
    }

    @Override
    public void close() {
        System.out.println("Closing");
    }
}
