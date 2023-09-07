// 개요 테이블 몸통 컴포넌트
import React, { useEffect, useState } from "react";
import "../css/TableCard.css"
import { IconButton } from "@mui/material";
import FavoriteIcon from '@mui/icons-material/Favorite';
import FavoriteBorderIcon from '@mui/icons-material/FavoriteBorder';
import RoomIcon from '@mui/icons-material/Room';
import axios from "axios";
export default function TableCard({day}){
    const [isFavorite, setIsFavorite] = React.useState(false);
    // const [data, setData] = useState([]);
    const toggleFavorite = () => {
        setIsFavorite((prevIsFavorite) => !prevIsFavorite);
    };
        
    // const fetchData = async () => {
    //     try {
    //     const response = await axios.get("#");
    //     setData(response.data); // 가져온 데이터를 state에 저장합니다.
    //     } catch (error) {
    //     console.error("데이터 가져오기 오류:", error);
    //     }
    // };

    // useEffect(() => {
    //     fetchData();
    // }, []);
    return(
            day.map((item,index)=>(
            <div className="table-card-form">
                <div className="number-container">
                    {/* 일정 인덱스 관리*/}
                    <p className="number">{index+1}</p>
                </div>
                <div className="loc-img-container">
                        {/* 관광지 이미지 (데이터) data.locImage*/}
                    <img className="loc-img" src={item.firstimage} alt="#" />
                </div>
                    {/* 관광지 이름 (데이터) data.title*/}
                <p className="locName">{item.title}</p>
                <div className="icon-container">
                    <RoomIcon color="primary"/>
                    <IconButton
                        onClick={toggleFavorite}>
                            {isFavorite ? <FavoriteIcon color="error"/> : <FavoriteBorderIcon/>}
                    </IconButton>
                </div>
            </div>
         ))
        
    )
}