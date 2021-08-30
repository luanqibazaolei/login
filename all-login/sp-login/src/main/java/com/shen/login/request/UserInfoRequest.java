package com.shen.login.request;

import lombok.Data;

import java.io.Serializable;

@Data
public class UserInfoRequest implements Serializable {

    /**
     *
     */
    private static final long serialVersionUID = -5847365907705354182L;

    /**
     *
     */
    private String username;

    private String password;

    private String gender;

}
