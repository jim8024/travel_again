//개요페이지
import { Grid, IconButton } from "@mui/material";
import React, { useEffect, useState } from "react";
import ArrowBackIosIcon from "@mui/icons-material/ArrowBackIos";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";
import  SideMapItem from "../asset/SideMapItem";
import "../css/OutLineForm.css";
import OutLineTable from "./OutLineTable";
import { axios } from "axios";

export default function OutLineForm() {
  // 백 데이터 필요
  const [data, setData] = useState([]);
  const fetchData = async () => {
    try {
      const response = await axios.get("#");
      setData(response.data); // 가져온 데이터를 state에 저장합니다.
    } catch (error) {
      console.error("데이터 가져오기 오류:", error);
    }
  };

  useEffect(() => {
    fetchData();
  }, []);

  return (
    <>
     {data.map((item, index ) => (
          <Grid container className="item-container"> {/* 각 Grid에 고유한 key 부여 */}
            <Grid item className="table-container" xs={8}>
              {/* 개요 테이블 컴포넌트 */}
              <OutLineTable/>
            </Grid>
            {/* 개요페이지 지도 */}
            <Grid
              item
              className="map-container"
              xs={3}
              sx={{ marginLeft: "auto", marginRight: "auto" }}
            >
                <div className="map-header"  key={index}>
                  <IconButton className="backBtn">
                    <ArrowBackIosIcon sx={{ color: "#EEEEEE" }} />
                  </IconButton>
                  {/* 인덱스 */}
                  DAY {index + 1}
                  <IconButton className="forwardBtn">
                    <ArrowForwardIosIcon sx={{ color: "#EEEEEE" }} />
                  </IconButton>
                </div>
              
              <SideMapItem />
              <div className="map-footer">
                <div class="number-list">
                  {/* 인덱스 */}
                  <p className="number-icon">{index + 1}</p>
                  {/* 데이터 data.title */}
                  <p className="footer-text">{item.title}</p>
                </div>
              </div>
            </Grid>
          </Grid>
        ))}
    </>
  );
}
