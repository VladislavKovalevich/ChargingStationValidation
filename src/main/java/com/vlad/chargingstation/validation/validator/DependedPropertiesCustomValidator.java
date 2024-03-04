package com.vlad.chargingstation.validation.validator;

import com.vlad.chargingstation.validation.annotation.DependedPropertiesValidation;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.SneakyThrows;
import org.apache.commons.beanutils.BeanUtils;

public class DependedPropertiesCustomValidator implements ConstraintValidator<DependedPropertiesValidation, Object> {

    private String fieldName;
    private String dependedField;

    @SneakyThrows
    @Override
    public void initialize(DependedPropertiesValidation annotation) {
        this.fieldName = annotation.fieldName();
        this.dependedField = annotation.dependFieldName();
    }

    @SneakyThrows
    @Override
    public boolean isValid(Object s, ConstraintValidatorContext ctx) {
        boolean flag = true;

        try{
            String fieldValue = BeanUtils.getProperty(s, fieldName);
            String dependFieldValue = BeanUtils.getProperty(s, dependedField);

            if (fieldValue != null && dependFieldValue == null){
                ctx.disableDefaultConstraintViolation();
                ctx.buildConstraintViolationWithTemplate(ctx.getDefaultConstraintMessageTemplate())
                        .addPropertyNode(dependedField)
                        .addConstraintViolation();
                flag = false;
            }
        }catch (Exception exception){
            throw new RuntimeException(exception);
        }

        return flag;
    }
}
