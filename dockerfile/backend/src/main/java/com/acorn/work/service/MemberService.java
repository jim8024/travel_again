package com.acorn.work.service;

import com.acorn.work.dto.MemberDTO;
import com.acorn.work.repository.MemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;

@Service
public class MemberService {

    @Autowired
    MemberRepository memberRepository;
    public void signup(MemberDTO dto){

    }

    @PostMapping("create")
    public ResponseEntity<MemberDTO> createMember(MemberDTO dto) {

//        Member savedMember = memberService.createMember(member);
//        return new ResponseEntity<>(savedMember, HttpStatus.OK);
        return null;
    }
}
