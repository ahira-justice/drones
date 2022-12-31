package com.ahirajustice.drones.common.repositories;

import com.ahirajustice.drones.common.entities.File;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QuerydslPredicateExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FileRepository extends JpaRepository<File, Long>, QuerydslPredicateExecutor<File> {

    Optional<File> findByReference(String reference);

}
