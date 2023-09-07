package com.acorn.work.servicees.tour.service;

import com.acorn.work.es.dto.ResponsePageDTO;
import com.acorn.work.es.dto.searchresponse.SearchResDTO;
import com.acorn.work.servicees.tour.doc.TourListDoc;
import com.acorn.work.servicees.tour.dto.TourListEcDTO;
import com.acorn.work.servicees.tour.dto.TourListeReqDTO;
import com.acorn.work.servicees.tour.mapper.EcMapper;
import com.acorn.work.servicees.tour.repository.TourListDocRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.SearchHit;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class TourListService {

    private final TourListDocRepository tourListDocRepository;

    // 테스트용

    public List<TourListEcDTO> getTourList() {
        List<TourListDoc> tourListDocs = tourListDocRepository.findAll();
        return EcMapper.INSTANCE.toTourListEcDTOs(tourListDocs);
    }

    public List<TourListEcDTO> getTourListByTitle(String title) {
        List<TourListDoc>  tourListDocs = tourListDocRepository.findByTitle(title);
        return  EcMapper.INSTANCE.toTourListEcDTOs(tourListDocs);

    }

    public ResponsePageDTO getTourListByTitle(String title, Pageable pageable) {
        Page<TourListDoc> tourListDocPage = tourListDocRepository.findByTitle(title, pageable);
        return  ResponsePageDTO.setResponsePageDTO(tourListDocPage);

    }

    public List<TourListEcDTO> getTourListByOverview(String overview) {
        return EcMapper.INSTANCE.toTourListEcDTOs(tourListDocRepository.findByOverview(overview));
    }



    public ResponsePageDTO getTourListByOverview(String overview, Pageable pageable) {
        Page<TourListDoc> tourListDocPage = tourListDocRepository.findByOverview(overview, pageable);
        return  ResponsePageDTO.setResponsePageDTO(tourListDocPage);

    }

    public ResponsePageDTO findHitsByOverview(String overview, Pageable pageable) {
        Page<SearchHit<TourListDoc>> tourListDocPage = tourListDocRepository.findHitsByOverview(overview, pageable);
        return ResponsePageDTO.setResponsePageDTO(tourListDocPage);

    }

    public SearchResDTO findTourListDocByMatch(TourListeReqDTO tourListeReqDTO) {
        return tourListDocRepository.getQueryMatch(tourListeReqDTO, TourListEcDTO.class);

    }

}