package com.vlad.chargingstation.mapper;

import com.vlad.chargingstation.model.dto.ChargingStationRequestDto;
import com.vlad.chargingstation.model.dto.ChargingStationResponseDto;
import com.vlad.chargingstation.model.dto.ConnectorRequestDto;
import com.vlad.chargingstation.model.dto.ConnectorResponseDto;
import com.vlad.chargingstation.model.entity.ChargingStation;
import com.vlad.chargingstation.model.entity.StationConnector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public abstract class ChargingStationMapper {

    @Autowired
    private ConnectorMapper connectorMapper;

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "postAddress", source = "postAddress")
    @Mapping(target = "location.latitude", source = "latitude")
    @Mapping(target = "location.longitude", source = "longitude")
    @Mapping(target = "connectors", source = "connectors", qualifiedByName = "getEntities")
    public abstract ChargingStation mapToEntity(ChargingStationRequestDto dto);

    @Mapping(target = "title", source = "title")
    @Mapping(target = "description", source = "description")
    @Mapping(target = "postAddress", source = "postAddress")
    @Mapping(target = "latitude", source = "location.latitude")
    @Mapping(target = "longitude", source = "location.longitude")
    @Mapping(target = "connectors", source = "connectors", qualifiedByName = {"getResponseConnectorsDto"})
    public abstract ChargingStationResponseDto mapToDto(ChargingStation entity);

    public abstract List<ChargingStationResponseDto> mapToDtos(List<ChargingStation> entities);

    @Named("getEntities")
    public List<StationConnector> getEntities(List<ConnectorRequestDto> dtoList) {
        return connectorMapper.mapListToEntity(dtoList);
    }

    @Named(value = "getResponseConnectorsDto")
    public List<ConnectorResponseDto> getResponseConnectorsDto(List<StationConnector> entitiesList){
        return connectorMapper.mapEntitiesToDtos(entitiesList);
    }
}
