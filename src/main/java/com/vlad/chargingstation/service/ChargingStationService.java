package com.vlad.chargingstation.service;

import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;

import java.util.Map;

public interface ChargingStationService {

    String createChargingStation(ChargingStationRequestDto dto);
}
