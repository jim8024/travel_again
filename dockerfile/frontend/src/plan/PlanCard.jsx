import React, { useState } from 'react';
import CardContent from '@mui/material/CardContent';
import FavoriteIcon from '@mui/icons-material/Favorite';
import CardMedia from '@mui/material/CardMedia';
import Typography from '@mui/material/Typography';
import { Button, Card } from '@mui/material';
import AddBoxRoundedIcon from '@mui/icons-material/AddBoxRounded';
import StarIcon from '@mui/icons-material/Star';
import output from '../utils/finalresult.json';
import { textOverCut } from '../util/textOverCut';
import ArrowBackIosNewIcon from "@mui/icons-material/ArrowBackIosNew";
import ArrowForwardIosIcon from "@mui/icons-material/ArrowForwardIos";


export default function PlanCard({ selectedItems, setSelectedItems, selectedIndex, areaData }) {
    const handleAddButtonClick = (item) => {
        const selectedDate = new Date().toISOString().substr(0, 10);

        let updatedArray = [...selectedItems];

        // updatedArray[selectedIndex]가 배열이 아니거나 null 또는 undefined일 때 초기화
        if (!Array.isArray(updatedArray[selectedIndex])) {
            updatedArray[selectedIndex] = [];
        }

        updatedArray[selectedIndex].push({ ...item, date: selectedDate });
        setSelectedItems(updatedArray);
    };

    const itemsPerPage = 8;
    const [currentPage, setCurrentPage] = useState(0);

    const handlePreviousPage = () => {
        if (currentPage > 0) {
            setCurrentPage(currentPage - 1);
        }
    };

    const handleNextPage = () => {
        const filteredItems = output.filter((item) => item.areacode === areaData.areacode);
        const pageCount = Math.ceil(filteredItems.length / itemsPerPage);

        if (currentPage < pageCount - 1) {
            setCurrentPage(currentPage + 1);
        }
    };

    const filteredItems = output.filter((item) => item.areacode === areaData.areacode);
    const displayedItems = filteredItems.slice(currentPage * itemsPerPage, (currentPage + 1) * itemsPerPage);

    return (
        <>
            <h3>추천 관광지</h3>
            <hr />
            {displayedItems.map((item, i) => (
                <Card
                    key={item.contentId}
                    sx={{
                        display: 'flex',
                        width: 'auto',
                        height: '100px',
                        flexDirection: 'row',
                        alignItems: 'center',
                        marginBottom: '8px',
                    }}
                >
                    <CardMedia
                        component="img"
                        sx={{
                            width: 70,
                            height: 70,
                            flexGrow: '1',
                            borderRadius: '5px',
                            marginLeft: '10px',
                        }}
                        image={item.firstimage}
                        alt={item.title}
                    />
                    <CardContent sx={{ position: 'static', flexGrow: '5' }}>
                        <Typography
                            variant="h6"
                            component="div"
                            sx={{
                                fontWeight: 'bold',
                                fontSize: 12.8,
                            }}
                        >
                            {textOverCut(item.title, 10.8, '...')}
                        </Typography>
                        <Typography variant="div">
                            <span
                                style={{
                                    fontSize: '1px',
                                    fontWeight: 'bolder',
                                    color: 'skyblue',
                                    marginTop: '-2',
                                }}
                            >
                                도로명
                            </span>
                            <Typography variant="h6" sx={{ fontSize: 8.3 }}>
                                {textOverCut(item.addr1, 15, '...')}
                            </Typography>
                        </Typography>
                        <div>
                            <FavoriteIcon sx={{ fontSize: 13, color: '#F44336' }} />
                            <StarIcon sx={{ fontSize: 14, color: '#FBC02D' }} />
                        </div>
                    </CardContent>
                    <div
                        style={{
                            flexGrow: '1',
                            display: 'flex',
                            flexDirection: 'row-reverse',
                            justifyContent: 'center',
                        }}
                    >
                        <Button
                            className="addBtn"
                            onClick={() => handleAddButtonClick(item)}
                            sx={{
                                height: '30px',
                                width: '30px',
                                padding: '0',
                                minWidth: '0',
                                marginRight: '9px',
                            }}
                        >
                            <AddBoxRoundedIcon />
                        </Button>
                    </div>
                </Card>
            ))}
           <div style={{display:"flex", justifyContent:"space-between"}}>
              <Button onClick={handlePreviousPage} disabled={currentPage === 0}>
                {" "}
                <ArrowBackIosNewIcon />
              </Button>

              <Button
                onClick={handleNextPage}
                disabled={
                  currentPage === Math.ceil(filteredItems.length / itemsPerPage) - 1
                }
              >
                <ArrowForwardIosIcon />
              </Button>
            </div>
        </>
    );
}