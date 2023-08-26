package com.acorn.work.service;

import com.acorn.work.dto.PlannerDTO;
import com.acorn.work.mapstruct.PlannerMapper;
import com.acorn.work.repository.PlannerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PlannerService {

    private final PlannerRepository plannerRepository;

    public void plannerSave(PlannerDTO plannerDTO){
        plannerRepository.save(PlannerMapper.INSTANCE.toEntity(plannerDTO));
    }

}
