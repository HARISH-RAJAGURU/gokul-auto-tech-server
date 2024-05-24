package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.HpdcData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface HpdcDataRepository extends JpaRepository<HpdcData ,Long> {
}
