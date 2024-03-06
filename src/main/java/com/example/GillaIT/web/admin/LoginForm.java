package com.example.GillaIT.web.admin;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class LoginForm {

    private Long id;
    private String email;
    private String password;


}
