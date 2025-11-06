package com.devoops.oopslog.oops.command.repository;


import com.devoops.oopslog.oops.command.entity.OopsRecord;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * OopsRecord 엔티티의 CUD 및 JPA 기반 조회를 담당하는 리포지토리
 */
public interface OopsRecordCommandRepository extends JpaRepository<OopsRecord, Long> {
}