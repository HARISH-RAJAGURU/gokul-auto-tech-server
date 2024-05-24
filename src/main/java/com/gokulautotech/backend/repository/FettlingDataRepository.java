package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.FettlingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface FettlingDataRepository extends JpaRepository<FettlingData,Long> {
}
