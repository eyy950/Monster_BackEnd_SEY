package com.practice.board.validator;

import com.practice.board.dto.MemberFormDTO;
import com.practice.board.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;

@Component
@RequiredArgsConstructor
public class CheckEmailValidator extends AbstractValidator<MemberFormDTO> {

    private final MemberRepository memberRepository;

    @Override
    protected void doValidate(MemberFormDTO dto, Errors errors) {
        if(memberRepository.existsByEmail(dto.getEmail())) {
            errors.rejectValue("email", "이메일 중복 오류", "이미 사용중인 이메일 입니다.");
        }
    }
}
