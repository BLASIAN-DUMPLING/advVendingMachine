/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.controller;

import christina.venmachineweek3.dto.Coins;
import christina.venmachineweek3.dto.Items;
import christina.venmachineweek3.service.VendingMachineInsufficientFundsException;
import christina.venmachineweek3.service.VendingMachineNoItemInventoryException;
import christina.venmachineweek3.service.VendingMachinePersistenceException;
import christina.venmachineweek3.service.VendingMachineServiceLayer;
import christina.venmachineweek3.ui.VendingMachineView;
import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class VendingMachineController {
  private VendingMachineView view;
    private VendingMachineServiceLayer service;
   // VendingMachineDao dao;
    //Dependency Injection
    public VendingMachineController (VendingMachineView view, VendingMachineServiceLayer service){
    this.view = view;
    this.service = service;

   // this.dao = dao;

}  
    public void run() throws VendingMachinePersistenceException{
        BigDecimal moneyDeposited = new BigDecimal("0");
        Items chosenItem = null; 
        String keepGoing = "yes";
        //String input;
        Scanner scan = new Scanner (System.in);
            while(keepGoing.equals("yes"))
            {
                boolean isEnoughMoney = false;
                try{
                    displayHeader();
                    do {
                        itemMenu();
                        moneyDeposited = userMoneyInput(moneyDeposited);
                        chosenItem = getChosenItem();
                        isEnoughMoney = sufficientAmt(moneyDeposited, chosenItem);
                        if(exitVending(isEnoughMoney)){
                            return;
                        }
                    } while(!isEnoughMoney);
                    displayUserMoneyInput(moneyDeposited);
                    displayChangeReturned(moneyDeposited, chosenItem);
                    updateSoldItem(chosenItem);
                    saveItemList();
                } catch(VendingMachinePersistenceException ex){
                    displayErrorMessage(ex.getMessage());
                } finally{
                    displayFinalMessage();
                }
                view.displayUserResponse(chosenItem);
                keepGoing = scan.nextLine();
            } scan.close();
    }

    
    void displayHeader() {
         view.displayVendingMachineWelcome();
    }

    void itemMenu() throws VendingMachinePersistenceException {
        try {
        view.displayItemHeader();
        for (Items p : service.loadItemsInStock().values()){
            view.displayItem(p);
        } 
    }catch (VendingMachineNoItemInventoryException | VendingMachinePersistenceException ex) {
        throw new VendingMachinePersistenceException(ex.getMessage());
    }
    }

    BigDecimal userMoneyInput(BigDecimal moneyDeposited) {
        return moneyDeposited.add(view.promptUserMoneyInput());
    }

    Items getChosenItem() {
        while (true) {
            String itemId = view.promptUserItemChoice();
            try {
                Items item = service.getChosenItem (itemId);
                view.displayUserChoiceofItem(item);
                return item;
            } catch(VendingMachineNoItemInventoryException ex){
                view.displayErrorMessage(ex.getMessage());
            }
        }
        
    }

    boolean sufficientAmt(BigDecimal moneyDeposited, Items item) {
        try {
             service.checkSufficientMoney(moneyDeposited, item);
            return true;
        } catch (VendingMachineInsufficientFundsException ex){
            displayErrorMessage(ex.getMessage());
            displayUserMoneyInput(moneyDeposited);
            return false;
        }
      
    }

    void displayUserMoneyInput (BigDecimal amount){
        view.displayUserMoneyInput(amount);
    }

    void displayChangeReturned(BigDecimal amount, Items item){
        Coins change = service.calculateChange(amount, item);
        view.displayChangeDue (change);
    }

    boolean exitVending(boolean isEnoughMoney) {
        if (isEnoughMoney){
            return false;     
        } else {
            return view.toExit();
        }

    }

    void displayErrorMessage(String message){
        view.displayErrorMessage(message);
    }


    
   void updateSoldItem(Items item) throws VendingMachinePersistenceException {
        try {           
         
            service.updateSoldItem(item); 
    }catch (VendingMachineNoItemInventoryException ex){
        throw new VendingMachinePersistenceException(ex.getMessage());
    }
}

    void saveItemList() throws VendingMachinePersistenceException{
        service.saveItemList();
    }

    void displayFinalMessage(){
        view.displayFinalMessage();
    }  
}
