package com.acorn.travelagain.jpa.repository;

import com.acorn.travelagain.jpa.dto.DemoDTO;
import com.acorn.travelagain.jpa.entity.DemoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemoMapper {
  DemoMapper INSTANCE = Mappers.getMapper(DemoMapper.class);

  List<DemoDTO> toDemoEntirys(List<DemoEntity> demoEntities);

}
