package com.acorn.example.mybatis.service;

import com.acorn.example.mybatis.dto.DemoDTO;
import com.acorn.example.mybatis.mapper.MybatisDemoMapper;
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
