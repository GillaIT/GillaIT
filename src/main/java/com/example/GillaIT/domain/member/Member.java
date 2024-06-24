package com.example.GillaIT.domain.member;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Entity
@Getter
@Setter
@Table(name = "users")
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @NotBlank(message = "   * 그룹 이름을 입력해주세요.")
    @Column
    private String group_name;

    @NotBlank(message = "   * 이메일을 입력해주세요.")
    @Email(message = "   * 올바른 형식의 이메일을 입력해주세요.")
    @Column
    private String email;

    @NotNull
    @Size(min = 8, message="   * 8자리 이상의 비밀번호를 입력해주세요.")
    @Column
    private String password;

    @Column
    private String image;

    @Column
    private Boolean is_admin;

    @Column
    private Boolean is_active;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Member member = (Member) o;
        return Objects.equals(id, member.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
