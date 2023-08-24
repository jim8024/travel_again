package com.acorn.example.mybatis.mapper;

import com.acorn.example.mybatis.dto.DemoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisDemoMapper {
  List<DemoDTO> retrieveDemo();

}
