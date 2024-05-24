package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.QualityHeadData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface QualityHeadDataRepository extends JpaRepository<QualityHeadData ,Long> {
}
