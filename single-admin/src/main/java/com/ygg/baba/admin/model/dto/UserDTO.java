/*
 *    Copyright (c) 2018-2025, baba All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *
 * Redistributions of source code must retain the above copyright notice,
 * this list of conditions and the following disclaimer.
 * Redistributions in binary form must reproduce the above copyright
 * notice, this list of conditions and the following disclaimer in the
 * documentation and/or other materials provided with the distribution.
 * Neither the name of the pig4cloud.com developer nor the names of its
 * contributors may be used to endorse or promote products derived from
 * this software without specific prior written permission.
 * Author: baba (wzysz888@gmail.com)
 */

package com.ygg.baba.admin.model.dto;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @author baba
 * @date 2017/11/5
 */
@Data
public class UserDTO {

    /**
     * 角色ID
     */
    private List<Integer> role;

    private Integer deptId;

    /**
     * 新密码
     */
    private String newpassword;


    //========================

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
     * 工号
     */
    private String jobNumber;
    /**
     * 备注
     */
    private String remark;
    /**
     * 部门名称
     */
    private String deptName;
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
    private Date createTime;
    /**
     * 修改时间
     */
    private Date modifiedTime;
    /**
     * 0-正常，1-删除
     */
    private String delFlag;
}
