package com.acorn.travelagain.mybatis.service;

import com.acorn.travelagain.mybatis.dto.DemoDTO;
import com.acorn.travelagain.mybatis.mapper.MybatisDemoMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class MybatisDemoService {
  private final MybatisDemoMapper mybatisDemoMapper;

  public List<DemoDTO> retrieveDemo() {
    return mybatisDemoMapper.retrieveDemo();
  }
}
