package com.gokulautotech.backend.repository;

import com.gokulautotech.backend.entity.AlloyStoreData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface AlloyStoreDataRepository extends JpaRepository<AlloyStoreData ,Long> {

}
