package com.devoops.oopslog.bookmark.query.dto;

import lombok.*;

import java.time.LocalDateTime;
import java.util.Date;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString

public class BookmarkItemDto {
    private Long bookmarkId;       // bookmark 테이블의 PK
    private String recordType;     // "ooh" 또는 "oops"
    private Long recordId;         // Ooh/Oops 원본 글의 PK
    private String title;          // 원본 글 제목
    private String contentSnippet; // 원본 글 내용 일부 (100자)
    private LocalDateTime createDate; // 원본 글 작성일
//    private Date createDate;
    private String authorName;     // 원본 글 작성자 이름
}