package com.devoops.oopslog.report.command.repository;

import com.devoops.oopslog.report.command.entity.MemberEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MemberRepository extends JpaRepository<MemberEntity,Long> {

}
