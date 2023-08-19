package com.acorn.demo.jpa.repository;

import com.acorn.demo.jpa.dto.DemoDTO;
import com.acorn.demo.jpa.entity.DemoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemoMapper {
  DemoMapper INSTANCE = Mappers.getMapper(DemoMapper.class);

  List<DemoDTO> toDemoEntirys(List<DemoEntity> demoEntities);

}
