package com.acorn.work.repository;

import com.acorn.work.entity.PlannerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PlannerRepository extends JpaRepository<PlannerEntity, String > {

    Optional<PlannerEntity> findByPlannerNo(String plannerNo);

}