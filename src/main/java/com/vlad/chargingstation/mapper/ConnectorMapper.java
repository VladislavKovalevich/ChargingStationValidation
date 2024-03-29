package com.vlad.chargingstation.mapper;

import com.vlad.chargingstation.model.dto.ConnectorRequestDto;
import com.vlad.chargingstation.model.dto.ConnectorResponseDto;
import com.vlad.chargingstation.model.entity.ConnectorType;
import com.vlad.chargingstation.model.entity.StationConnector;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingConstants;
import org.mapstruct.Named;

import java.util.List;

@Mapper(componentModel = MappingConstants.ComponentModel.SPRING)
public interface ConnectorMapper {

    @Mapping(target = "connectorType", source = "type", qualifiedByName = "getConnectorType")
    @Mapping(target = "maxPower", source = "maxPower")
    StationConnector mapToEntity(ConnectorRequestDto dto);

    List<StationConnector> mapListToEntity(List<ConnectorRequestDto> dtoList);


    @Mapping(target = "id", source = "id")
    @Mapping(target = "type", source = "connectorType", qualifiedByName = "getType")
    @Mapping(target = "maxPower", source = "maxPower")
    ConnectorResponseDto mapToDto(StationConnector stationConnector);

    List<ConnectorResponseDto> mapEntitiesToDtos(List<StationConnector> stationConnectors);

    @Named("getConnectorType")
    default ConnectorType getConnectorType(String type){
        ConnectorType connectorType;
        try {
            connectorType = ConnectorType.valueOf(type);
        }catch (IllegalArgumentException e){
            throw new RuntimeException(e);
        }
        return connectorType;
    }

    @Named("getType")
    default String getType(ConnectorType connectorType){
        return connectorType.name();
    }
}
