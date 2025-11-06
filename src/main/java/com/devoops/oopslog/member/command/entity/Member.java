package com.devoops.oopslog.member.command.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "member") //
public class Member {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //

    @Column(name = "member_id", nullable = false) //
    private String memberId;

    @Column(name = "member_pw", nullable = false) //
    private String memberPw;

    @Column(name = "email", nullable = false) //
    private String email;

    @Column(name = "name", nullable = false) //
    private String name;

    @Column(name = "birth", nullable = false) //
    private LocalDate birth;

    @Column(name = "gender", nullable = false, length = 1) //
    private String gender;

    @Column(name = "user_state", length = 1) //
    private String userState;

    @Column(name = "sign_up_date", nullable = false) //
    private LocalDate signUpDate;
}