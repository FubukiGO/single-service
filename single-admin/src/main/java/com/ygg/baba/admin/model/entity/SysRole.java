package com.ygg.baba.admin.model.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.security.core.GrantedAuthority;

import java.io.Serializable;
import java.util.Date;

/**
 * <p>
 *
 * </p>
 *
 * @author baba
 * @since 2018-09-29
 */
@Data
@TableName("sys_role")
@EqualsAndHashCode(callSuper = false)
public class SysRole extends Model<SysRole> implements GrantedAuthority {

    private static final long serialVersionUID = 1L;

    @TableId(value = "role_id", type = IdType.AUTO)
    private Integer roleId;
    @TableField("role_name")
    private String roleName;
    @TableField("role_code")
    private String roleCode;
    @TableField("role_desc")
    private String roleDesc;
    @TableField("ins_user_id")
    private Integer insUserId;
    @TableField("create_time")
    private Date createTime;
    @TableField("modified_time")
    private Date modifiedTime;
    /**
     * 删除标识（0-正常,1-删除）
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 备注
     */
    private String remark;

    @Override
    public String getAuthority() {
        return roleCode;
    }

    @Override
    protected Serializable pkVal() {
        return this.roleId;
    }

    @Override
    public String toString() {
        return "SysRole{" +
                ", roleId=" + roleId +
                ", roleName=" + roleName +
                ", roleCode=" + roleCode +
                ", roleDesc=" + roleDesc +
                ", createTime=" + createTime +
                ", updateTime=" + modifiedTime +
                ", delFlag=" + delFlag +
                ", remark=" + remark +
                "}";
    }
}
