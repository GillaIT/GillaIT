package com.example.GillaIT.domain.entity;

import com.example.GillaIT.domain.member.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "posts")
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column
    private String title;
    @Column
    private String content;
    @Column
    private String[] recruitDate;
    @Column
    private String[] category;

    @OneToOne
    @JoinColumn(name="user_id")
    private Member member;

    @OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE}, fetch = FetchType.LAZY)
    private List<Image> postImages = new ArrayList<>();
}
