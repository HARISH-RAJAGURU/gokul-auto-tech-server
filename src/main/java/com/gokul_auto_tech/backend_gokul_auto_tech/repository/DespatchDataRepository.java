package com.gokul_auto_tech.backend_gokul_auto_tech.repository;

import com.gokul_auto_tech.backend_gokul_auto_tech.entity.DespatchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespatchDataRepository extends JpaRepository<DespatchData,Long> {
}
