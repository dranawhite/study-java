package com.dranawhite.pattern.command;

/**
 * 命令模式
 * <pre>
 *      类图参照：/docs/command.png
 * </pre>
 * <pre>
 * 优点：
 *      1）能够较容易的设计一个命令队列；
 *      2）在需要的情况下，可以较容易的将命令记入日志；
 *      3）允许接收请求的一方决定是否要否决请求；
 *      4）可以容易的实现对请求的撤销与重做；
 *      5）由于加进新的具体命令类不影响其它的类，因此增加一个新的具体命令类很容易；
 * <b><i>注意：命令模式的重点在于可以取消和重做，只有需要这些功能时才设计为命令模式；</i></b>
 * </pre>
 * <pre>
 *     适用场景：事务，状态条，线程池等可以回退的场景
 * </pre>
 *
 * @author dranawhite 2017/8/18
 * @version 1.0
 */
class Main {

    public static void main(String[] args) {
        Receiver receiver = new Receiver();
        Command command = new ConcreteCommand(receiver);
        Invoker invoker = new Invoker();
        invoker.setCommand(command);
        invoker.executeCommand();
    }

}
