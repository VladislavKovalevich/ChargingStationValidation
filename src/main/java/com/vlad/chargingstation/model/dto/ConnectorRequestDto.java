package com.vlad.chargingstation.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlad.chargingstation.validation.annotation.ConnectorTypeValidation;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class ConnectorRequestDto {

    @JsonProperty("type")
    @NotNull
    @ConnectorTypeValidation
    private String type;

    @JsonProperty("maxPower")
    @NotNull
    @DecimalMin(value = "0")
    @DecimalMax(value = "1000")
    private Double maxPower;
}
