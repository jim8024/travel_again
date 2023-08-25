package com.acorn.work.mapstruct;

import com.acorn.work.dto.PlannerDTO;
import com.acorn.work.entity.PlannerEntity;
import org.mapstruct.factory.Mappers;

public interface PlannerMapper extends StructMapper<PlannerDTO, PlannerEntity> {

    PlannerMapper INSTANCE = Mappers.getMapper(PlannerMapper.class);
}
