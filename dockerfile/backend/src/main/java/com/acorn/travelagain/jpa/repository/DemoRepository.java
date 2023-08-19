package com.acorn.travelagain.jpa.repository;

import com.acorn.travelagain.jpa.entity.DemoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DemoRepository extends JpaRepository<DemoEntity, Long > {
}
