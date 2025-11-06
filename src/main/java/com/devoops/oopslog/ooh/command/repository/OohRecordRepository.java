package com.devoops.oopslog.ooh.command.repository;

import com.devoops.oopslog.ooh.command.entity.OohRecord;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OohRecordRepository extends JpaRepository<OohRecord, Long> {
}