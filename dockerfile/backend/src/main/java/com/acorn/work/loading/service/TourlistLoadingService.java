package com.acorn.work.loading.service;

import com.acorn.core.customException.BizException;
import com.acorn.work.dto.TourListDTO;
import com.acorn.work.entity.TourlistEntity;
import com.acorn.work.repository.TourlistRepository;
import com.acorn.work.repository.WorkMapper;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.Reader;
import java.util.List;

@RequiredArgsConstructor
@Service
public class TourlistLoadingService {



    private final TourlistRepository tourlistRepository;
//    private final TourListDocRepository tourListDOCRepository;
    private final Gson gson;
    @Value("${tourlistDir}")
    private String tourlistDir;

    public void loadingTourlist(@NonNull String filename) {

        Reader reader = fileLoad(filename);

        List<TourListDTO> tourlistdto =  gson.fromJson(reader,
                new TypeToken<List<TourListDTO>>(){}.getType() );

        List<TourlistEntity> tourlistEntities = WorkMapper.INSTANCE.toTourlistEntitys(tourlistdto);

        tourlistRepository.saveAll(tourlistEntities);

    }

//    public void loadingEcTourlist(@NonNull String filename) {
//
//        Reader reader = fileLoad(filename);
//
//        List<TourListEcDTO> tourlistEcDTOs =  gson.fromJson(reader,
//                new TypeToken<List<TourListEcDTO>>(){}.getType() );
//
//        List<TourListDoc> tourListDocs = EcMapper.INSTANCE.toTourListDOCs(tourlistEcDTOs);
//        int i = 0;
//        for (TourListDoc tourListDoc : tourListDocs) {
//            tourListDOCRepository.save (tourListDoc);
//            i += 1;
//            if (i > 10 ) break;
//        }
//

//    }

    private Reader fileLoad(String filename) {
        Reader reader = null;
        try {
            reader = new FileReader( this.tourlistDir +"/"+ filename + ".json");
        } catch (FileNotFoundException e) {
            throw new BizException(filename + " 파일이 없습니다.");
        }
        return reader;
    }


}