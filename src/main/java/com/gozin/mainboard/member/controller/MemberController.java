package com.gozin.mainboard.member.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.member.dto.MemberDTO;
import com.gozin.mainboard.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * <pre>
 * Class : MemberController
 * Comment: 메인보드 회원 컨트롤러
 * History
 * ================================================================
 * DATE             AUTHOR           NOTE
 * ----------------------------------------------------------------
 * 2022-10-08         이유리           최초 생성
 * 2022-10-08         이유리           회원 정보 update api 생성
 * 2022-10-08         이유리           회원 정보 조회 api 생성
 * </pre>
 *
 * @author 이유리
 * @version 1(클래스 버전)
 * @see
 */

@RestController
@RequestMapping("/members")
public class MemberController {

    private final MemberService memberService;


    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO> findMemberById(@RequestHeader String memberId){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 정보 조회 성공", memberService.findMemberById(memberId)));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> update(@RequestBody MemberDTO memberDTO){

        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원정보 수정 성공", memberService.update(memberDTO)));
    }



}
