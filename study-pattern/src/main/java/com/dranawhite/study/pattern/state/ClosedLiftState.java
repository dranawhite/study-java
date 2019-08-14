package com.dranawhite.study.pattern.state;

/**
 *
 * @author dranawhite
 * @version : ClosedState.java, v 0.1 2019-08-14 14:02 dranawhite Exp $$
 */
public class ClosedLiftState extends AbstractLiftState implements LiftState {

    public ClosedLiftState(LiftContext liftContext) {
        this.context = liftContext;
    }

    @Override
    public void run() {
        System.out.println("Running!");
    }

    @Override
    public void open() {
        System.out.println("Opening!");
    }

    @Override
    public void stop() {
        System.out.println("Stopping");
    }
}
