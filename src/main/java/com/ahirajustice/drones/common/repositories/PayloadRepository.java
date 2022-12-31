package com.ahirajustice.drones.common.repositories;

import com.ahirajustice.drones.common.entities.Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PayloadRepository extends JpaRepository<Payload, Long>, QuerydslPredicateExecutor<Payload> {

    boolean existsByName(String name);

    boolean existsByCode(String code);

}
