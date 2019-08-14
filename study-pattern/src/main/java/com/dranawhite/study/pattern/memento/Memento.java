package com.dranawhite.study.pattern.memento;

import lombok.Getter;
import lombok.Setter;

/**
 * 备忘录角色
 * <pre>
 *     负责存储Originator发起人对象的内部状态
 * </pre>
 *
 * @author dranawhite
 * @version : Memento.java, v 0.1 2019-08-14 11:37 dranawhite Exp $$
 */
@Setter
@Getter
public class Memento {

    private String state;
}
