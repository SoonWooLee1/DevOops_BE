package com.devoops.oopslog.ooh.command.repository;

import com.devoops.oopslog.ooh.command.entity.OohCommandEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// JpaRepository<OohCommandEntity, 이부분> 뒤에는 PK가 들어가야함
public interface OohCommandRepository extends JpaRepository<OohCommandEntity, Long> {
}
