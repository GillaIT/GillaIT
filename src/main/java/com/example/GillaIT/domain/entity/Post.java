package com.example.GillaIT.domain.entity;

import java.util.List;

//@Entity
public class Post {
//    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    private int[] recruitDate;
    private String[] category;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int[] getRecruitDate() {
        return recruitDate;
    }

    public void setRecruitDate(int[] recruitDate) {
        this.recruitDate = recruitDate;
    }

    public String[] getCategory() {
        return category;
    }

    public void setCategory(String[] category) {
        this.category = category;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    private int userId; // 외래키로 변경
}
