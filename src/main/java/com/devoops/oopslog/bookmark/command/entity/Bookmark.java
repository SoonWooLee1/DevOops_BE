package com.devoops.oopslog.bookmark.command.entity;

import com.devoops.oopslog.member.command.entity.Member;

import com.devoops.oopslog.ooh.command.entity.OohRecord;
import com.devoops.oopslog.oops.command.entity.OopsRecord;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "bookmark") // DDL 기반
public class Bookmark {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false) // DDL 기반
    private Member user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oops_id") // DDL 기반
    private OopsRecord oopsRecord;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ooh_id") // DDL 기반
    private OohRecord oohRecord;
}