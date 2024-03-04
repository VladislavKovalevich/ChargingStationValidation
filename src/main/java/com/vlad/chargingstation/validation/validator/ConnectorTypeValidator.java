package com.vlad.chargingstation.validation.validator;

import com.vlad.chargingstation.model.entity.ConnectorType;
import com.vlad.chargingstation.validation.annotation.ConnectorTypeValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ConnectorTypeValidator implements ConstraintValidator<ConnectorTypeValidation, String> {
    @Override
    public void initialize(ConnectorTypeValidation constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String type, ConstraintValidatorContext context) {
        boolean flag = true;

        ConnectorType connectorType = null;
        for (ConnectorType b : ConnectorType.values()) {
            if (String.valueOf(b).equals(type)) {
                connectorType = b;
            }
        }

        if (connectorType == null) {
            context.buildConstraintViolationWithTemplate(context.getDefaultConstraintMessageTemplate())
                    .addConstraintViolation();

            flag = false;
        }

        return flag;
    }
}
