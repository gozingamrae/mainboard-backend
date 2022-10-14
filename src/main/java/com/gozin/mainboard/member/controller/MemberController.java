package com.gozin.mainboard.member.controller;

import com.gozin.mainboard.common.ResponseDTO;
import com.gozin.mainboard.jwt.TokenProvider;
import com.gozin.mainboard.member.dto.BlacklistDTO;
import com.gozin.mainboard.member.dto.ChangePwdDTO;
import com.gozin.mainboard.member.dto.ConditionDTO;
import com.gozin.mainboard.member.dto.MemberDTO;
import com.gozin.mainboard.member.service.MemberService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
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
 * 2022-10-10         이유리           회원 탈퇴 api 생성
 * 2022-10-10         이유리           회원 아이디 찾기 api 생성
 * 2022-10-11         이유리           회원 비밀번호 변경 api 생성
 * 2022-10-12         이유리           회원 아이디 찾기 api 수정
 * 2022-10-12         이유리           전체 회원 조회 api 생성
 * 2022-10-12         이유리           블랙리스트 조회, 등록 api 생성
 * 2022-10-13         이유리           회원 검색 조회 api 생성
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
    public MemberController(MemberService memberService){
        this.memberService = memberService;
    }

    @GetMapping()
    public ResponseEntity<ResponseDTO> findMemberById(@RequestHeader String accessToken){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 정보 조회 성공", memberService.findMemberById(accessToken)));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDTO> update(@RequestBody MemberDTO memberDTO){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원정보 수정 성공", memberService.update(memberDTO)));
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> delete(@RequestHeader String accessToken){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 탈퇴 성공", memberService.delete(accessToken)));
    }

    @PostMapping("/findId")
    public ResponseEntity<ResponseDTO> findId(@RequestBody MemberDTO memberDTO){
        System.out.println("memberDTO = " + memberDTO);
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "아이디 조회 성공", memberService.findId(memberDTO)));
    }

    @PutMapping("/changePwd")
    public ResponseEntity<ResponseDTO> findPwd(@RequestBody ChangePwdDTO changePwdDTO){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 비밀번호 변경 성공", memberService.changePwd(changePwdDTO)));
    }

    @GetMapping("/lists")
    public ResponseEntity<ResponseDTO> findMemberAll (){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 목록 조회 성공", memberService.findMemberAll()));
    }

    @PostMapping("/blacklist")
    public ResponseEntity<ResponseDTO> registBlacklist(@RequestBody BlacklistDTO blacklistDTO){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "블랙리스트 등록 성공", memberService.registBlacklist(blacklistDTO)));
    }

    @GetMapping("/blacklist")
    public ResponseEntity<ResponseDTO> selectBlacklist(){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "블랙리스트 조회 성공", memberService.selectBlacklist()));
    }

    @PostMapping("/condition")
    public ResponseEntity<ResponseDTO> selectMembersByCondition(@RequestBody ConditionDTO condition){
        return ResponseEntity.ok().body(new ResponseDTO(HttpStatus.OK, "회원 조회 성공!", memberService.selectMembersByCondition(condition)));

    }
}
