package com.acorn.travelagain.mybatis.mapper;

import com.acorn.travelagain.mybatis.dto.DemoDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface MybatisDemoMapper {
  List<DemoDTO> retrieveDemo();

}
