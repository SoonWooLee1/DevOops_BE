package com.devoops.oopslog.follow.query.controller;

import com.devoops.oopslog.follow.query.dto.FollowFeedItemDto;
import com.devoops.oopslog.follow.query.dto.FollowerResponseDto;
import com.devoops.oopslog.follow.query.service.FollowQueryService;
import com.devoops.oopslog.member.command.dto.UserImpl;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/follow")
//@RequestMapping("/follow")
@RequiredArgsConstructor
public class FollowQueryController {

    private final FollowQueryService followQueryService;

    /**
     * 특정 유저의 팔로잉 목록 조회 (Read)
     */
    @GetMapping("/following/my")
    public ResponseEntity<List<FollowerResponseDto>> getFollowingList(
            @AuthenticationPrincipal UserImpl user) {
        Long userId = user.getId();
        return ResponseEntity.ok(followQueryService.getFollowingList(userId));
    }

    /**
     * 특정 유저의 팔로워 목록 조회 (Read)
     */
    @GetMapping("/followers/my")
    public ResponseEntity<List<FollowerResponseDto>> getFollowerList(
            @AuthenticationPrincipal UserImpl user) {
        Long userId = user.getId();
        return ResponseEntity.ok(followQueryService.getFollowerList(userId));
    }

    /**
     * 팔로잉 피드 조회 API 엔드포인트
     */
    @GetMapping("/feed/my")
    public ResponseEntity<List<FollowFeedItemDto>> getMyFollowingFeed(
            @AuthenticationPrincipal UserImpl user) {
        Long userId = user.getId();
        return ResponseEntity.ok(followQueryService.getFollowingFeed(userId));
    }
}