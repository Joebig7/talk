package com.mamba.talk.model.bean;

/**
 * @Author JoeBig7
 * @date 2021/2/18 18:14:27
 */
public class UserBean {

    private Long id;

    private String username;

    private String password;

    private String salt;

    private String portrait;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPortrait() {
        return portrait;
    }

    public void setPortrait(String portrait) {
        this.portrait = portrait;
    }
}
