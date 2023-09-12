import { Modal, Paper, TableRow, TableCell } from "@mui/material";
import React, { useState } from "react";
import CloseIcon from "@mui/icons-material/Close";
import axios from "axios";

const columns = [
  { id: "number", label: "번호" },
  { id: "word", label: "인기 단어" },
  { id: "rank", label: "순위 변동" },
  { id: "likes", label: "좋아요 수" },
];

function createData(number, word, rank, likes) {
  return { number, word, rank, likes };
}

function RealTimeModal({ isOpen, onClose }) {
  const [rows, setRows] = useState([
    createData(1, "제주", "+" + 1, 30),
    createData(2, "독도", "", 27),
    createData(3, "부산", "+" + 1, 19),
    createData(4, "대구", "", 18),
    createData(5, "전주", "", 10),
  ]);

  const handleSubmit = async (event) => {
    event.preventDefault();
    const url = "http://192.168.0.86:9000/wordSearch/comp"; // 바꿔야 함

    try {
      const response = await axios.get(url, {});
      const newRows = response.data.data.map((item, index) =>
        createData(index + 1, item.word, item.no, item.cnt)
      );
      console.log("서버 응답:", response.data);
      setRows(newRows); // 데이터 업데이트
    } catch (error) {
      console.error("오류:", error);
    }
  };

  const tableRowStyle = {
    height: "20px", // 로우 높이 조절
  };

  const tableCellStyle = {
    padding: "5px", // 셀 패딩 조절
    height: "10px", // 셀 높이 조절
  };

  const closeBtnStyle = {
    position: "absolute",
    top: "0px", // 원하는 상단 위치
    right: "413px", // 원하는 오른쪽 위치
  };

  const renewBtnStyle = {
    position: "absolute",
    top: "183px", // 원하는 상단 위치
    left: "453px", // 원하는 왼쪽 위치
  };

  return (
    <Modal open={isOpen} onClose={onClose}>
      <div className="real-modal">
        <div className="real-modal-content">
          <Paper
            sx={{
              width: "40%", // 테이블 너비 조절
              maxHeight: "100vh", // 테이블 높이 조절 (예: 70% 화면 높이)
              margin: "auto",
              position: "relative", // 부모 요소에 대해 상대 위치 설정
            }}
          >
            <div className="table-container">
              <table>
                <thead>
                  <tr>
                    {columns.map((column) => (
                      <th key={column.id} style={tableCellStyle}>
                        {column.label}
                      </th>
                    ))}
                  </tr>
                </thead>
                <tbody>
                  {rows.map((row, rowIndex) => (
                    <TableRow key={rowIndex} style={tableRowStyle}>
                      {columns.map((column) => (
                        <TableCell key={column.id} style={tableCellStyle}>
                          {column.id === "rank" && row[column.id] !== "" ? (
                            <span>{row[column.id]}</span>
                          ) : (
                            row[column.id]
                          )}
                        </TableCell>
                      ))}
                    </TableRow>
                  ))}
                </tbody>
              </table>
            </div>
          </Paper>
          <button onClick={onClose} style={closeBtnStyle}>
            <CloseIcon />
          </button>
          <button onClick={handleSubmit} style={renewBtnStyle}>
            갱신
          </button>
        </div>
      </div>
    </Modal>
  );
}

export default RealTimeModal;
