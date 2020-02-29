package com.bonade.visitor.domain.remote;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.io.Serializable;

/**
 * description 用户注册信息
 *
 * @author wangy QQ 837195190
 * <p>Created by wangy on 2019/8/21.</p>
 */
@ApiModel(value = "UserRegisterFormVo", description = "用户注册信息")
public class UserRegisterFormVo implements Serializable {

    private static final long serialVersionUID = -8211650725712996128L;

    @ApiModelProperty(value = "id", example = "", required = true)
    private Long id;

    /**
     * 手机号
     */
    @NotBlank(message = "手机号不能为空")
    @Pattern(regexp = "1[3456789]\\d{9}", message = "手机号码格式不正确")
    @ApiModelProperty(value = "手机号码", example = "13311112222", required = true)
    private String phone;

    /**
     * 密码
     */
    @NotBlank(message = "密码不能为空")
    @ApiModelProperty(value = "密码", example = "123456", required = true)
    private String password;

    /**
     * 验证码
     */
    @NotBlank(message = "验证码不能为空")
    @ApiModelProperty(value = "验证码", example = "123456", required = true)
    private String verifyCode;

    @ApiModelProperty(value = "邮箱", example = "123456", required = true)
    private String email;

    @ApiModelProperty(value = "性别 1男，2女 0未知", example = "", required = true)
    private GenderType gender;

    @ApiModelProperty(value = "姓名", example = "", required = true)
    private String realName;

    @ApiModelProperty(value = "证件类型 身份证 0，军官证 1，护照 2，港澳通行证3", example = "", required = true)
    private CertificateType certificateType;

    @ApiModelProperty(value = "证件编号", example = "", required = true)
    private String cartNo;

    @ApiModelProperty(value = "启用1 禁用本地系统访问2 禁用所有系统3", example = "", required = true)
    private UserStatus status;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getVerifyCode() {
        return verifyCode;
    }

    public void setVerifyCode(String verifyCode) {
        this.verifyCode = verifyCode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public GenderType getGender() {
        return gender;
    }

    public void setGender(GenderType gender) {
        this.gender = gender;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public CertificateType getCertificateType() {
        return certificateType;
    }

    public void setCertificateType(CertificateType certificateType) {
        this.certificateType = certificateType;
    }

    public String getCartNo() {
        return cartNo;
    }

    public void setCartNo(String cartNo) {
        this.cartNo = cartNo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public UserStatus getStatus() {
        return status;
    }

    public void setStatus(UserStatus status) {
        this.status = status;
    }
}
