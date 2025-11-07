package com.devoops.oopslog.bookmark.command.service;

import com.devoops.oopslog.bookmark.command.dto.BookmarkRequestDto;
import com.devoops.oopslog.bookmark.command.entity.Bookmark;
import com.devoops.oopslog.bookmark.command.repository.BookmarkCommandRepository;
import com.devoops.oopslog.member.command.entity.Member;
import com.devoops.oopslog.member.command.repository.MemberCommandRepository;

import com.devoops.oopslog.ooh.command.entity.OohRecord;
import com.devoops.oopslog.ooh.command.repository.OohRecordCommandRepository;
import com.devoops.oopslog.oops.command.entity.OopsRecord;
import com.devoops.oopslog.oops.command.repository.OopsRecordCommandRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Slf4j
@Service
@RequiredArgsConstructor
public class BookmarkCommandService {

    // CUD용 JPA 리포지토리
    private final BookmarkCommandRepository bookmarkCommandRepository;
    // 의존하는 공통 엔티티 리포지토리
    private final MemberCommandRepository memberCommandRepository;
    private final OohRecordCommandRepository oohRecordCommandRepository;
    private final OopsRecordCommandRepository oopsRecordCommandRepository;

    private static final String TYPE_OOH = "ooh";
    private static final String TYPE_OOPS = "oops";

    /**
     * 북마크 추가 C (JPA)
     */
    @Transactional
    public void addBookmark(BookmarkRequestDto request) {
        Long userId = request.getUserId();
        Long recordId = request.getRecordId();
        String recordType = request.getRecordType();

        log.info("[COMMAND] Attempting add bookmark: userId={}, type={}, recordId={}",
                userId, recordType, recordId);

        Member user = memberCommandRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        Bookmark bookmark = new Bookmark();
        bookmark.setUser(user);

        if (TYPE_OOH.equalsIgnoreCase(recordType)) {
            OohRecord ooh = oohRecordCommandRepository.findById(recordId)
                    .orElseThrow(() -> new NoSuchElementException("Ooh record not found"));
            if (bookmarkCommandRepository.existsByUserAndOohRecord(user, ooh)) {
                log.warn("[COMMAND] Add bookmark failed: Already bookmarked. userId={}, recordId={}", userId, recordId);
                throw new IllegalStateException("Already bookmarked this Ooh record");
            }
            bookmark.setOohRecord(ooh);
        } else if (TYPE_OOPS.equalsIgnoreCase(recordType)) {
            OopsRecord oops = oopsRecordCommandRepository.findById(recordId)
                    .orElseThrow(() -> new NoSuchElementException("Oops record not found"));
            if (bookmarkCommandRepository.existsByUserAndOopsRecord(user, oops)) {
                log.warn("[COMMAND] Add bookmark failed: Already bookmarked. userId={}, recordId={}", userId, recordId);
                throw new IllegalStateException("Already bookmarked this Oops record");
            }
            bookmark.setOopsRecord(oops);
        } else {
            log.error("[COMMAND] Add bookmark failed: Invalid record type. type={}", recordType);
            throw new IllegalArgumentException("Invalid record type. Must be 'ooh' or 'oops'.");
        }

        bookmarkCommandRepository.save(bookmark);

        log.info("[COMMAND] Successfully added bookmark: userId={}, bookmarkId={}", userId, bookmark.getId());
    }

    /**
     * 북마크 삭제 D (JPA)
     */
    @Transactional
    public void removeBookmark(BookmarkRequestDto request) {
        Long userId = request.getUserId();
        Long recordId = request.getRecordId();
        String recordType = request.getRecordType();

        log.info("[COMMAND] Attempting remove bookmark: userId={}, type={}, recordId={}",
                userId, recordType, recordId);

        Member user = memberCommandRepository.findById(userId)
                .orElseThrow(() -> new NoSuchElementException("User not found"));

        if (TYPE_OOH.equalsIgnoreCase(recordType)) {
            OohRecord ooh = oohRecordCommandRepository.findById(recordId)
                    .orElseThrow(() -> new NoSuchElementException("Ooh record not found"));
            bookmarkCommandRepository.deleteByUserAndOohRecord(user, ooh);
        } else if (TYPE_OOPS.equalsIgnoreCase(recordType)) {
            OopsRecord oops = oopsRecordCommandRepository.findById(recordId)
                    .orElseThrow(() -> new NoSuchElementException("Oops record not found"));
            bookmarkCommandRepository.deleteByUserAndOopsRecord(user, oops);
        } else {
            log.error("[COMMAND] Remove bookmark failed: Invalid record type. type={}", recordType);
            throw new IllegalArgumentException("Invalid record type. Must be 'ooh' or 'oops'.");
        }

        log.info("[COMMAND] Successfully removed bookmark (if existed): userId={}, type={}, recordId={}",
                userId, recordType, recordId);
    }
}