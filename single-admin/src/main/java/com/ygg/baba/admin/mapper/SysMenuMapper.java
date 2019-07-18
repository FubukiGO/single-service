package com.ygg.baba.admin.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.ygg.baba.admin.model.entity.Menu;
import com.ygg.baba.admin.model.entity.SysMenu;
import org.apache.ibatis.annotations.Param;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 Mapper 接口
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
public interface SysMenuMapper extends BaseMapper<SysMenu> {

    /**
     * @param role
     * @author akhan
     * @description 通过权限字符串查询菜单
     * @date 下午2:06 2018/8/14
     */
    Set<Menu> findMenuByRoleName(@Param("role") String role);

    /**
     * @param userId
     * @author akhan
     * @description 通过用户id查询菜单
     * @date 下午2:06 2018/8/14
     */
    Set<Menu> findMenuByUserId(@Param("userId") Integer userId);

    /**
     * @param param
     * @Author: akhan
     * @Description: 查询所有菜单
     * @Date: 15:18 2019-02-18
     */
    Set<Menu> findMenuAll(@Param("n") Map param);

}
