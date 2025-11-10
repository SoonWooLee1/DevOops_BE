package com.devoops.oopslog.report.command.repository;

import com.devoops.oopslog.report.command.entity.CommentsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CommentsRepository extends JpaRepository<CommentsEntity,Long> {
}
