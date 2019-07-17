package com.ygg.wx.admin.model.entity;

import com.baomidou.mybatisplus.activerecord.Model;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import com.baomidou.mybatisplus.annotations.Version;
import com.baomidou.mybatisplus.enums.IdType;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * <p>
 * H5   用户表
 * </p>
 *
 * @author baba
 * @since 2018-09-25
 */
@Data
@TableName("t_app_user")
public class TAppUser extends Model<TAppUser> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;
    /**
     * 注册手机号
     */
    private String phone;
    /**
     * 密码
     */
    private String pwd;
    /**
     * 姓名
     */
    private String name;

    @TableField("qq_code")
    private String qqCode;
    @TableField("mail")
    private String mail;
    /**
     * 头像
     */
    @TableField("head_url")
    private String headUrl;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 修改时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 1-h5  2-安卓 3-IOS 4-众人富
     */
    private BigDecimal source;
    /**
     * 账户余额
     */
    private BigDecimal balance;

    @TableField("is_bind_card")
    private Integer isBindCard;

    @TableField("is_set_transpwd")
    private Integer isSetTranspwd;


    @TableField("trans_password")
    private String transPassword;

    @TableField("recharge_switch")
    private Integer rechargeSwitch;

    @TableField("withdraw_switch")
    private Integer withdrawSwitch;

    @TableField("shop_switch")
    private Integer shopSwitch;

    @TableField("last_login_time")
    private Date lastLoginTime;

    private Integer status;

    private String ip;
    @TableField("last_login_ip")
    private String lastLoginIp;

    @TableField("today_date")
    private Date todayDate;

    @TableField("count_error_login")
    private Integer countErrorLogin;

    @TableField("is_safe")
    private Integer isSafe;

    @TableField("is_watchful")
    private Integer isWatchful;

    @TableField("is_completion")
    private Integer isCompletion;

    @TableField("jwt_version")
    private Date jwtVersion;

    @Version
    private Integer version;

    @TableField("invite_code")
    private String inviteCode;

    @TableField("invite_id")
    private Integer inviteId;

    @TableField("is_first")
    private Integer isFirst;

    @TableField("local_province")
    private String localProvince;

    @TableField("local_city")
    private String localCity;

    @TableField("nick_name")
    private String nickName;

    @TableField("personalized_signature")
    private String personalizedSignature;

    @TableField("link_phone")
    private String linkPhone;

    @TableField("show_qq_code")
    private Integer showQqCode;

    @TableField("show_link_phone")
    private Integer showLinkPhone;

    @TableField("show_succee_record")
    private Integer showSucceeRecord;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "TAppUser{" +
                ", id=" + id +
                ", phone=" + phone +
                ", pwd=" + pwd +
                ", name=" + name +
                ", headUrl=" + headUrl +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", source=" + source +
                ", balance=" + balance +
                "}";
    }
}
