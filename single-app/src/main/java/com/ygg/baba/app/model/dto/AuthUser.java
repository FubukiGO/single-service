package com.ygg.baba.app.model.dto;

import com.google.common.collect.Lists;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.List;

/**
 * @author akhan
 * @description
 * @date 12:32 2018-12-04
 */
@Data
public class AuthUser implements UserDetails {

    private Integer id;
    private String phone;
    private String pwd;
    private String name;
    private Integer status;
    /**
     * token版本
     */
    private Date jwtVersion;
    /**
     * 登陆ip
     */
    private String clientIp;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> roleList = Lists.newArrayList();
        roleList.add(() -> "ROLE_USER");
        return roleList;
    }

    @Override
    public String getPassword() {
        return pwd;
    }

    @Override
    public String getUsername() {
        return phone;
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
}
