package com.dranawhite.study.springboot.model;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import lombok.Getter;
import lombok.Setter;

/**
 * 支持分页
 *
 * @author dranawhite
 * @version : PageableVO.java, v 0.1 2019-07-26 13:54 dranawhite Exp $$
 */
@Setter
@Getter
public class PageableVO extends BaseVO {

    private Integer pageSize;

    private Integer curPageNo;

    private Integer totalPageNo;

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
