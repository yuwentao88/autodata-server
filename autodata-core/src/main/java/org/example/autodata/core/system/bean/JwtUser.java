package org.example.autodata.core.system.bean;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Collection;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;
@Getter
@AllArgsConstructor
public class JwtUser implements UserDetails {

    @JsonIgnore
    private final String id;

    private final String username;

    @JsonIgnore
    private final String password;

    private final String avatar;

    private final String email;

    private final String departmentName;

    private final String departmentId;

    private final String departmentCode;

    private final String idNo;

    private final Integer isDefaultPassword;

    @JsonIgnore
    private final Collection<? extends GrantedAuthority> authorities;

    private final boolean enabled;

    private Date createTime;

    @JsonIgnore
    private final Date lastPasswordResetDate;

    @JsonIgnore
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @JsonIgnore
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isEnabled() {
        return enabled;
    }

    /**
     * 在我们保存权限的时候加上了前缀ROLE_，因此在这里需要处理下数据
     * @return
     */
    public Collection getRoles() {
        Set<String> roles = new LinkedHashSet<>();
        for (GrantedAuthority authority : authorities) {
            roles.add(authority.getAuthority().substring(5));
        }
        return roles;
    }
}