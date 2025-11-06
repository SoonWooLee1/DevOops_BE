package com.devoops.oopslog.member.command.repository;

import com.devoops.oopslog.member.command.entity.Member;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Member 엔티티의 CUD 및 JPA 기반 조회를 담당하는 리포지토리
 */
public interface MemberCommandRepository extends JpaRepository<Member, Long> {
}