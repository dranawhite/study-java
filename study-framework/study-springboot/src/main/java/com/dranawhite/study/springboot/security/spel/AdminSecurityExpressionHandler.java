package com.dranawhite.study.springboot.security.spel;

import com.dranawhite.study.springboot.model.user.UserVO;

import org.aopalliance.intercept.MethodInvocation;
import org.springframework.context.ApplicationContext;
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

    private ApplicationContext applicationContext;

    @Override
    public void setReturnObject(Object returnObject, EvaluationContext ctx) {
        AdminMethodSecurityExpressionRoot expressionRoot = (AdminMethodSecurityExpressionRoot) ctx.getRootObject().getValue();
        assert expressionRoot != null;
        expressionRoot.setReturnObject(returnObject);
    }

    @Override
    protected MethodSecurityExpressionOperations createSecurityExpressionRoot(Authentication authentication,
                                                                              MethodInvocation invocation) {
        UserVO user = applicationContext.getBean(UserVO.class);
        AdminMethodSecurityExpressionRoot expressionRoot = new AdminMethodSecurityExpressionRoot(authentication, user);
        expressionRoot.setThis(invocation.getThis());
        expressionRoot.setPermissionEvaluator(getPermissionEvaluator());
        expressionRoot.setTrustResolver(new AuthenticationTrustResolverImpl());
        expressionRoot.setRoleHierarchy(getRoleHierarchy());
        return expressionRoot;
    }

    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        super.setApplicationContext(applicationContext);
        this.applicationContext = applicationContext;
    }
}
