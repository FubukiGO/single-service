package com.ygg.baba.admin.controller;

import cn.hutool.core.collection.CollectionUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.ygg.baba.admin.model.dto.UserDTO;
import com.ygg.baba.admin.model.entity.SysUser;
import com.ygg.baba.admin.model.entity.SysUserRole;
import com.ygg.baba.admin.model.entity.User;
import com.ygg.baba.admin.security.AuthManager;
import com.ygg.baba.admin.service.SysRoleService;
import com.ygg.baba.admin.service.SysUserService;
import com.ygg.baba.common.annotation.RequestRequire;
import com.ygg.baba.common.constants.CommonConstant;
import com.ygg.baba.common.exception.BusinessException;
import com.ygg.baba.common.util.Query;
import com.ygg.baba.common.util.R;
import com.ygg.baba.common.web.BaseController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * <p>
 * 用户表 前端控制器
 * </p>
 *
 * @author yy
 * @since 2018-08-13
 */
@RestController
@RequestMapping("sysUser")
@Api(description = "后台用户管理", tags = "后台用户管理")
public class SysUserController extends BaseController {
    private static final BCryptPasswordEncoder ENCODER = new BCryptPasswordEncoder();

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private SysRoleService sysRoleService;

    /**
     * 分页查询信息
     *
     * @param params 分页对象
     * @return 分页对象
     */
    @PostMapping("/page")
    @ApiOperation(value = "分页查询用户列表", notes = "username,phone", response = User.class)
    public R page(@RequestBody Map<String, Object> params) {

        params.put(CommonConstant.DEL_FLAG, CommonConstant.STATUS_NORMAL);
        IPage<User> page = sysUserService.selectUserPage(new Query<>(params), params);
        page.getRecords().forEach(n -> n.setPassword(null));
        page.getRecords().forEach(n -> {
            n.setRoleList(sysRoleService.findRoleByUserId(n.getUserId()));
        });
        return new R<>(page);
    }

    /**
     * 添加用户
     *
     * @param userDto 用户信息
     * @return success/false
     */
    @PostMapping
    @ApiOperation(value = "添加用户", notes = "username,password必填", response = User.class)
    @RequestRequire(parameter = UserDTO.class, require = "username")
    public R<Boolean> user(@RequestBody UserDTO userDto) {
        Integer loginId = AuthManager.getUserId();
        SysUser sysUser = new SysUser();
        SysUser check = new SysUser();

        check.setUsername(userDto.getUsername());
        check.setDelFlag(CommonConstant.STATUS_NORMAL);
        if (check.selectCount(Wrappers.query(check)) > 0) throw new BusinessException("用户名已存在");
        check.setUsername(null);
        check.setPhone(userDto.getPhone());
        //if (check.selectCount(new EntityWrapper<>(check)) > 0) return new R<>(R.FAIL, "手机号已被注册", false);
        check = null;

        BeanUtils.copyProperties(userDto, sysUser);
        sysUser.setDelFlag(CommonConstant.STATUS_NORMAL);
        if (StringUtils.isBlank(userDto.getPassword())) userDto.setPassword("123456");
        sysUser.setPassword(ENCODER.encode(userDto.getPassword()));
        sysUser.setInsUserId(loginId);
        sysUserService.save(sysUser);

        if (userDto.getRole() != null) {
            userDto.getRole().forEach(roleId -> {
                SysUserRole userRole = new SysUserRole();
                userRole.setUserId(sysUser.getUserId());
                userRole.setRoleId(roleId);
                userRole.insert();
            });
        }
        return new R<>(Boolean.TRUE);
    }


    /**
     * 删除
     *
     * @param id ID
     * @return success/false
     */
    @DeleteMapping("/{id}")
    @ApiOperation(value = "删除账户", notes = "", response = User.class)
    public R<Boolean> delete(@PathVariable Integer id) {
        SysUser sysUser = new SysUser();
        sysUser.setDelFlag(CommonConstant.STATUS_DEL);
        sysUser.setUserId(id);
        return new R<>(sysUserService.updateById(sysUser));
    }


    /**
     * 编辑
     *
     * @param userDto 实体
     * @return success/false
     */
    @PutMapping
    @ApiOperation(value = "修改用户", notes = "id必填,修改密码时password必填,修改角色时role传角色id数组", response = User.class)
    @RequestRequire(parameter = UserDTO.class, require = "userId")
    public R<Boolean> edit(@RequestBody UserDTO userDto) {
        SysUser sysUser = new SysUser();
        SysUser check = new SysUser();

        check.setUsername(userDto.getUsername());
        if (check.getUsername() == null && check.selectCount(Wrappers.query(check)) > 0)
            return new R<>(false, "用户名已存在");
        check.setUsername(null);
//        check.setPhone(userDto.getPhone());
//        if (check.getPhone() == null && check.selectCount(new EntityWrapper<>(check)) > 0)
//            return new R<>(false, "手机号已被注册");
        check = null;

        BeanUtils.copyProperties(userDto, sysUser);

        sysUser.updateById();

        if (CollectionUtil.isNotEmpty(userDto.getRole())) {
            SysUserRole userRole = new SysUserRole();
            userRole.setUserId(userDto.getUserId());
            userRole.delete(Wrappers.query(userRole));
            for (Integer n : userDto.getRole()) {
                userRole.setRoleId(n);
                userRole.insert();
            }
        }

        return new R<>(Boolean.TRUE);
    }

    @GetMapping("status_switch/{userId}")
    @ApiOperation(value = "切换用户状态", notes = "", response = User.class)
    public R statusSwitch(@PathVariable Integer userId) {
        SysUser user = sysUserService.getById(userId);

        if (user == null) throw new BusinessException("用户不存在");

        user.setStatus("1".equals(user.getStatus()) ? "0" : "1");
        user.updateById();

        return new R<>(true);
    }
}
