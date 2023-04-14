package lab5.Util;

import lab5.collections.Organization;
import lab5.collections.OrganizationType;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class organizationAdder {
    private String askName() throws IOException {
        String name;
        Console.println("Enter the name of the organization: ");
        Console.print("> ");
        BufferedReader inputName = new BufferedReader(new InputStreamReader(System.in));
        name = inputName.readLine().trim();
        return name;
    }

    private String askFullName() throws IOException {
        String fullname;
        Console.println("Enter the full name of the organization: ");
        Console.print("> ");
        BufferedReader inputName = new BufferedReader(new InputStreamReader(System.in));
        fullname = inputName.readLine().trim();
        return fullname;
    }


    private int askEmployesCount() throws IOException {
        int emloyesCount;
        Console.println("Enter the employes count of the organization");
        Console.print("> ");
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        emloyesCount = Integer.parseInt(input.readLine().trim());
        return emloyesCount;
    }

    private OrganizationType askOrganizationType() throws IOException {
        OrganizationType organizationType = OrganizationType.PRIVATE_LIMITED_COMPANY;
        Console.println(OrganizationType.printAllOrganizations());
        Console.println("Chose and enter one of the organization type from the list for the new product: ");
        Console.print("> ");
        BufferedReader inputUnitOfMeasure = new BufferedReader(new InputStreamReader(System.in));
        organizationType = OrganizationType.valueOf(inputUnitOfMeasure.readLine().trim().toUpperCase());
        return organizationType;
    }

    public Organization askUserAboutOrganization() throws IOException {
        Organization organization = new Organization(askName(), askFullName(), askEmployesCount(), askOrganizationType());
        return organization;
    }

}
