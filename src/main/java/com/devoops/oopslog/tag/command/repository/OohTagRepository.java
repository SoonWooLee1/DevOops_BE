package com.devoops.oopslog.tag.command.repository;

import com.devoops.oopslog.tag.command.entity.OohTag;
import com.devoops.oopslog.tag.command.entity.OohTagPK;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OohTagRepository extends JpaRepository<OohTag, OohTagPK> {
}
