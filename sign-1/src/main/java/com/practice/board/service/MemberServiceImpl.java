package com.practice.board.service;

import com.practice.board.domain.Member;
import com.practice.board.dto.MemberFormDTO;
import com.practice.board.dto.MemberResponseDTO;
import com.practice.board.repository.MemberRepository;
import com.practice.board.service.MemberService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;
import org.springframework.validation.FieldError;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Transactional
@Service			// 내가 서비스다
@RequiredArgsConstructor	// 밑에 MemberRepository의 생성자를 쓰지 않기 위해서
public class MemberServiceImpl implements MemberService {
	@Autowired
    private final MemberRepository memberRepository;
    private final PasswordEncoder passwordEncoder;
    
    @Override
    public Long join(MemberFormDTO memberFormDTO) {
    	if (memberRepository.existsByEmail(memberFormDTO.getEmail())) {
            throw new RuntimeException("이미 가입된 이메일 주소입니다.");
        }

        String encodedPassword = passwordEncoder.encode(memberFormDTO.getPassword());
        Member member = Member.builder()
                .email(memberFormDTO.getEmail())
                .username(memberFormDTO.getUsername())
                .password(encodedPassword)
                .build();

        Member savedMember = memberRepository.save(member);
        return savedMember.getId();
    }
    

    @Override
    public List<MemberResponseDTO> findMembers() {
        List<Member> all = memberRepository.findAll();
        List<MemberResponseDTO> members = new ArrayList<>();

        for (Member member : all) {
            MemberResponseDTO build = MemberResponseDTO.builder()
                    .member(member) // 올바른 멤버 정보를 받아서 넣어줘야 함
                    .build();
            members.add(build);
        }

        return members;
    }
    @Transactional(readOnly = true)
    @Override
    public Map<String, String> validateHandling(Errors errors) {
        Map<String, String> validatorResult = new HashMap<>();

        /* 유효성 및 중복 검사에 실패한 필드 목록을 받음 */
        for (FieldError error : errors.getFieldErrors()) {
            String validKeyName = String.format("valid_%s", error.getField());
            validatorResult.put(validKeyName, error.getDefaultMessage());
        }

        return validatorResult;
    }
    
}