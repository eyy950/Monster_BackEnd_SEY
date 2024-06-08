package com.practice.board.controller;

import com.practice.board.dto.MemberFormDTO;
import com.practice.board.dto.MemberResponseDTO;
import com.practice.board.service.MemberService;
import com.practice.board.validator.CheckEmailValidator;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequiredArgsConstructor
@Slf4j
public class MemberController {

	private final MemberService memberService;
    private final CheckEmailValidator checkEmailValidator;
    
    @GetMapping("/")
    public String Home() {
        return "home";
    }
    @GetMapping("/members/new")
    public String createMemberForm() {
        return "createMemberForm";
    }

    
    /* 유효성 검증 */
    @InitBinder
    public void validatorBinder(WebDataBinder binder) {
        binder.addValidators(checkEmailValidator);
    }


    /**
     * 회원 가입 post
     * @param memberSaveRequestDTO 회원 정보
     * @return 홈페이지
     */
    @PostMapping("/members/new")
    public String createMember(@Valid MemberFormDTO memberFormDTO, Errors errors, Model model) {
        /* 검증 */
        if (errors.hasErrors()) {
            /* 회원가입 실패 시 입력 데이터 유지 */
            model.addAttribute("dto", memberFormDTO);

            /* 유효성 검사를 통과하지 못한 필드와 메세지 핸들링 */
            Map<String, String> validatorResult = memberService.validateHandling(errors);
            for (String key : validatorResult.keySet()) {
                model.addAttribute(key, validatorResult.get(key));
            }

            /* 회원가입 페이지로 리턴 */
            return "redirect:/createMemberForm";
        }

        Long memberId = memberService.join(memberFormDTO);

        return "redirect:/login";
    
    }
    /**
     * 회원 목록 조회
     * @param model
     * @return 회원 목록 페이지
     */
    @GetMapping("/members")
    public String members(Model model) {
        List<MemberResponseDTO> members = memberService.findMembers();
        model.addAttribute("members", members);

        return "memberList";
    }
}