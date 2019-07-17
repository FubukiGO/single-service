package com.ygg.wx.admin.model.vo;

import com.baomidou.mybatisplus.annotation.TableField;
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
    private BigDecimal totalBalance;
    @ApiModelProperty(value = "是否设置交易密码 0-未设置 1-已设置")
    private Integer isSetTranspwd;

    @ApiModelProperty(value = "是否是存在指纹验证")
    private Integer isSafe;

    @ApiModelProperty(value = "是否默认查询喜欢平台")
    private Integer isWatchful;

    @ApiModelProperty(value = "基本资料是否已经补全")
    private Integer isCompletion;

    @ApiModelProperty(value = "邀请码")
    private String inviteCode;

    @ApiModelProperty("所在省份")
    private String localProvince;

    @ApiModelProperty("所在城市")
    private String localCity;

    @ApiModelProperty("个性签名")
    private String personalizedSignature;

    @ApiModelProperty("联系人")
    private String linkPhone;

    @ApiModelProperty("昵称")
    private String nickName;

    @ApiModelProperty("发布数")
    private Integer countRelease;

    @ApiModelProperty("承接数")
    private Integer countHold;

    @ApiModelProperty("成交数")
    private Integer countSuccess;

    @ApiModelProperty("优惠券数量")
    private Integer countCoupon;

    @TableField("是否显示QQ 1 是 0 否")
    private Integer showQqCode;

    @TableField("是否显示联系号码 1 是 0 否")
    private Integer showLinkPhone;

    @TableField("展示时间内（天）成功交易订单 0 不展示")
    private Integer showSucceeRecord;

}
