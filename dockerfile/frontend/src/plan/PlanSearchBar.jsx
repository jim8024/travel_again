import { IconButton, InputBase, Paper } from "@mui/material";
import React, { useState } from "react";
import SearchIcon from "@mui/icons-material/Search";
import axios from "axios"; // axios 라이브러리 추가
import "./css/PlanSearchBar.css";

export default function PlanSearchBar({ onSearch, areaData, page }) {
  const [keyword, setKeyword] = useState("");
  


  const handleSubmit = async (event) => {
    event.preventDefault();

    try {
      if(!keyword){
        keyword=""
      }
      // 검색어를 서버로 전송
      const response = await axios.post(`http://192.168.0.86:9000/tourlist/es/search/${areaData.areacode}?searchValue=${keyword}&page=${page}&size=6`, { keyword });

      // 서버 응답을 처리하거나 필요한 작업을 수행할 수 있습니다.
      console.log("서버 응답:", response.data.data.content);

      // 검색 결과를 상위 컴포넌트로 전달
      onSearch(response.data.data.content); // response.data는 서버 응답 데이터입니다.
      
      
    } catch (error) {
      console.error("검색 요청 실패:", error);
    } 
  };
 
  return (
    <div className="plan-searchBar-grid">
      <Paper
        className="plan-searchBar-container"
        component="form"
        onSubmit={handleSubmit}
        sx={{
          p: "2px 4px",
          display: "flex", 
          borderRadius: "20px",
          boxShadow: " 0 4px 6px rgba(0,0,0,0.30)",
        }}
      >
        <InputBase
          className="plan-searchBar"
          sx={{ ml: 3, flex: 1, fontSize: "14px" }}
          placeholder="검색어를 입력하세요"
          inputProps={{ "aria-label": "#" }}
          name="keyword"
          type="search"
          value={keyword}
          onChange={(e) => setKeyword(e.target.value)}
        />
        <IconButton type="submit" sx={{ p: "10px" }} aria-label="search">
          <SearchIcon style={{ fontSize: "24px" }} />
        </IconButton>
      </Paper>
    </div>
  );
}
