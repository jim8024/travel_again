package com.acorn.work.repository;

import com.acorn.work.entity.TourlistEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TourlistRepository extends JpaRepository<TourlistEntity, String > {
}