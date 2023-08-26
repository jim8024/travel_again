package com.acorn.work.controller;

import com.acorn.core.utils.ResponseUtils;
import com.acorn.work.dto.PlannerDTO;
import com.acorn.work.service.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequiredArgsConstructor
public class PlannerController {

    private final PlannerService plannerService;

    @PostMapping("/planner/save")
    @ResponseBody
    public ResponseEntity save(@RequestBody PlannerDTO plannerDTO) {
        plannerService.plannerSave(plannerDTO);
        return ResponseUtils.completed(plannerDTO);

    }
}
