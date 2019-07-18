package com.ygg.baba.admin.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ygg.baba.admin.mapper.SysMenuMapper;
import com.ygg.baba.admin.model.entity.Menu;
import com.ygg.baba.admin.model.entity.SysMenu;
import com.ygg.baba.admin.service.SysMenuService;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.Map;
import java.util.Set;

/**
 * <p>
 * 菜单权限表 服务实现类
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {

    /**
     * @param role
     * @author akhan
     * @description 通过权限字符串查询菜单
     * @date 下午2:06 2018/8/14
     */
    @Override
    @Cacheable(value = "menu_details", key = "#role + '_menu'")
    public Set<Menu> findMenuByRoleName(String role) {
        return baseMapper.findMenuByRoleName(role);
    }

    /**
     * @param userId
     * @author akhan
     * @description 通过用户id查询菜单
     * @date 下午2:06 2018/8/14
     */
    @Override
    public Set<Menu> findMenuByUserId(Integer userId) {
        return baseMapper.findMenuByUserId(userId);
    }

    /**
     * @param param
     * @Author: akhan
     * @Description: 查询所有菜单
     * @Date: 15:18 2019-02-18
     */
    @Override
    public Set<Menu> findMenuAll(Map param) {
        return baseMapper.findMenuAll(param);
    }

    /**
     * 更新角色菜单
     *
     * @param menu
     * @return
     */
    @Override
    @CacheEvict(value = "menu_details", allEntries = true)
    public Boolean updateMenuById(SysMenu menu) {
        return this.updateById(menu);
    }

    /**
     * 新增菜单
     *
     * @param menu
     * @return
     */
    @Override
    @CacheEvict(value = "menu_details", allEntries = true)
    public Boolean addMenu(SysMenu menu) {
        return this.save(menu);
    }
}
