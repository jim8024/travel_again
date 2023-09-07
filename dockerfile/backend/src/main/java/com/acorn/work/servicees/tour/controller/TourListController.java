package com.acorn.work.servicees.tour.controller;

import com.acorn.core.utils.ResponseUtils;
import com.acorn.work.servicees.tour.dto.TourListeReqDTO;
import com.acorn.work.servicees.tour.service.TourListService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/tourlist")
public class TourListController {

    private final TourListService tourListService;

    @GetMapping("/es/list")
    public ResponseEntity getList(){
        return ResponseUtils.completed(tourListService.getTourList());
    }

    @GetMapping("/es/title")
    // @RequestParam("title")
    public ResponseEntity getTitle(@RequestParam("searchValue") String searchValue) {
        return ResponseUtils.completed(tourListService.getTourListByTitle(searchValue));
    }

    @GetMapping("/es/title/pageing")
    public ResponseEntity getTitle(@RequestParam("searchValue") String searchValue,
                                   @PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseUtils.completed(tourListService.getTourListByTitle(searchValue, pageable));
    }

    @GetMapping("/es/overview")
    public ResponseEntity getTourListByOverview(@RequestParam("searchValue") String searchValue) {
        return ResponseUtils.completed(tourListService.getTourListByOverview(searchValue));
    }


    @GetMapping("/es/overview/pageing")
    public ResponseEntity getTourListByTitlePage(@RequestParam("searchValue") String searchValue,
                                                 @PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseUtils.completed(tourListService.getTourListByOverview(searchValue, pageable));
    }

    @GetMapping("/es/overview/hits")
    public ResponseEntity getTourListByTitlehits(@RequestParam("searchValue") String searchValue,
                                                 @PageableDefault(size = 10, page = 0) Pageable pageable) {
        return ResponseUtils.completed(tourListService.findHitsByOverview(searchValue, pageable));
    }

    @GetMapping("/es/match")
    public ResponseEntity getTourListByTitlehits( @RequestBody TourListeReqDTO tourListeReqDTO ) {
        return ResponseUtils.completed(tourListService.findTourListDocByMatch(tourListeReqDTO));
    }

}