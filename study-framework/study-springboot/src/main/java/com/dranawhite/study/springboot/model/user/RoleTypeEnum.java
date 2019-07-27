package com.dranawhite.study.springboot.model.user;

/**
 *
 * @author dranawhite
 * @version : RoleTypeEnum.java, v 0.1 2019-07-27 15:43 dranawhite Exp $$
 */
public enum RoleTypeEnum {

    ROOT(1),
    ADMIN(2),
    COMMON(3);

    private int code;

    RoleTypeEnum(int code) {
        this.code = code;
    }

    public int toCode() {
        return this.code;
    }
}
