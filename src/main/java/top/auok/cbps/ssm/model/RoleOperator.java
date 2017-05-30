package top.auok.cbps.ssm.model;

import java.io.Serializable;

import top.auok.cbps.ssm.model.base.Entity;

public class RoleOperator implements Serializable, Entity {
    private Long id;

    private Long roleId;

    private Long oprId;

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

    public Long getOprId() {
        return oprId;
    }

    public void setOprId(Long oprId) {
        this.oprId = oprId;
    }
}