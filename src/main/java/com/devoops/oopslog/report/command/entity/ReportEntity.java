package com.devoops.oopslog.report.command.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Entity
@Table(name = "report")
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ReportEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 신고자
    @Column(name = "report_date")
    private Date reportDate;

    @Column(name = "state")
    private String state;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id", nullable = false)
    private ReportCategoryEntity categoryId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private MemberEntity userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ooh_id")
    private OohRecordEntity oohId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oops_id")
    private OopsRecordEntity oopsId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "comment_id")
    private CommentsEntity commentId;
}
