package project.bookstore.fieldvalidator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import java.lang.reflect.InvocationTargetException;
import org.apache.commons.beanutils.BeanUtils;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object> {
    private String field1;
    private String field2;

    @Override
    public void initialize(final FieldMatch constraintAnnotation) {
        field1 = constraintAnnotation.first();
        field2 = constraintAnnotation.second();
    }

    @Override
    public boolean isValid(Object object, ConstraintValidatorContext context) {
        try {
            final String fieldValue = BeanUtils.getProperty(object, field1);
            final String fieldMatchValue = BeanUtils.getProperty(object, field2);
            return fieldValue != null && fieldValue.equals(fieldMatchValue);
        } catch (IllegalAccessException | InvocationTargetException
                 | NoSuchMethodException e) {
            throw new RuntimeException(e);
        }
    }
}
