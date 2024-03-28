package com.vlad.chargingstation.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;

@Data
@ConfigurationProperties(prefix = "example")
public class PropertiesHolder {
    private String name;
    private String surname;
}
