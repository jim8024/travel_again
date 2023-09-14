package com.acorn.work.mapstruct;

import com.acorn.work.dto.TourlistDTO;

import java.util.List;

public interface StructMapper<D,E> {

    // D : DTO , E : Entity

    D toDTO(E entity);
    List<TourlistDTO> toDTOs(List<E> entities);

    E toEntity(D dto);
    List<E> toEntities (List<D> DTOs);

}
