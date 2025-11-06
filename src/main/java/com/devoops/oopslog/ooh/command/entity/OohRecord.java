package com.devoops.oopslog.ooh.command.entity;

import com.devoops.oopslog.member.command.entity.Member;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "ooh_record") //
public class OohRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id; //

    @Column(name = "is_private", length = 1) //
    private String isPrivate;

    @Column(name = "title", nullable = false) //
    private String title;

    @Column(name = "content", nullable = false, length = 2000) //
    private String content;

    @Column(name = "ai_answer", length = 2000) //
    private String aiAnswer;

    @Column(name = "create_date") //
    private LocalDateTime createDate;

    @Column(name = "modify_date") //
    private LocalDateTime modifyDate;

    @Column(name = "is_deleted", length = 1) //
    private String isDeleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) //
    private Member user;
}