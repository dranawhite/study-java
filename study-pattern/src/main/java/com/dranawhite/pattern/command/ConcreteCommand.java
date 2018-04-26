package com.dranawhite.pattern.command;

/**
 * 将一个Receiver对象绑定于一个动作，调用接收者相应的操作，以实现execute
 *
 * @author dranawhite 2017/8/18
 * @version 1.0
 */
class ConcreteCommand implements Command {

    private Receiver receiver;

    public ConcreteCommand(Receiver receiver) {
        this.receiver = receiver;
    }

    @Override
    public void execute() {
        receiver.action();
    }
}
