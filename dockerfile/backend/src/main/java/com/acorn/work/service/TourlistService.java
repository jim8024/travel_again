package com.acorn.work.service;

import com.acorn.work.dto.TourlistDTO;
import com.acorn.work.entity.TourlistEntity;
import com.acorn.work.mapstruct.TourlistMapper;
import com.acorn.work.repository.TourlistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class TourlistService {

    private final TourlistRepository tourlistRepository;

    public List<TourlistDTO> getTourlistOnArea(String areacode){
        List<TourlistEntity> tourlistEntities = tourlistRepository.findByAreacode(areacode);
        return TourlistMapper.INSTANCE.toDTOs(tourlistEntities);
    }

    public List<TourlistDTO> getTourlist() {
        List<TourlistEntity> tourlistEntities = tourlistRepository.findAll();
        return TourlistMapper.INSTANCE.toDTOs(tourlistEntities);
    }
}
