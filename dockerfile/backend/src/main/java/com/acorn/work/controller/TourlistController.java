package com.acorn.work.controller;

import com.acorn.core.utils.ResponseUtils;
import com.acorn.work.dto.TourlistDTO;
import com.acorn.work.service.TourlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
@ResponseBody
public class TourlistController {

    private final TourlistService tourlistService;

    @GetMapping("/tourlist/area")
    public ResponseEntity getTourlistFindByArea(String areacode) {
        System.out.println(areacode);
        List<TourlistDTO> tourlistDTOs = tourlistService.getTourlistOnArea(areacode);
        return ResponseUtils.completed(tourlistDTOs);
    }




}
