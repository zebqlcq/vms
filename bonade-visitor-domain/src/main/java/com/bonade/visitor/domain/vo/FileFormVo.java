package com.bonade.visitor.domain.vo;

import javax.validation.constraints.NotBlank;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(description = "base64文件上传Vo")
public class FileFormVo {

    @NotBlank(message = "文件base64不能为空")
    @ApiModelProperty(value = "文件base64", example = "", required = true)
    private String base64;
    
    @NotBlank(message = "文件名称不能为空")
    @ApiModelProperty(value = "文件名称", example = "", required = true)
    private String fileName;

	public String getBase64() {
		return base64;
	}

	public void setBase64(String base64) {
		this.base64 = base64;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Override
	public String toString() {
		return "FileFormVo [base64=" + base64 + ", fileName=" + fileName + "]";
	}
	
}
