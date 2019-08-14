package com.dranawhite.study.pattern.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * 备忘录管理员
 * <pre>
 *     对备忘录进行管理、保存和提供备忘录
 * </pre>
 *
 * @author dranawhite
 * @version : Caretaker.java, v 0.1 2019-08-14 11:37 dranawhite Exp $$
 */
@Setter
@Getter
public class Caretaker {

    private Memento memento;
}
