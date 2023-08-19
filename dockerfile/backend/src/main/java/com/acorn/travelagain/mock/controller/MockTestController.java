package com.acorn.travelagain.mock.controller;

//import com.acorn.core.utils.JsonFileReadUtils;
import com.acorn.core.utils.ResponseUtils;
import com.acorn.travelagain.mock.dto.MockDemoDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.FileNotFoundException;

@RestController
@RequestMapping("/mock/")
public class MockTestController {

//    @GetMapping("/getMockData")
//    public <T> ResponseEntity getMockData() throws FileNotFoundException {
//       T responseData =  JsonFileReadUtils.jsonLoading("demo\\getMockData", MockDemoDTO.class);
//       return ResponseUtils.completed(responseData);
//    }

}
