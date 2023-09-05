// 개요 테이블 컴포넌트
import React, { useEffect, useState } from "react";
import TableCard from "./TableCard";
import "../css/OutLineTable.css"
import { Box } from "@mui/material";
import axios from "axios";

export default  function OutLineTable(){
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
    return( 
        // 개요테이블 헤더
       <Box sx={{width:"100%"}}>
            {data.map((item,index)=>(
                <div className="table-head">
                                        {/* 인덱스 */}
                    <div className="dayblock">DAY{index+1}</div>
                    <div className="day-loc-div">
                                                {/* 데이터 data.date */}
                        <h4 className="day-text">{item.date}</h4>
                                                {/* 데이터 data.title */}
                        <p className="loc-text">{item.title}</p>
                    </div>
                </div>
            ))}
            {/* 개요테이블 몸통 및 내용 */}
            <TableCard/>
        </Box> 
    )
}