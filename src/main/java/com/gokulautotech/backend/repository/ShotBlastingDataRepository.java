package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.ShotBlastingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface ShotBlastingDataRepository extends JpaRepository<ShotBlastingData,Long> {
}
