package com.acorn.example.jpa.repository;

import com.acorn.example.jpa.dto.DemoDTO;
import com.acorn.example.jpa.entity.DemoEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface DemoMapper {
  DemoMapper INSTANCE = Mappers.getMapper(DemoMapper.class);

  List<DemoDTO> toDemoEntirys(List<DemoEntity> demoEntities);

}
