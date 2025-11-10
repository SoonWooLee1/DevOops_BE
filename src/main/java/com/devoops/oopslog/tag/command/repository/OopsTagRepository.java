package com.devoops.oopslog.tag.command.repository;

import com.devoops.oopslog.tag.command.entity.OopsTag;
import com.devoops.oopslog.tag.command.entity.OopsTagPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OopsTagRepository extends JpaRepository<OopsTag, OopsTagPK> {
}
