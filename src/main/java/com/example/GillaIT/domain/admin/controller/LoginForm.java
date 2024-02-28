package com.example.GillaIT.domain.admin.controller;

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
