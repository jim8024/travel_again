import "./whereToGo.css";
import * as React from "react";
import SearchIcon from "@mui/icons-material/Search";
import IconButton from "@mui/material/IconButton";
import { Divider, InputBase, Paper } from "@mui/material";
import MenuIcon from "@mui/icons-material/Menu";
import DirectionsIcon from "@mui/icons-material/Directions";

function WhereToGo() {
  return (
    <div className="wtg-container">
      <h2>어디로 여행을 떠나시나요?</h2>
      <div className="searchBar-grid">
      <Paper
        className="searchBar-container"
        component="form"
        sx={{
          p: "2px 4px",
          display: "flex",
          borderRadius:"20px",
          boxShadow:" 0 4px 6px rgba(0,0,0,0.30)"
        }}
      >
        <InputBase
          className="searchBar"
          sx={{ ml: 3, flex: 1 }}
          placeholder="지역명을 검색해 주세요"
          inputProps={{ "aria-label": "#" }}
        />
        <IconButton type="button" sx={{ p: "10px"}} aria-label="search">
          <SearchIcon style={{fontSize:"37px"}}/>
        </IconButton>
      </Paper>
      </div>
    </div>
  );
}

export default WhereToGo;
