import { Box, Card, CardMedia, Grid } from "@mui/material"
import React from "react"
import "./css/CarouselCard.css"

export default function CarouselCard(){
  return(
    <Grid  item xs={6} className="img-container">
      <p className="tour-title">거제도</p>
      <p className="tour-name">gujeaDo</p>
      <img className="card-img" src="https://picsum.photos/600/600/?random" alt="#" />
    </Grid>
  )
}