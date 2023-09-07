//일정페이지 내용
import React, { useEffect, useState } from "react";
import axios from "axios";
import { useLocation } from "react-router";

export default function DateTableBody(){
    const [data, setData] = useState([]);
    const location = useLocation();
    console.log(location);
    const areaData = location.state ? location.state.areaData : null;
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
        <tbody>
            {data.map((item, index)=>(
                <tr>
                    <td>
                        {/* p 요소로 반드시 작성해야함 */}
                            <p className="date-text">{item.date}</p>
                            <p className="date-text-day">DAY{index+1}</p>
                        </td>
                        <td>
                            <ul className="circle-ul">
                                <li>{areaData.korTitle}</li>
                            </ul>
                        </td>
                        <td>
                            <ul className="number-ul">
                                <li>{areaData.engTitle}</li>
                        </ul>
                    </td>
                    <td>
                        <ul className="number-ul">
                            <li>{item.title}</li>
                        </ul>
                      </td>
                    </tr>
                    ))}
            </tbody>
    )
}