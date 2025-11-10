package com.devoops.oopslog.report.command.repository;

import com.devoops.oopslog.report.command.entity.CommentsEntity;
import com.devoops.oopslog.report.command.entity.OohRecordEntity;
import com.devoops.oopslog.report.command.entity.OopsRecordEntity;
import com.devoops.oopslog.report.command.entity.ReportEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReportRepository extends JpaRepository<ReportEntity, Long>{
    // 동일한 신고글 신고 불가
    boolean existsByOohId(OohRecordEntity ooh);

    boolean existsByOopsId(OopsRecordEntity oops);

    boolean existsByCommentId(CommentsEntity comment);
}
