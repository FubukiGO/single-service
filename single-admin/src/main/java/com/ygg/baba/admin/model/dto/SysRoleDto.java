package com.ygg.baba.admin.model.dto;

import com.ygg.baba.admin.model.entity.SysRole;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

/**
 * @author akhan
 * @description 权限pojo
 * @date 下午3:35 2018/8/16
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class SysRoleDto extends SysRole {
    private Integer roleId;
    private String creatorName;
    private List<Integer> menuIds;
}
