package com.ygg.baba.admin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 * 用户表
 * </p>
 *
 * @author baba
 * @since 2018-09-29
 */
@Data
@TableName("sys_user")
@EqualsAndHashCode(callSuper = false)
public class SysUser extends Model<SysUser> {

    private static final long serialVersionUID = 1L;

    /**
     * 主键ID
     */
    @TableId(value = "user_id", type = IdType.AUTO)
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    private String password;
    /**
     * 真实姓名
     */
    @TableField("real_name")
    private String realName;
    /**
     * 工号
     */
    @TableField("job_number")
    private String jobNumber;
    /**
     * 部门名称
     */
    @TableField("dept_name")
    private String deptName;
    /**
     * 备注
     */
    @TableField("remark")
    private String remark;
    /**
     * 邮箱
     */
    private String mail;
    /**
     * 性别 1男 0女
     */
    private Integer sex;
    /**
     * 0冻结 1可用
     */
    private String status;
    /**
     * 最后登录时间
     */
    @TableField("last_login_time")
    private Date lastLoginTime;
    /**
     * 联系方式
     */
    private String phone;
    /**
     * 头像
     */
    private String avatar;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 添加人
     */
    @TableField("ins_user_id")
    private Integer insUserId;
    /**
     * 修改时间
     */
    @TableField("modified_time")
    private Date modifiedTime;
    /**
     * 0-正常，1-删除
     */
    @TableField("del_flag")
    private String delFlag;

    @Override
    protected Serializable pkVal() {
        return this.userId;
    }

    @Override
    public String toString() {
        return "SysUser{" +
                ", userId=" + userId +
                ", username=" + username +
                ", password=" + password +
                ", realName=" + realName +
                ", jobNumber=" + jobNumber +
                ", mail=" + mail +
                ", sex=" + sex +
                ", status=" + status +
                ", lastLoginTime=" + lastLoginTime +
                ", phone=" + phone +
                ", avatar=" + avatar +
                ", createTime=" + createTime +
                ", modifiedTime=" + modifiedTime +
                ", delFlag=" + delFlag +
                "}";
    }
}
