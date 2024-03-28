package com.vlad.chargingstation.service.impl;

import com.vlad.chargingstation.mapper.ChargingStationMapper;
import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;
import com.vlad.chargingstation.model.dto.ChargingStationResponseDto;
import com.vlad.chargingstation.model.entity.ChargingStation;
import com.vlad.chargingstation.model.entity.StationStatus;
import com.vlad.chargingstation.repository.ChargingStationRepository;
import com.vlad.chargingstation.service.ChargingStationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.UUID;

@Service
public class ChargingStationServiceImpl implements ChargingStationService {

    private final ChargingStationMapper chargingStationMapper;

    private final ChargingStationRepository chargingStationRepository;

    @Autowired
    public ChargingStationServiceImpl(ChargingStationMapper chargingStationMapper,
                                      ChargingStationRepository chargingStationRepository) {


        this.chargingStationMapper = chargingStationMapper;
        this.chargingStationRepository = chargingStationRepository;
    }

    @Override
    @Transactional
    public String createChargingStation(ChargingStationRequestDto dto) {
        ChargingStation chargingStation = chargingStationMapper.mapToEntity(dto);

        String uuid = UUID.randomUUID().toString();
        chargingStation.setUuid(uuid);

        if (chargingStation.getConnectors().size() > 0){
            chargingStation.setStationStatus(StationStatus.PUBLIC);
        }else{
            chargingStation.setStationStatus(StationStatus.PRIVATE);
        }

        ChargingStation saved = chargingStationRepository.save(chargingStation);

        return saved.getUuid();
    }

    @Override
    public List<ChargingStationResponseDto> getAllStations() {
        List<ChargingStation> chargingStations = chargingStationRepository.findAll();

        return chargingStationMapper.mapToDtos(chargingStations);
    }
}
