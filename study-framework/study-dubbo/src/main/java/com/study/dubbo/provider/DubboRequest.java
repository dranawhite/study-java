package com.study.dubbo.provider;

import com.dranawhite.api.model.BaseRequest;
import lombok.Data;

import javax.validation.constraints.NotNull;

/**
 * @author liangyq
 * @version [1.0, 2018/4/27 18:50]
 */
@Data
public class DubboRequest extends BaseRequest {

	private static final long serialVersionUID = -8247275488477918692L;

	@NotNull
	private Integer id;

	@NotNull
	private String name;

}
