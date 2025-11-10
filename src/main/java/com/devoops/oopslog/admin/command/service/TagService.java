package com.devoops.oopslog.admin.command.service;

import com.devoops.oopslog.admin.command.entity.TagEntity;

public interface TagService {
    TagEntity addTag(String tagName, String tagType);
    void deleteTag(Long tagId);
}
