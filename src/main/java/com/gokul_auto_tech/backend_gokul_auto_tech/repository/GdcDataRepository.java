package com.gokul_auto_tech.backend_gokul_auto_tech.repository;

import com.gokul_auto_tech.backend_gokul_auto_tech.entity.GdcData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GdcDataRepository extends JpaRepository<GdcData,Long> {
}
