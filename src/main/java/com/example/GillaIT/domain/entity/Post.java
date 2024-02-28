package com.example.GillaIT.domain.entity;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

//@Entity
@Getter
@Setter
public class Post {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private String[] recruitDate;
    private String[] category;

    private int userId; // 외래키로 변경
}
