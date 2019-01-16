package com.study.spring.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

/**
 * 基于AspectJ的引入增强
 * <pre>
 *     DeclareParents引入增强
 * </pre>
 *
 * @author dranawhite 2017/8/18
 */
@Aspect
@Component
class PersonAspectIntroduction {

    /**
     * <pre>
     *     value表示目标类
     *     defaultImpl表示引入接口的默认实现类
     * </pre>
     */
    @DeclareParents(value = "com.dranawhite.spring.aop.Person", defaultImpl = ApolopyImpl.class)
    private Apolopy apolopy;

}
