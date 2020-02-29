package com.bonade.visitor.domain.vo;

import com.bonade.visitor.domain.entity.AbnormalImg;
import com.bonade.visitor.domain.enums.AbnormalCase;
import com.bonade.visitor.domain.enums.VisitorAttribute;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import org.spin.common.vo.VoEntityMapper;

import java.util.List;

/**
 *
 * @ClassName: InvitationVo
 * @Description:异常图片 VO
 * @author: lcq
 * @date: 2019年12月9日 下午3:11:08
 * @version 1.0
 */
@ApiModel(value = "AbnormalImgVo", description = "异常图片")
public class AbnormalImgVo implements VoEntityMapper<AbnormalImgVo, AbnormalImg> {

    @ApiModelProperty(value = "id", name = "id", example = "")
    private Long id;

    @ApiModelProperty(value = "异常图片地址", name = "imgUrl", example = "")
    private String imgUrl;

	@ApiModelProperty(value = "异常类型 1异常凭证捕图 2预约申请异常信息图像", name = "imgType", example = "")
	private Integer imgType;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public Integer getImgType() {
        return imgType;
    }

    public void setImgType(Integer imgType) {
        this.imgType = imgType;
    }
}
