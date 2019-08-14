package com.dranawhite.study.pattern.state;

/**
 *
 * @author dranawhite
 * @version : StoppingState.java, v 0.1 2019-08-14 14:04 dranawhite Exp $$
 */
public class StoppingLiftState extends AbstractLiftState implements LiftState {

    public StoppingLiftState(LiftContext liftContext) {
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
}