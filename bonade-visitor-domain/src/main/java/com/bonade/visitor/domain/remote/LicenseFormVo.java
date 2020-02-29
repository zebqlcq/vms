package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.core.gson.annotation.PreventOverflow;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

/**
 * description
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2020/2/17.</p>
 */
@ApiModel(description = "证书编辑信息")
public class LicenseFormVo implements Serializable {

    private static final long serialVersionUID = 667366874457286054L;

    /**
     * 主键
     */
    @PreventOverflow
    @ApiModelProperty(value = "主键ID")
    private Long id;
    /**
     * 文件ID
     */
    @ApiModelProperty(value = "文件ID", required = true)
    @NotNull(message = "文件ID不能为空")
    private Long fileId;

    /**
     * 类型编码
     */
    @ApiModelProperty(
        value = "类型编码（数据字典维护,FACE_INFO：人脸信息，CERTIFICATE_POSITIVE：证件信息图像（正面），CERTIFICATE_NEGATIVE：证件信息图像（反面））",
        required = true, allowableValues = "FACE_INFO,CERTIFICATE_POSITIVE,CERTIFICATE_NEGATIVE")
    @NotBlank(message = "类型编码不能为空")
    private String typeCode;

    /**
     * 版本号
     */
    @ApiModelProperty(value = "版本号")
    private Integer version;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getFileId() {
        return fileId;
    }

    public void setFileId(Long fileId) {
        this.fileId = fileId;
    }

    public String getTypeCode() {
        return typeCode;
    }

    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
