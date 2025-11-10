package com.devoops.oopslog.report.command.repository;

import com.devoops.oopslog.report.command.entity.OopsRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OopsRecordRepository extends JpaRepository<OopsRecordEntity,Long> {
}
