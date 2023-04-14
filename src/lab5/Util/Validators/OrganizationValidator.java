package lab5.Util.Validators;

import lab5.Exceptions.InvalidDateProductAndOrganization.InvalidAmountObjectsException;
import lab5.Exceptions.InvalidDateProductAndOrganization.InvalidIdException;
import lab5.Exceptions.InvalidDateProductAndOrganization.InvalidNameException;
import lab5.Exceptions.InvalidDateProductAndOrganization.NotUniqDateException;
import lab5.collections.Organization;
import lab5.collections.Product;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

public class OrganizationValidator extends AbstractValidator<Organization> {
    @Override
    public boolean validate(Organization organization) {
        CollectionManager collectionManager = CollectionManager.getInstance();

    try {
        if (organization.getName() == null && organization.equals("")) {
            throw new InvalidNameException();
        }
        if (organization.getFullName() == null && organization.getFullName().length() > 891) {
            throw new InvalidNameException();
        }
        for (int id : collectionManager.getProductCollection().keySet()) {
            Product currentProduct = collectionManager.getById(id);
            if (currentProduct.getOrganization().getFullName().equals(organization.getFullName())) {
                throw new NotUniqDateException();
            }
        }
        if (organization.getEmployeesCount() <= 0) {
            throw new InvalidAmountObjectsException();
        }
        return true;
    }catch (InvalidNameException e) {
        Console.printError("This name isn't valid");
    } catch (InvalidAmountObjectsException e) {
        Console.printError("The amount of employees should be more than 0");
    } catch (NotUniqDateException e) {
            Console.printError("Parameter FullName should be uniq");
    }
        return false;
    }
}
