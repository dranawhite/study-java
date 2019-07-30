package com.dranawhite.study.springboot.model.user;

import com.dranawhite.study.springboot.model.BaseVO;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色
 *
 * @author dranawhite
 * @version : RoleVO.java, v 0.1 2019-07-27 15:40 dranawhite Exp $$
 */
@Setter
@Getter
public class RoleVO extends BaseVO {

    private Integer id;

    private String name;

    private RoleTypeEnum roleType;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
