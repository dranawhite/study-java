package com.test.dal.model.origin;

import lombok.Data;
import org.apache.ibatis.type.Alias;

/**
 * @author liangyq
 * @version [V1.0, 2018-05-24]
 */
@Alias("PersonDO")
@Data
public class PersonDO {
    /**
     * ID
     */
    private Integer id;

    /**
     * 姓名
     */
    private String name;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 电话
     */
    private String phone;

    /**
     * 地址
     */
    private String address;

    /**
     * 地址类型
     */
    private Integer addressType;

}