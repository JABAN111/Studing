package lab5.Util.Validators;

import lab5.Exceptions.InvalidDateProductAndOrganization.*;
import lab5.collections.Product;
import lab5.managers.Console;

/**
 * This class is checking validity of the Product
 */

public class ProductValidator extends AbstractValidator<Product> {
    public boolean validate(Product product) {
        try {
            if (product.getName() == null || product.getName().isEmpty()) {
                throw new InvalidNameException();
            }
            if (product.getCoordinates() == null) {
                throw new InvalidCoordinatesException();
            }
            if (product.getCreationDate() == null) {
                throw new InvalidTimeException();
            }

            if (product.getPrice() == null || product.getPrice() <= 0) {
                throw new InvalidPriceException();
            }
            if (product.getManufactureCost() <= 0) {
                throw new InvalidManufactureCostException();
            }
            if (product.getUnitOfMeasure() == null) {
                throw new UnitOfMeasureException();
            }
            return true;
        }catch (InvalidNameException e){
            Console.printError("Name cannot be equal to null or be space");
        } catch (InvalidCoordinatesException e) {
            Console.printError("Coordinates cannot be equal to null");
        } catch (InvalidTimeException e) {
            Console.printError("Time cannot be equal to null");
        } catch (InvalidPriceException e) {
            Console.printError("Price cannot be less than zero and equal to null");
        } catch (InvalidManufactureCostException e) {
            Console.printError("Manufacture cost cannot be less than zero");
        } catch (UnitOfMeasureException e) {
            Console.printError("Unit of measure cannot be equal to null");
        }
        return false;
    }
}
