package com.vlad.chargingstation.validation.annotation;

import com.vlad.chargingstation.validation.validator.ConnectorTypeValidator;
import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Documented
@Constraint(validatedBy = ConnectorTypeValidator.class)
@Target( { ElementType.FIELD })
@Retention(value = RetentionPolicy.RUNTIME)
public @interface ValidateConnectorType {
    String message() default "Invalid title number";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
