package fr.lernejo.travelsite.annotations;

import org.jetbrains.annotations.NotNull;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class InRangeValidator implements ConstraintValidator<InRange, Integer> {
    private int min;
    private int max;

    @Override
    public void initialize(@NotNull InRange constraintAnnotation) {
        min = constraintAnnotation.min();
        max = constraintAnnotation.max();
    }

    @Override
    public boolean isValid(Integer value, ConstraintValidatorContext context) {
        return value == null || (value >= min && value <= max);
    }
}
