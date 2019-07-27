package com.dranawhite.study.springboot.batch;

import com.dranawhite.study.springboot.model.user.RoleTypeEnum;
import com.dranawhite.study.springboot.model.user.RoleVO;
import com.dranawhite.study.springboot.model.user.UserVO;

import org.springframework.batch.item.validator.ValidatingItemProcessor;

import java.util.ArrayList;
import java.util.List;

/**
 * 数据处理以及校验
 *
 * @author dranawhite
 * @version : CsvItemProcessor.java, v 0.1 2019-07-27 18:16 dranawhite Exp $$
 */
public class CsvItemProcessor extends ValidatingItemProcessor<UserVO> {

    @Override
    public UserVO process(UserVO item) {
        super.process(item);
        RoleVO role = new RoleVO();
        role.setName(RoleTypeEnum.COMMON.name());
        role.setRoleType(RoleTypeEnum.COMMON);
        role.setId(1);
        List<RoleVO> roleList = new ArrayList<>();
        roleList.add(role);
        item.setRoleList(roleList);
        return item;
    }
}
