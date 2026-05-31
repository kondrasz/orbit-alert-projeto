package com.fiap.orbitalert.repository;

import com.fiap.orbitalert.model.RiskSensorLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RiskSensorRepository extends JpaRepository<RiskSensorLog, Long> {
}