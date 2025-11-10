package com.devoops.oopslog.member.query.controller;

import com.devoops.oopslog.member.query.dto.FindPwDTO;
import com.devoops.oopslog.member.query.dto.FindPwResponseDTO;
import com.devoops.oopslog.member.query.dto.FindIdDTO;
import com.devoops.oopslog.member.query.service.MemberQueryService;
import jakarta.mail.MessagingException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

@RestController
@RequestMapping("/member")
public class MemberQueryController {
    private final MemberQueryService memberQueryService;

    public MemberQueryController(MemberQueryService memberQueryService) {
        this.memberQueryService = memberQueryService;
    }

    @PostMapping("/find-id")
    public ResponseEntity<?> findMemberId(@RequestBody FindIdDTO findIdDTO){
        try {
            memberQueryService.findMemberId(findIdDTO);
        } catch (MessagingException | UnsupportedEncodingException e) {
            return ResponseEntity.badRequest().body("이메일 전송에 실패했습니다. - "+e.getMessage());
        }

        return ResponseEntity.ok().build();
    }

    @PostMapping("/find-pw")
    public ResponseEntity<?> findMemberPw(@RequestBody FindPwDTO findPwDTO){
        FindPwResponseDTO findPwResponseDTO = null;
        try {
            findPwResponseDTO = memberQueryService.findMemberPw(findPwDTO);
        } catch (MessagingException | UnsupportedEncodingException e) {
            return ResponseEntity.badRequest().body("이메일 전송에 실패했습니다. - "+e.getMessage());
        }

        return ResponseEntity.ok().body(findPwResponseDTO);
    }
}
