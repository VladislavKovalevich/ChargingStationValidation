package com.vlad.chargingstation.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.vlad.chargingstation.validation.annotation.DependedPropertiesValidation;
import jakarta.annotation.Nullable;
import jakarta.validation.Valid;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Builder
@Getter
@AllArgsConstructor
@NoArgsConstructor
@DependedPropertiesValidation.List(
        value = {
                @DependedPropertiesValidation(
                        fieldName = "connectors",
                        dependFieldName = "title"
                ),
                @DependedPropertiesValidation(
                        fieldName = "connectors",
                        dependFieldName = "description"
                ),
                @DependedPropertiesValidation(
                        fieldName = "connectors",
                        dependFieldName = "postAddress"
                ),
                @DependedPropertiesValidation(
                        fieldName = "connectors",
                        dependFieldName = "latitude"
                ),
                @DependedPropertiesValidation(
                        fieldName = "connectors",
                        dependFieldName = "longitude"
                )
        }

)
public class ChargingStationRequestDto {

    @JsonProperty("title")
    @Nullable
    @Size(min = 2, max = 45)
    private String title;

    @JsonProperty("description")
    @Nullable
    @Size(max = 255)
    private String description;

    @JsonProperty("postAddress")
    @Nullable
    @Size(min = 4, max = 60)
    private String postAddress;

    @JsonProperty("latitude")
    @Nullable
    @DecimalMin(value = "-180")
    @DecimalMax(value = "180")
    private Double latitude;

    @JsonProperty("longitude")
    @Nullable
    @DecimalMin(value = "-85")
    @DecimalMax(value = "85")
    private Double longitude;

    @JsonProperty("connectors")
    @Valid
    private List<ConnectorRequestDto> connectors;
}
