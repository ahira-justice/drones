package com.ahirajustice.drones.common.repositories;

import com.ahirajustice.drones.common.entities.Payload;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface MedicationRepository extends JpaRepository<Payload, Long>, QuerydslPredicateExecutor<Payload> {

}
