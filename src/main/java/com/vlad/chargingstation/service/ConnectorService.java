package com.vlad.chargingstation.service;

import com.vlad.chargingstation.model.entity.StationConnector;

import java.util.List;

public interface ConnectorService {
    List<StationConnector> getSavedConnectors(List<StationConnector> stationConnectors);
}
