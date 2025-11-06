package com.devoops.oopslog.follow.command.service;

import com.devoops.oopslog.follow.command.entity.Follow;
import com.devoops.oopslog.follow.command.repository.FollowCommandRepository;
import com.devoops.oopslog.member.command.entity.Member;
import com.devoops.oopslog.member.command.repository.MemberCommandRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;

@Service
@RequiredArgsConstructor
public class FollowCommandService {

    // CUD용 JPA 리포지토리
    private final FollowCommandRepository followCommandRepository;
    // Member 엔티티 조회를 위한 공통 리포지토리
    private final MemberCommandRepository memberCommandRepository;

    /**
     * 팔로우 C (JPA)
     */
    @Transactional
    public void follow(Long followerId, Long followeeId) {
        if (followerId.equals(followeeId)) {
            throw new IllegalStateException("Cannot follow yourself");
        }

        Member follower = memberCommandRepository.findById(followerId)
                .orElseThrow(() -> new NoSuchElementException("Follower not found"));
        Member followee = memberCommandRepository.findById(followeeId)
                .orElseThrow(() -> new NoSuchElementException("Followee not found"));

        if (followCommandRepository.existsByFollowerAndFollowee(follower, followee)) {
            throw new IllegalStateException("Already following this user");
        }

        Follow follow = new Follow(follower, followee);
        followCommandRepository.save(follow);
    }

    /**
     * 언팔로우 D (JPA)
     */
    @Transactional
    public void unfollow(Long followerId, Long followeeId) {
        Member follower = memberCommandRepository.findById(followerId)
                .orElseThrow(() -> new NoSuchElementException("Follower not found"));
        Member followee = memberCommandRepository.findById(followeeId)
                .orElseThrow(() -> new NoSuchElementException("Followee not found"));

        if (!followCommandRepository.existsByFollowerAndFollowee(follower, followee)) {
            throw new IllegalStateException("Not following this user");
        }

        followCommandRepository.deleteByFollowerAndFollowee(follower, followee);
    }
}