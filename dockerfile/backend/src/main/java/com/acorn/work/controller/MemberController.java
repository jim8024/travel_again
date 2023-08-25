package com.acorn.work.controller;

import com.acorn.work.dto.MemberDTO;
import com.acorn.work.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/member/")
public class MemberController {

    @Autowired
    private MemberService memberService;

    @GetMapping("insert")

    public void insert(MemberDTO dto){

    }
}
