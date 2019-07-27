package com.dranawhite.study.springboot.model.user;

import com.dranawhite.study.springboot.model.BaseVO;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;

/**
 * @author dranawhite
 * @version : UserVO.java, v 0.1 2019-07-26 11:12 dranawhite Exp $$
 */
@Setter
@Getter
public class UserVO extends BaseVO {

    private static final long serialVersionUID = -6561121986087818190L;

    private Integer id;

    private String name;

    private String email;

    private String address;

    private Integer age;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
