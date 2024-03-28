package com.vlad.chargingstation.model.entity;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Entity
public class ChargingStation {

    @Id
    private String uuid;

    private String title;

    private String description;

    @Column(name = "post_address")
    private String postAddress;

    @Enumerated(EnumType.STRING)
    @Column(name = "station_status")
    private StationStatus stationStatus;

    @Embedded
    private StationLocation location;

    @ManyToMany(cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE})
    @JoinTable(name = "stations_connectors",
            joinColumns = @JoinColumn(name = "station_id"),
    inverseJoinColumns = @JoinColumn(name = "connector_id"))
    private List<StationConnector> connectors;
}
