package com.ygg.baba.admin.model.entity;

import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * Created by baba on 2017/10/11.
 */
@Data
public class User implements UserDetails, Serializable {
    private static final long serialVersionUID = 6347632292902557114L;

    /**
     * 主键ID
     */
    private Integer userId;
    /**
     * 用户名
     */
    private String username;
    private String password;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 部门名
     */
    private String deptName;
    /**
     * 工号
     */
    private String jobNumber;
    /**
     * 备份
     */
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
     * 随机盐
     */
    private String salt;
    /**
     * -1 删除   1可用  2禁用
     */
    private String status;
    /**
     * 联系方式
     */
    private String phone;

    /**
     * 头像
     */
    private String avatar;
    /**
     * 部门ID
     */
    private Integer deptId;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 修改时间
     */
    private Date updateTime;

    /**
     * 创建人姓名
     */
    private String creatorName;

    /**
     * 0-正常，1-删除
     */
    private String delFlag;

    private List<? extends GrantedAuthority> roleList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.roleList;
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public String toString() {
        return this.username;
    }

    @Override
    public boolean equals(Object rhs) {
        return this.toString().equals(rhs.toString());
    }

    @Override
    public int hashCode() {
        return username.hashCode();
    }


}