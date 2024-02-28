package com.example.GillaIT.web.admin;

import lombok.Getter;
import lombok.Setter;


public class LoginForm {

    private int id;

    @Getter
    @Setter
    private String email;

    @Getter
    @Setter
    private String password;

}
