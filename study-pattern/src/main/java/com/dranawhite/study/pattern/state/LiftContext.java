package com.dranawhite.study.pattern.state;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dranawhite
 * @version : LiftContext.java, v 0.1 2019-08-14 14:05 dranawhite Exp $$
 */
public class LiftContext {

    @Setter
    @Getter
    private LiftStatusEnum curStatus;

    public LiftContext(LiftStatusEnum curStatus) {
        this.curStatus = curStatus;
    }

    private AbstractLiftState openState = new OpeningLiftState(this);
    private AbstractLiftState closeState = new ClosedLiftState(this);
    private AbstractLiftState runState = new RunningLiftState(this);
    private AbstractLiftState stopState = new StoppingLiftState(this);

    public void process(LiftAction liftAction) {
        switch (liftAction) {
            case CLOSE:
                close();
                break;
            case OPEN:
                open();
                break;
            case RUN:
                run();
                break;
            case STOP:
                stop();
                break;
            default:
                // do nothing
        }
    }

    /**
     * open动作
     */
    private void open() {
        select(curStatus).open();
    }

    private void close() {
        select(curStatus).close();
    }

    private void run() {
        select(curStatus).run();
    }

    private void stop() {
        select(curStatus).stop();
    }

    AbstractLiftState select(LiftStatusEnum curStatus) {
        switch (curStatus) {
            case OPEN:
                return openState;
            case RUN:
                return runState;
            case STOP:
                return stopState;
            case CLOSE:
                return closeState;
            default:
                return null;
        }
    }
}
