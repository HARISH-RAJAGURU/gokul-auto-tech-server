package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.GdcData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GdcDataRepository extends JpaRepository<GdcData ,Long> {
}
