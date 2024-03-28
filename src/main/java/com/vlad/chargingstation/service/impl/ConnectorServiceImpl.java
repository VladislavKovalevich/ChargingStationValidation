package com.vlad.chargingstation.service.impl;

import com.vlad.chargingstation.model.entity.StationConnector;
import com.vlad.chargingstation.repository.ConnectorRepository;
import com.vlad.chargingstation.service.ConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ConnectorServiceImpl implements ConnectorService {

    private final ConnectorRepository connectorRepository;

    @Autowired
    public ConnectorServiceImpl(ConnectorRepository connectorRepository) {
        this.connectorRepository = connectorRepository;
    }

    @Override
    public List<StationConnector> getSavedConnectors(List<StationConnector> stationConnectors) {
        List<StationConnector> result = new ArrayList<>();

        for (StationConnector connector: stationConnectors) {
            Optional<StationConnector> optional = connectorRepository
                    .findStationConnectorByConnectorTypeAndMaxPower(connector.getConnectorType(), connector.getMaxPower());
            if (optional.isEmpty()){
                result.add(connectorRepository.save(connector));
            }else{
                result.add(optional.get());
            }

        }

        return result;
    }
}
