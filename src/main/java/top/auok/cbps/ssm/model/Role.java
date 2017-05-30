package top.auok.cbps.ssm.model;

import java.io.Serializable;

import top.auok.cbps.ssm.model.base.Entity;

public class Role implements Serializable, Entity {
    private Long id;

    private String roleName;

    private String roleCode;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    public String getRoleCode() {
        return roleCode;
    }

    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }
}