package com.dranawhite.study.pattern.state;

/**
 * @author dranawhite
 * @version : OpeningState.java, v 0.1 2019-08-14 13:59 dranawhite Exp $$
 */
public class OpeningLiftState extends AbstractLiftState implements LiftState {

    public OpeningLiftState(LiftContext liftContext) {
        this.context = liftContext;
    }

    @Override
    public void close() {
        System.out.println("Closing!");
        context.setCurStatus(LiftStatusEnum.CLOSE);
    }

}
