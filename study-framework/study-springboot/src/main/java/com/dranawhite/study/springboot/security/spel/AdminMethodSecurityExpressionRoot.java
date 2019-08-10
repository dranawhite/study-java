package com.dranawhite.study.springboot.security.spel;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.model.user.RoleVO;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.security.access.expression.SecurityExpressionRoot;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.core.Authentication;

/**
 * @author dranawhite
 * @version : AdminMethodSecurityExpressionRoot.java, v 0.1 2019-08-09 11:45 dranawhite Exp $$
 */
public class AdminMethodSecurityExpressionRoot extends SecurityExpressionRoot implements MethodSecurityExpressionOperations {

    private Object filterObject;
    private Object returnObject;
    private Object target;

    /**
     * 模拟从Spring中获取Bean
     */
    private UserVO user;

    AdminMethodSecurityExpressionRoot(Authentication a, UserVO user) {
        super(a);
        this.user = user;
    }

    public boolean isAdmin() {
        for (RoleVO role : user.getRoleList()) {
            if (role.getRoleType() == RoleTypeEnum.ADMIN) {
                return true;
            }
        }
        return true;
    }

    @Override
    public void setFilterObject(Object filterObject) {
        this.filterObject = filterObject;
    }

    @Override
    public Object getFilterObject() {
        return filterObject;
    }

    @Override
    public void setReturnObject(Object returnObject) {
        this.returnObject = returnObject;
    }

    @Override
    public Object getReturnObject() {
        return returnObject;
    }

    /**
     * Sets the "this" property for use in expressions. Typically this will be the "this" property of the {@code
     * JoinPoint} representing the method invocation which is being protected.
     *
     * @param target the target object on which the method in is being invoked.
     */
    void setThis(Object target) {
        this.target = target;
    }

    @Override
    public Object getThis() {
        return target;
    }

}
