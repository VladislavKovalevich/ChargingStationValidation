package com.vlad.chargingstation.model.entity;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Setter
@Getter
@Embeddable
public class StationLocation {

    private Double latitude;

    private Double longitude;
}
