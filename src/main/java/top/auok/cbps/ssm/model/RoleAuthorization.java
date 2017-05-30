package top.auok.cbps.ssm.model;

import java.io.Serializable;

import top.auok.cbps.ssm.model.base.Entity;

public class RoleAuthorization implements Serializable, Entity {
    private Long id;

    private Long roleId;

    private Long authId;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public Long getAuthId() {
        return authId;
    }

    public void setAuthId(Long authId) {
        this.authId = authId;
    }
}