// 플래너 디테일 페이지
import { Grid, IconButton } from "@mui/material";
import React from "react";
import "./css/DetailPage.css";
import Tabs from "./Tabs";

export default function DetailPage() {
  // 로컬 데이터 필요
  // 필요 목록 title, locImage, location, date, day
  return (
    <div className="detail-page-container">
      <Grid item className="image-container" sx={{ margin: "auto" }}>
        <p className="font-kor" style={{ zIndex: "1" }}>
          {/* korTitle */}
          대한민국 서울
        </p>
        <p className="font-eng" style={{ zIndex: "1" }}>
          {/* engTitle */}
          SEOUL
        </p>
        <img
          className="img"
          src="/locimages/seoul.jpg"
          alt="seoul"
          style={{ width: "100%", height: "100%" }}
        />
      </Grid>

      <Grid container className="categori">
        {/*Tabs 에서  사용하는 컴포넌트가 몇줄 없어서 가져올지 생각중*/}
        <Tabs />
      </Grid>
    </div>
  );
}
