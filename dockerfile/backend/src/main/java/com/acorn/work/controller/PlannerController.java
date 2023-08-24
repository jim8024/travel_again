package com.acorn.work.controller;

import com.acorn.work.entity.PlannerEntity;
import com.acorn.work.repository.PlannerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class PlannerController {

    @Autowired
    private PlannerRepository plannerRepository;

    @PostMapping("/plan/save")
    @ResponseBody
    public String save (@RequestBody PlannerEntity plannerEntity){

        plannerRepository.save(plannerEntity);
     return plannerEntity.getMemberId() + "가 planner 만듬 success";
    }
    @ResponseBody
    @GetMapping("/plan/list")
    public List<PlannerEntity> getList(){
        return plannerRepository.findAll();
    }

}
