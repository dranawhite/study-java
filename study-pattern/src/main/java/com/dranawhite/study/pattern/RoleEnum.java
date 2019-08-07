package com.dranawhite.study.pattern;

import org.apache.commons.lang3.StringUtils;

/**
 *
 * @author dranawhite
 * @version : RoleEnum.java, v 0.1 2019-08-07 11:26 dranawhite Exp $$
 */
public enum RoleEnum {

    ROOT,
    ADMIN,
    COMMON,
    NULL;

    public static RoleEnum findByName(String role) {
        RoleEnum roleEnum = RoleEnum.NULL;
        for (RoleEnum roleType : RoleEnum.values()) {
            if (roleType == RoleEnum.NULL) {
                continue;
            }
            if (StringUtils.equalsIgnoreCase(roleType.name(), role)) {
                roleEnum = roleType;
                break;
            }
        }
        return roleEnum;
    }

}
