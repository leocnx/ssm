package top.auok.cbps.ssm.model;

import java.io.Serializable;
import java.util.Random;

import top.auok.cbps.ssm.model.base.Entity;

public class Operator implements Serializable, Entity {
    private Long id;

    private String realName;

    private String loginName;

    private String loginPwd;

    private String oprStatus;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName == null ? null : loginName.trim();
    }

    public String getLoginPwd() {
        return loginPwd;
    }

    public void setLoginPwd(String loginPwd) {
        this.loginPwd = loginPwd == null ? null : loginPwd.trim();
    }

    public String getOprStatus() {
        return oprStatus;
    }

    public void setOprStatus(String oprStatus) {
        this.oprStatus = oprStatus == null ? null : oprStatus.trim();
    }
    
    public String getCredentialsSalt() {
		return loginName + "8d78869f470951332959580424d4bf4f";
	}
}