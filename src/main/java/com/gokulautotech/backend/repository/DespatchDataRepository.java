package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.DespatchData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DespatchDataRepository extends JpaRepository<DespatchData ,Long> {
}
