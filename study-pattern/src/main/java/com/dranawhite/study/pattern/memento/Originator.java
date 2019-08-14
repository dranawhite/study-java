package com.dranawhite.study.pattern.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * 发起人角色
 * <pre>
 *     记录当前时刻的内部状态，定义哪些属于备份范围的状态，负责创建和恢复备忘录数据
 * </pre>
 *
 * @author dranawhite
 * @version : Originator.java, v 0.1 2019-08-14 11:36 dranawhite Exp $$
 */
@Setter
@Getter
public class Originator {

    private String state;

    /**
     * 创建备忘录
     *
     * @return memento
     */
    public Memento createMemento() {
        return new Memento();
    }

    /**
     * 恢复备忘录
     *
     * @param memento memento
     */
    public void restoreMemento(Memento memento) {
        state = memento.getState();
    }
}
