package com.dranawhite.study.springboot.model.user;

import lombok.Getter;
import lombok.Setter;

import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.authority.mapping.GrantedAuthoritiesMapper;
import org.springframework.security.core.authority.mapping.SimpleAuthorityMapper;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**
 * 用户鉴权类.
 * <pre>
 *     角色的判断是依赖RoleVoter类
 * </pre>
 *
 * @author dranawhite
 * @version : UserSecurityVO.java, v 0.1 2019-07-27 15:48 dranawhite Exp $$
 */
@Setter
@Getter
public class UserSecurityVO extends UserVO implements UserDetails {

    private static final long serialVersionUID = -1943209911896843580L;

    private String name;

    private String password;

    private GrantedAuthoritiesMapper authoritiesMapper;

    public UserSecurityVO() {
        authoritiesMapper = new SimpleAuthorityMapper();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorityList = new ArrayList<>();
        for (RoleVO role : getRoleList()) {
            authorityList.add(new SimpleGrantedAuthority(role.getRoleType().name()));
        }
        return authoritiesMapper.mapAuthorities(authorityList);
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return String.valueOf(getId());
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
        return ToStringBuilder.reflectionToString(this, ToStringStyle.SHORT_PREFIX_STYLE);
    }
}
