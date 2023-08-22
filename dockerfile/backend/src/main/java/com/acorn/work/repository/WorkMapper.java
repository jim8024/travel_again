package com.acorn.work.repository;

import com.acorn.work.dto.TourListDto;
import com.acorn.work.entity.TourlistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WorkMapper {
    WorkMapper INSTANCE = Mappers.getMapper(WorkMapper.class);

    TourListDto toTourlistDTO(TourlistEntity tourlistEntity);
    List<TourListDto> toTourListdto(List<TourlistEntity> tourlistEntity);

    TourlistEntity toTourlistEntity(TourListDto tourlistDTO);
    List<TourlistEntity> toTourlistEntitys(List<TourListDto> tourlistDTO);

}