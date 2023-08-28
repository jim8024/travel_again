package com.acorn.work.controller;

import com.acorn.core.utils.ResponseUtils;
import com.acorn.work.dto.PlannerDTO;
import com.acorn.work.service.PlannerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequiredArgsConstructor
@RequestMapping("/planner")
public class PlannerController {

    private final PlannerService plannerService;

    /**
     * 플래너 저장
     * @param plannerDTO
     * @return palnnerDTO
     */
    @PostMapping("/insert")
    @ResponseBody
    public ResponseEntity plannerInsert(@RequestBody PlannerDTO plannerDTO) {
        plannerService.plannerInsert(plannerDTO);
        return ResponseUtils.completed(plannerDTO);
    }

    @GetMapping("/list")
    @ResponseBody
    public ResponseEntity plannerList(){

        return ResponseUtils.completed(plannerService.plannerList());
    }

    @GetMapping("")
    @ResponseBody
    public ResponseEntity plannerDetail(@RequestParam String plannerNo){
        PlannerDTO plannerDTO = plannerService.plannerDetail(plannerNo);
        return ResponseUtils.completed(plannerDTO);
    }


}
