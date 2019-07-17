package com.ygg.debt.admin.model.dto;

import com.ygg.debt.admin.model.entity.SysRole;
import lombok.Data;

import java.util.List;

/**
 * @author akhan
 * @description 权限pojo
 * @date 下午3:35 2018/8/16
 */
@Data
public class SysRoleDto extends SysRole {
    private Integer roleId;
    private String creatorName;
    private List<Integer> menuIds;
}
