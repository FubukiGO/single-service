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
 * 菜单权限表
 * </p>
 *
 * @author baba
 * @since 2018-09-29
 */
@Data
@TableName("sys_menu")
@EqualsAndHashCode(callSuper = false)
public class SysMenu extends Model<SysMenu> {

    private static final long serialVersionUID = 1L;

    @TableField(exist = false)
    private Integer id;

    /**
     * 菜单ID
     */
    @TableId(value = "menu_id", type = IdType.AUTO)
    private Integer menuId;
    /**
     * 菜单名称
     */
    private String name;
    /**
     * 菜单权限标识
     */
    private String permission;
    /**
     * 前端URL
     */
    private String path;
    /**
     * 请求链接
     */
    private String url;
    /**
     * 请求方法
     */
    private String method;
    /**
     * 父菜单ID
     */
    @TableField("parent_id")
    private Integer parentId;
    /**
     * 图标
     */
    private String icon;
    /**
     * VUE页面
     */
    private String component;
    /**
     * 排序值
     */
    private Integer sort;
    /**
     * 菜单类型 （0菜单 1按钮）
     */
    private String type;
    /**
     * 创建时间
     */
    @TableField("create_time")
    private Date createTime;
    /**
     * 更新时间
     */
    @TableField("update_time")
    private Date updateTime;
    /**
     * 0--正常 1--删除
     */
    @TableField("del_flag")
    private String delFlag;
    /**
     * 描述
     */
    private String remark;
    /**
     * 菜单标识
     */
    @TableField("menu_flag")
    private String menuFlag;

    @Override
    protected Serializable pkVal() {
        return this.menuId;
    }

    @Override
    public String toString() {
        return "SysMenu{" +
                ", menuId=" + menuId +
                ", name=" + name +
                ", permission=" + permission +
                ", path=" + path +
                ", url=" + url +
                ", method=" + method +
                ", parentId=" + parentId +
                ", icon=" + icon +
                ", component=" + component +
                ", sort=" + sort +
                ", type=" + type +
                ", createTime=" + createTime +
                ", updateTime=" + updateTime +
                ", delFlag=" + delFlag +
                ", remark=" + remark +
                ", menuFlag=" + menuFlag +
                "}";
    }
}
