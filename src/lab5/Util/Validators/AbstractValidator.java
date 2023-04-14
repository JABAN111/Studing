package lab5.Util.Validators;

import java.util.List;

/**
 * This class is Abstract class for all validators for collection
 * @param <T> is generic for class type definitions
 */
public abstract class AbstractValidator<T> {
    public boolean validate(T object){return true;}
}