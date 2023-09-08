import React from "react";
import Carousel from "react-material-ui-carousel";
import { Paper, Button, Grid } from "@mui/material";
import MediaCard from "./RecommendCard";
import CarouselList from "./CarouselList";
import "./css/MainCarousel.css"

export default function MainCarousel() {
  return (
    
      <Carousel className="carousel">
        <CarouselList />
        <CarouselList />
      </Carousel>
  );
}
