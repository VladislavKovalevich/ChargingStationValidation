package com.vlad.chargingstation.controller.impl;

import com.vlad.chargingstation.controller.ChargingStationManagementController;
import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;
import com.vlad.chargingstation.service.ChargingStationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/charging_station")
public class ChargingStationManagementControllerImpl implements ChargingStationManagementController {

    private final ChargingStationService chargingStationService;

    @Autowired
    public ChargingStationManagementControllerImpl(ChargingStationService chargingStationService) {
        this.chargingStationService = chargingStationService;
    }

    @Override
    @PostMapping
    public ResponseEntity<String> addNewChargingStation(@Valid @RequestBody ChargingStationRequestDto dto) {
        String retVal = chargingStationService.createChargingStation(dto);
        return ResponseEntity.ok(retVal);
    }
}
