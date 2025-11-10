package com.devoops.oopslog.report.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "conmments")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CommentsEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content")
    private String content;

    @Column(name = "create_date")
    private Date createDate;

    @Column(name = "is_deleted")
    private String isDeleted;

    @Column(name = "oops_id")
    private Long oopsId;

    @Column(name = "ooh_id")
    private Long oohId;

    @Column(name = "user_id")
    private Long userId;

    @Column(name = "notice_id")
    private Long noticeId;
}
