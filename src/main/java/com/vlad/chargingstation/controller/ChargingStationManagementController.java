package com.vlad.chargingstation.controller;

import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;
import com.vlad.chargingstation.model.dto.ChargingStationResponseDto;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface ChargingStationManagementController {

    ResponseEntity<String> addNewChargingStation(ChargingStationRequestDto dto);

    ResponseEntity<List<ChargingStationResponseDto>> getAllStations();
}
