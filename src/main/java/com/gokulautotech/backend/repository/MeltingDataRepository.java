package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.MeltingData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MeltingDataRepository extends JpaRepository<MeltingData ,Long> {
}
