package com.dranawhite.study.pattern.memento;

/**
 * 备忘录模式，保存用户的当期状态，进行历史恢复
 *
 * @author dranawhite
 * @version : Main.java, v 0.1 2019-08-14 11:44 dranawhite Exp $$
 */
public class Main {

    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();
        caretaker.setMemento(originator.createMemento());
        originator.restoreMemento(caretaker.getMemento());
    }
}
