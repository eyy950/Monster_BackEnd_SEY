package com.practice.board.service;


import java.util.List;
import java.util.Map;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.validation.Errors;

import com.practice.board.dto.MemberFormDTO;
import com.practice.board.dto.MemberResponseDTO;
@Transactional
public interface MemberService {
	/**
     * 회원 목록 조회
     * @return 회원 정보 목록
     */
    List<MemberResponseDTO> findMembers();
	/**
     * 회원가입 시, 유효성 및 중복 검사
     * @param errors
     * @return
     */
    Map<String, String> validateHandling(Errors errors);
    Long join(MemberFormDTO memberFormDTO);
}
