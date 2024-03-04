package com.vlad.chargingstation.repository;

import com.vlad.chargingstation.model.entity.ChargingStation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ChargingStationRepository extends JpaRepository<ChargingStation, String> {
}
