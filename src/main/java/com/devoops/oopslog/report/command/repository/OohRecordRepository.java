package com.devoops.oopslog.report.command.repository;

import com.devoops.oopslog.report.command.entity.OohRecordEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OohRecordRepository extends JpaRepository<OohRecordEntity,Long> {
}
