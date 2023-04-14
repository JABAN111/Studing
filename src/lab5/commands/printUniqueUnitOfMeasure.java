package lab5.commands;

import lab5.Exceptions.CommandsException.WrongAmountArgs;
import lab5.collections.UnitOfMeasure;
import lab5.managers.CollectionManager;
import lab5.managers.Console;

import lab5.Exceptions.CommandsException.WrongTypeOfElementException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * This command is outputting the unique values of the unit Of Measure field of all elements in the collection
 */

public class printUniqueUnitOfMeasure extends AbstractCommand{
    private static CollectionManager collectionManager;
    public printUniqueUnitOfMeasure() {
        super("printUniqueUnitOfMeasure","output the unique values of the unit Of Measure field of all elements in the collection");
        collectionManager = CollectionManager.getInstance();
    }

    @Override
    public void execute(String[] args) {
        try{
            if(args.length != 1){
                throw new WrongAmountArgs();
            }
            boolean cntChecker = false;
            UnitOfMeasure unitOfMeasure;
            Console.println("Enter one of the unit of measure from the list");
            Console.println(UnitOfMeasure.printAllUnitOfMeasure());
            BufferedReader inputType = new BufferedReader(new InputStreamReader(System.in));
            unitOfMeasure = UnitOfMeasure.valueOf(inputType.readLine().trim().toUpperCase());
            for(Integer id : collectionManager.getProductCollection().keySet()){
                if(collectionManager.getProductCollection().get(id).getUnitOfMeasure() == unitOfMeasure) {
                    Console.println("\n" + collectionManager.getProductCollection().get(id));
                    cntChecker = true;
                }
            }
            if(!cntChecker)
                throw new WrongTypeOfElementException();
        }catch (IOException e) {
            throw new RuntimeException(e);
        }
        catch (WrongTypeOfElementException e){
            Console.printError("No element with such type of the unit of measure");
        }
        catch (WrongAmountArgs e){
            Console.printError("No such arguments for" + getName());
        }


    }
}
