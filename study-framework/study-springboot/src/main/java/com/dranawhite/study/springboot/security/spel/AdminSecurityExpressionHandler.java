package com.dranawhite.study.springboot.security.spel;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.expression.EvaluationContext;
import org.springframework.security.access.expression.method.DefaultMethodSecurityExpressionHandler;
import org.springframework.security.access.expression.method.MethodSecurityExpressionOperations;
import org.springframework.security.authentication.AuthenticationTrustResolverImpl;
import org.springframework.security.core.Authentication;

/**
 * @author dranawhite
 * @version : AdminSecurityExpressionHandler.java, v 0.1 2019-08-09 11:42 dranawhite Exp $$
 */
public class AdminSecurityExpressionHandler extends DefaultMethodSecurityExpressionHandler {

    @Override
    public void setReturnObject(Object returnObject, EvaluationContext ctx) {
        AdminMethodSecurityExpressionRoot expressionRoot = (AdminMethodSecurityExpressionRoot) ctx.getRootObject().getValue();
        assert expressionRoot != null;
        expressionRoot.setReturnObject(returnObject);
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
                                                                              MethodInvocation invocation) {
        AdminMethodSecurityExpressionRoot expressionRoot = new AdminMethodSecurityExpressionRoot(authentication);
        expressionRoot.setThis(invocation.getThis());
        expressionRoot.setPermissionEvaluator(getPermissionEvaluator());
        expressionRoot.setTrustResolver(new AuthenticationTrustResolverImpl());
        expressionRoot.setRoleHierarchy(getRoleHierarchy());
        return expressionRoot;
    }
}
