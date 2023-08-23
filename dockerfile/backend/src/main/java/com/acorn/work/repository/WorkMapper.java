package com.acorn.work.repository;

import com.acorn.work.dto.TourListDTO;
import com.acorn.work.entity.TourlistEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface WorkMapper {
    WorkMapper INSTANCE = Mappers.getMapper(WorkMapper.class);

    TourListDTO toTourlistDTO(TourlistEntity tourlistEntity);
    List<TourListDTO> toTourListdto(List<TourlistEntity> tourlistEntity);

    TourlistEntity toTourlistEntity(TourListDTO tourlistDTO);
    List<TourlistEntity> toTourlistEntitys(List<TourListDTO> tourlistDTO);

}