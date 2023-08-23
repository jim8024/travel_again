package com.acorn.work.repository;

import com.acorn.work.entity.JjimEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface JjimRepository extends JpaRepository<JjimEntity, String > {
}