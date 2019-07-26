package com.study.boot.web;

import com.study.boot.model.User;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

/**
 * <pre>
 * 结果:
 * Thread = http-nio-8080-exec-1
 * Thread = http-nio-8080-exec-10
 * Thread = http-nio-8080-exec-11
 * Thread = http-nio-8080-exec-12
 * Thread = http-nio-8080-exec-13
 * Thread = http-nio-8080-exec-14
 * Thread = http-nio-8080-exec-15
 * Thread = http-nio-8080-exec-16
 * Thread = http-nio-8080-exec-17
 * Thread = http-nio-8080-exec-18
 * Thread = http-nio-8080-exec-19
 * Thread = http-nio-8080-exec-2
 * Thread = http-nio-8080-exec-2
 * Thread = http-nio-8080-exec-20
 * Thread = http-nio-8080-exec-21
 * Thread = http-nio-8080-exec-22
 * Thread = http-nio-8080-exec-23
 * Thread = http-nio-8080-exec-24
 * Thread = http-nio-8080-exec-25
 * Thread = http-nio-8080-exec-26
 * Thread = http-nio-8080-exec-27
 * Thread = http-nio-8080-exec-28
 * Thread = http-nio-8080-exec-4
 * Thread = http-nio-8080-exec-5
 * Thread = http-nio-8080-exec-6
 * Thread = http-nio-8080-exec-7
 * Thread = http-nio-8080-exec-8
 * Thread = http-nio-8080-exec-9
 * </pre>
 *
 * <pre>
 *     用jmeter压测50个请求线程，实际只有28个，其它线程都是复用
 * </pre>
 *
 * @author dranawhite
 * @version $Id: WebController.java, v 0.1 2019-01-15 20:21 dranawhite Exp $$
 */
@RestController
@RequestMapping(value = "/web")
public class WebController {

    @RequestMapping(value = "/thread/test")
    public void testThreadPool(HttpServletRequest request) {
        System.out.println("ThreadLocal = " + ThreadLocalUtils.get());
        System.out.println("Request = " + request.hashCode());
        System.out.println("Thread = " + Thread.currentThread().getName());
    }

    @GetMapping(value = "/user/{id}")
    public void testUser(@ModelAttribute User user) {
        // web/user/12?name=tom&address=南京&age=19
        // 将path和param中的参数映射到Model中
        System.out.println("id: " + user.getId());
        System.out.println("name: " + user.getName());
        System.out.println("address: " + user.getAddress());
        System.out.println("age: " + user.getAge());
    }
}
