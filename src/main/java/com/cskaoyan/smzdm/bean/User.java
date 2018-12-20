package com.cskaoyan.smzdm.bean;

import javax.validation.constraints.Pattern;

public class User {

    private String id;

    //@Pattern(regexp = "(\\w|[\\u2E80-\\u9FFF]){3,16}",message = "用户名不合法")
    private String name;

    //@Pattern(regexp = "\\w{6,18}",message = "密码不合法")
    private String password;

    //@Pattern(regexp = "https?://([\\w-]+\\.)+[\\w-]+(/[\\w-./?%&=]*)?",message = "你输入的链接不合法!")
    private String headUrl;



    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getHeadUrl() {
        return headUrl;
    }

    public void setHeadUrl(String headUrl) {
        this.headUrl = headUrl;
    }

}
