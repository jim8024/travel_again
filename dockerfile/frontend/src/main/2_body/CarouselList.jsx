import React from "react";
import CarouselCard from "./CarouselCard";
import "./css/CarouselList.css"
import { Grid } from "@mui/material";

export default function CarouselList(){
    return(
        <Grid container className="carousel-card-container" spacing={1} style={{justifyContent:"center"}}>
            <CarouselCard/>
            <CarouselCard/>
        </Grid>
        
    )
}