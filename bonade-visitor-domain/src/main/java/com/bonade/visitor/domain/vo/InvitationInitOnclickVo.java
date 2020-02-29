package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 *
 * @ClassName: InvitationVo
 * @Description:发起邀约 VO
 * @author: lcq
 * @date: 2019年12月9日 下午3:11:08
 * @version 1.0
 */
@ApiModel(value = "InvitationInitVo", description = "访问入参vo")
public class InvitationInitOnclickVo {

	@NotNull(message = "企业id不能为空")
	@ApiModelProperty(value = "企业id", name = "enterpriseId", example = "", required = true)
	private Long enterpriseId;
	
	@NotBlank(message = "name不能为空")
	@ApiModelProperty(value = "姓名", name = "name", example = "", required = true)
	private String name;
	
	@NotBlank(message = "电话不能为空")
	@ApiModelProperty(value = "电话", name = "tel", example = "", required = true)
	private String tel;

	public Long getEnterpriseId() {
		return enterpriseId;
	}

	public void setEnterpriseId(Long enterpriseId) {
		this.enterpriseId = enterpriseId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTel() {
		return tel;
	}

	public void setTel(String tel) {
		this.tel = tel;
	}
	
}
