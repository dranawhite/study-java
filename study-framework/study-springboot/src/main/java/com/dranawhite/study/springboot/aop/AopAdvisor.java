package com.dranawhite.study.springboot.aop;

import lombok.extern.slf4j.Slf4j;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.DeclareParents;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 增强的执行顺序
 * <pre>
 *     around -> before -> around -> after -> afterReturning
 * </pre>
 *
 * <pre>
 *     AspectJ表达式:* com.dranawhite..aop.*.*(..)
 *     * 表示任意单个元素
 *     ..表示多个元素，但是在表示类时，必须和*联合使用，在表示入参时则单独使用
 *     + 表示按类型匹配指定类的所有类(子类和自身)，必须跟在类名后面
 *     1) 第一个*表示任意返回值
 *     2) 第二个*表示类名
 *     3) 第三个*表示方法
 * </pre>
 *
 * <pre>
 *     运算符
 *     1) and(&&) or(||) not(!)
 * </pre>
 *
 * <pre>
 *     AspectJ函数
 *     1) execution()和within()支持所有通配符
 *     2) args()、this()、target()仅支持+通配符
 *     3) @args()、@within、@target()、@annotation不支持通配符
 *
 *     args()接收一个类名，如args(java.lang.List)表示运行时入参是List的方法，等价于表达式execution(* *(java.lang.List+))和args(java.lang.List+)
 * //  @args()接收注解类类名
 *
 *     within()解析范围到类粒度，如within(com.smart.Waiter)表示匹配目标类Waiter的所有方法
 *     1) within()对于接口的声明是无意义的，必须具体到实现类
 *     2) within(com.smart.*)匹配com.smart包中的所有类，不包括子包
 *     3) within(com.smart..*)匹配com.smart包以及子包中的所有类
 *
 * //  @annotation @args @target @within用于注解
 * </pre>
 *
 * <pre>
 *     execution表达式语法
 *     execution([<修饰符>] <返回类型> <方法名>(<参数>) [<异常>])
 *     1) execution(public * *(..)) 匹配所有的public方法
 *     2) execution(* *To(..))匹配所有以To为后缀的方法
 *     3) execution(* com.dranawhite.study.springboot.aop.IPerson.*(..))匹配IPerson接口的所有方法
 *     4) execution(* com.dranawhite.study.springboot.aop.IPerson+.*(..))匹配IPerson接口以及实现类中的所有方法(接口定义的方法以及实现类定义的方法)
 *     5) execution(* com.dranawhite.*(..))匹配com.dranawhite包下所有类的所有方法
 *     6) execution(* com.dranawhite..*(..))匹配com.dranawhite包以及子包的所有类的所有方法，当..出现在类名中时，后面必须跟*表示包、子包下的所有类
 *     7) execution(* com..*.*Dao.find*(..))匹配com包下任何类名后缀为Dao，且方法名前缀为find的方法
 *     8) execution(* joke(String, int))匹配joke(string,int)方法
 *     9) execution(* joke(String, *))匹配joke(string, *)方法, *表示任意入参类型
 *    10) execution(* joke(List+))匹配joke方法, 该方法只有一个入参，且入参是List或者List的子类型
 * </pre>
 *
 * <pre>
 *     增强的顺序可以通过Ordered接口实现
 *     任何增强的方法都可以在第一个参数传入Joinpoint获取连接点信息
 * </pre>
 *
 * @author dranawhite
 * @version : AopAdvisor.java, v 0.1 2019-08-22 10:33 dranawhite Exp $$
 */
@Aspect
@Component
@Slf4j
public class AopAdvisor {

    /**
     * 为Manager添加IPerson接口，默认继承类是Person
     */
    @DeclareParents(value = "com.dranawhite.study.springboot.aop.Manager", defaultImpl = Person.class)
    public IPerson person;

    @Pointcut("execution(* com.dranawhite.study.springboot.aop.IPerson.say())")
    public void pointCut() {
    }

    @Before("pointCut()")
    public void beforeSay() {
        log.info("Before Say");
    }

    @Around("pointCut()")
    public String aroundSay(ProceedingJoinPoint joinPoint) {
        try {
            log.info("Around Say Before");
            String result = (String) joinPoint.proceed();
            log.info("Around Say After");
            return result;
        } catch (Throwable t) {
            log.error("something wrong");
            return null;
        }
    }

    @AfterReturning(value = "pointCut()", returning = "returnObject")
    public void afterReturn(JoinPoint joinPoint, String returnObject) {
        log.info("After Return");
    }
}