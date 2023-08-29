package com.acorn.work.service;

import com.acorn.work.dto.MemberDTO;
import com.acorn.work.mapstruct.MemberMapper;
import com.acorn.work.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class MemberService {

    private final MemberRepository memberRepository;
    public void signup(MemberDTO memberDTO){
        memberRepository.save(MemberMapper.INSTANCE.toEntity(memberDTO));
    }

    public String getMemberNoByMemberId(String memberId){
        MemberDTO memberDTO = MemberMapper.INSTANCE.toDTO(memberRepository.findByMemberId(memberId));
        return memberDTO.getMemberNo();
    }

    public void signIn(MemberDTO memberDTO) {
        memberRepository.findByMemberIdAndPwd(memberDTO.getMemberId(),memberDTO.getPwd());
    }
}
