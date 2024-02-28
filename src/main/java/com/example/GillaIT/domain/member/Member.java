package com.example.GillaIT.domain.member;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String group_name;

    @Column
    private String email;
    @Column
    private String password;
    @Column
    private String image;
    @Column
    private Boolean is_admin;
    @Column
    private Boolean is_active;
}
