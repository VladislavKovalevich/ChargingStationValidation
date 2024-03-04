package com.vlad.chargingstation.controller;

import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;
import org.springframework.http.ResponseEntity;

import java.util.Map;

public interface ChargingStationManagementController {

    ResponseEntity<String> addNewChargingStation(ChargingStationRequestDto dto);
}
