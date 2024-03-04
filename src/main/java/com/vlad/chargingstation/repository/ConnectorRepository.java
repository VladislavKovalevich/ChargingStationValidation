package com.vlad.chargingstation.repository;

import com.vlad.chargingstation.model.entity.ConnectorType;
import com.vlad.chargingstation.model.entity.StationConnector;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ConnectorRepository extends JpaRepository<StationConnector, Long> {
    Optional<StationConnector> findStationConnectorByConnectorTypeAndMaxPower(ConnectorType type, Double maxPower);
}
