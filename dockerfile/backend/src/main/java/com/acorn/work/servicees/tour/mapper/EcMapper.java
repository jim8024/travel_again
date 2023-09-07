package com.acorn.work.servicees.tour.mapper;


import com.acorn.work.servicees.tour.doc.TourListDoc;
import com.acorn.work.servicees.tour.dto.TourListEcDTO;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface EcMapper {

    EcMapper INSTANCE = Mappers.getMapper(EcMapper.class);

    TourListEcDTO  toTourListEcDTO(TourListDoc tourListDoc) ;
    List<TourListDoc> toTourListDOCs(List<TourListEcDTO> tourListEcDTOs) ;


    List<TourListEcDTO> toTourListEcDTOs(List<TourListDoc> tourListDoc) ;

}