package com.dranawhite.study.springboot.redis;

import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import javax.annotation.Resource;

/**
 * RedisTemplate和ValueOperations不是相同的类型，则使用ValueOperations extends PropertyEditorSupport进行转换
 *
 * @author dranawhite
 * @version : UserRedisDAO.java, v 0.1 2019-07-27 14:19 dranawhite Exp $$
 */
@Repository
public class UserRedisDAO {

    @Resource(name = "redisTemplate")
    private ValueOperations<String, UserVO> valOps;

    public void saveUser(UserVO user) {
        valOps.set(String.valueOf(user.getId()), user);
    }

    public UserVO getUser(int id) {
        return valOps.get(id);
    }
}
