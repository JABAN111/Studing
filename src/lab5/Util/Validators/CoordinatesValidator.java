package lab5.Util.Validators;

import lab5.Exceptions.InvalidDate.InvalidCoordinates.InValidICoordinateXException;
import lab5.Exceptions.InvalidDate.InvalidCoordinates.InvalidCoordinateYException;
import lab5.collections.Coordinates;
import lab5.managers.Console;

public class CoordinatesValidator extends AbstractValidator<Coordinates> {
    @Override
    public boolean validate(Coordinates coordinates) {
        try {
            if (coordinates.getX() <= -485) {
                throw new InValidICoordinateXException();
            }
            if (coordinates.getY() > 914) {
                throw new InvalidCoordinateYException();
            }
            return true;
        } catch (InValidICoordinateXException e) {
            Console.printError("X должен быть больше -485");
        } catch (InvalidCoordinateYException e) {
            Console.printError("Y должен быть меньше или равен 914");
        }
    return false;
    }
}
