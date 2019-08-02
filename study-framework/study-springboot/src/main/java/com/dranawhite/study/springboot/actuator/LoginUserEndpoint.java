package com.dranawhite.study.springboot.actuator;

import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.web.annotation.WebEndpoint;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *    WebEndpoint定义HTTP端点
 * </pre>
 *
 * @author String
 * @version : LoginUserEndpoint.java, v 0.1 2019-08-02 15:49 String Exp $$
 */
@WebEndpoint(id = "login-users", enableByDefault = false)
@Configuration
public class LoginUserEndpoint {

    @Autowired
    private UserVO user;

    @ReadOperation
    public Map<String, Object> userSummary() {
        Map<String, Object> msgMap = new HashMap<>(16);
        msgMap.put("userId", user.getId());
        msgMap.put("userName", user.getName());
        return msgMap;
    }

    @ReadOperation
    public UserVO userDetail(@Selector int id) {
        if (user.getId() == id) {
            return user;
        }
        user.setId(id);
        return user;
    }

    @WriteOperation
    public void updateUserName(@Selector int id, String name) {
        if (user.getId() == id) {
            user.setName(name);
        }
    }

}