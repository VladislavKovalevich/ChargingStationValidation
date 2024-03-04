package com.vlad.chargingstation.service.impl;

import com.vlad.chargingstation.mapper.ChargingStationMapper;
import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;
import com.vlad.chargingstation.model.entity.ChargingStation;
import com.vlad.chargingstation.model.entity.StationConnector;
import com.vlad.chargingstation.model.entity.StationStatus;
import com.vlad.chargingstation.repository.ChargingStationRepository;
import com.vlad.chargingstation.service.ChargingStationService;
import com.vlad.chargingstation.service.ConnectorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class ChargingStationServiceImpl implements ChargingStationService {

    private final ChargingStationMapper chargingStationMapper;

    private final ChargingStationRepository chargingStationRepository;

    private final ConnectorService connectorService;

    @Autowired
    public ChargingStationServiceImpl(ChargingStationMapper chargingStationMapper,
                                      ChargingStationRepository chargingStationRepository,
                                      ConnectorService connectorService) {


        this.chargingStationMapper = chargingStationMapper;
        this.chargingStationRepository = chargingStationRepository;
        this.connectorService = connectorService;
    }

    @Override
    public String createChargingStation(ChargingStationRequestDto dto) {
        ChargingStation chargingStation = chargingStationMapper.mapToEntity(dto);

        String uuid = UUID.randomUUID().toString();
        chargingStation.setUuid(uuid);

        if (chargingStation.getConnectors().size() > 0){
            chargingStation.setStationStatus(StationStatus.PUBLIC);
        }else{
            chargingStation.setStationStatus(StationStatus.PRIVATE);
        }

        List<StationConnector> stationConnectors = connectorService.getSavedConnectors(chargingStation.getConnectors());

        chargingStation.setConnectors(stationConnectors);

//        ChargingStation saved = chargingStationRepository.save(chargingStation);

        return chargingStation.getUuid();
    }
}
