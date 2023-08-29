package com.acorn.work.controller;

import com.acorn.core.utils.ResponseUtils;
import com.acorn.work.dto.TourlistDTO;
import com.acorn.work.service.TourlistService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@RequiredArgsConstructor
@Controller
@ResponseBody
@RequestMapping("/tourlist")
public class TourlistController {

    private final TourlistService tourlistService;

    /**
     * 전체 tourlist 목록
     * @return List<TorulistDTO>
     */
    @GetMapping("/list")
    public ResponseEntity getTourlist(){
        List<TourlistDTO> tourlistDTOs = tourlistService.getTourlist();
        return ResponseUtils.completed(tourlistDTOs);
    }


    /**
     * areacode 에 대한 목록
     * @param areacode
     * @return List<TourlistDTO> where areacode = ?
     */
    @GetMapping("/area")
    public ResponseEntity getTourlistFindByArea(String areacode) {
        System.out.println(areacode);
        List<TourlistDTO> tourlistDTOs = tourlistService.getTourlistOnArea(areacode);
        return ResponseUtils.completed(tourlistDTOs);
    }




}
