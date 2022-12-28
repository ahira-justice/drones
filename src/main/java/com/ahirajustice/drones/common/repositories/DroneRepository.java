package com.ahirajustice.drones.common.repositories;

import com.ahirajustice.drones.common.entities.Drone;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface DroneRepository extends JpaRepository<Drone, Long>, QuerydslPredicateExecutor<Drone> {

}
