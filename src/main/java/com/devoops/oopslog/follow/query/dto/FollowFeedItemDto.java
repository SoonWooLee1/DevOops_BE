package com.devoops.oopslog.follow.query.dto;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

/**
 * 팔로잉 피드 아이템 DTO
 */
@Getter
@Setter
public class FollowFeedItemDto {
    private String recordType;     // "ooh" 또는 "oops"
    private Long recordId;         // Ooh/Oops 원본 글의 PK
    private String title;          // 원본 글 제목
    private String contentSnippet; // 원본 글 내용 일부 (100자)
    private LocalDateTime createDate; // 원본 글 작성일
    private String authorName;     // 원본 글 작성자 이름
}