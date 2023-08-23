package com.acorn.work.controller;

import com.acorn.work.dto.MemberDTO;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller("/member/")
public class MemberController {

    @GetMapping("insert")
    public void insert(MemberDTO dto){

    }
}
