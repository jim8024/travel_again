import React, { useState } from "react";
import { DateRange } from "react-date-range";
import "react-date-range/dist/styles.css";
import "react-date-range/dist/theme/default.css";
import "../css/DatePicker.css";
import { eachDayOfInterval } from "date-fns";
import ko from "date-fns/locale/ko";

function DatePicker({ onDateChange, checkingSDate, checkingEDate }) {
  const [state, setState] = useState([
    {
      startDate: null,
      endDate: null,
      key: "selection",
    },
  ]);
  

  // startDate와 endDate를 설정하고 각 날짜를 배열로 얻기 위한 함수
  function handleDateChange(item) {
    setState([item.selection]);
    const startDate = new Date(item.selection.startDate);
    const endDate = new Date(item.selection.endDate);
    checkingSDate(startDate)
    checkingEDate(endDate)
    const datesArray = eachDayOfInterval({
      start: startDate,
      end: endDate,
    });
    onDateChange(datesArray);
  }
  
  return (
    <div>
      <DateRange
        className="calendar"
        locale={ko}
        editableDateInputs={true}
        onChange={handleDateChange}
        moveRangeOnFirstSelection={false}
        ranges={state}
        showDateDisplay={true}
        showSelectionPreview={true}
        months={1}
        direction="horizontal"
        rangeColors={["#3d91ff"]}
        showMonthAndYearPickers={false}
        format="yyyy-MM-dd"
        dateDisplayFormat={"yyyy.MM.dd"}
      />
    </div>
  );
}

export default DatePicker;