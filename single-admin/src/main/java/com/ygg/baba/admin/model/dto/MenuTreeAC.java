package com.ygg.baba.admin.model.dto;

import com.ygg.baba.admin.model.entity.Menu;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * @Author: akhan
 * @Description: menuTree字段拓展版
 * @Date: 17:38 2019-02-18
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class MenuTreeAC extends TreeNode {

    private String icon;
    private String name;
    private String url;
    private boolean spread = false;
    private String path;
    private String component;
    private String authority;
    private String redirect;
    private String code;
    private Date createTime;
    private Date updateTime;
    private Integer type;
    private String label;
    private Integer sort;

    public MenuTreeAC(Menu menuVo) {
        this.id = menuVo.getMenuId();
        this.parentId = menuVo.getParentId();
        this.icon = menuVo.getIcon();
        this.name = menuVo.getName();
        this.url = menuVo.getUrl();
        this.path = menuVo.getPath();
        this.component = menuVo.getComponent();
        this.type = menuVo.getType();
        this.label = menuVo.getName();
        this.sort = menuVo.getSort();
        this.createTime = menuVo.getCreateTime();
        this.updateTime = menuVo.getUpdateTime();
    }

}
