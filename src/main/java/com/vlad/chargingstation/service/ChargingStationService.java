package com.vlad.chargingstation.service;

import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;
import com.vlad.chargingstation.model.dto.ChargingStationResponseDto;

import java.util.List;

public interface ChargingStationService {

    String createChargingStation(ChargingStationRequestDto dto);

    List<ChargingStationResponseDto> getAllStations();
}
