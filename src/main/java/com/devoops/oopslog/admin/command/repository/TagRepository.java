package com.devoops.oopslog.admin.command.repository;

import com.devoops.oopslog.admin.command.entity.TagEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TagRepository extends JpaRepository<TagEntity, Long> {
    boolean existsByTagNameAndTagType(String tagName, String tagType);
}
