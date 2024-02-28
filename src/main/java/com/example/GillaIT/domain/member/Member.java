package com.example.GillaIT.domain.member;

import lombok.Data;

@Data
public class Member {

    private Long id;

    private String group_name;

    private String email;
    private String password;
    private String image;
    private Boolean is_admin;
    private Boolean is_active;
}
