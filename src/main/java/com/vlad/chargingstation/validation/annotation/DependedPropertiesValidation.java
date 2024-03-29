package com.vlad.chargingstation.validation.annotation;

import com.vlad.chargingstation.validation.validator.DependedPropertiesCustomValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Repeatable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;


@Documented
@Constraint(validatedBy = DependedPropertiesCustomValidator.class)
@Target( { ElementType.TYPE, ElementType.ANNOTATION_TYPE })
@Retention(value = RetentionPolicy.RUNTIME)
@Repeatable(DependedPropertiesValidation.List.class)
public @interface DependedPropertiesValidation {
    String fieldName();
    String dependFieldName();

    String message() default "{charging_station.public_station_message}";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    @Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @Documented
    @interface List {
        DependedPropertiesValidation[] value();
    }
}
