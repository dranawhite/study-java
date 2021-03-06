package com.dranawhite.study.springboot.model.user;

import com.dranawhite.common.validation.annotation.InsertGroup;
import com.dranawhite.study.springboot.model.BaseVO;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

/**
 * @author dranawhite
 * @version : UserVO.java, v 0.1 2019-07-26 11:12 dranawhite Exp $$
 */
@Setter
@Getter
public class UserVO extends BaseVO {

    private static final long serialVersionUID = -6561121986087818190L;

    private Integer id;

    @NotNull(message = "用户名不能为空!", groups = {InsertGroup.class})
    private String name;

    @NotNull(message = "邮箱不能为空!", groups = {InsertGroup.class})
    @Email(message = "邮箱格式错误!", groups = {InsertGroup.class})
    private String email;

    private String address;

    private String phone;

    private Integer age;

    private List<RoleVO> roleList;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
