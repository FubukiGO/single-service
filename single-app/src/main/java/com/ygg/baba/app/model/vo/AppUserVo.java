package com.ygg.baba.app.model.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.math.BigDecimal;

@Data
@ApiModel
public class AppUserVo {

    @ApiModelProperty(value = "用户id")
    private Integer userId;
    @ApiModelProperty(value = "token")
    private String token;
    @ApiModelProperty(value = "姓名")
    private String name;
    @ApiModelProperty(value = "头像")
    private String headUrl;
    @ApiModelProperty(value = "账户余额")
    private BigDecimal balance;
    @ApiModelProperty(value = "是否绑卡")
    private Integer isBindCard;
    @ApiModelProperty(value = "手机号")
    private String phone;
    @ApiModelProperty(value = "QQ号")
    private String qqCode;

    @ApiModelProperty("个性签名")
    private String personalizedSignature;

    @ApiModelProperty("昵称")
    private String nickName;

}
