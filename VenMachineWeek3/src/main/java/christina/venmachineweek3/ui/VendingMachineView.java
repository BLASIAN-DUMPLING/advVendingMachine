/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.ui;

import christina.venmachineweek3.dto.CoinValues;
import christina.venmachineweek3.dto.Coins;
import christina.venmachineweek3.dto.Items;
import java.math.BigDecimal;

/**
 *
 * @author chris
 */
public class VendingMachineView {
    private UserIO io; 

    public VendingMachineView (UserIO io) {
        this.io = io;
    }

    public void displayVendingMachineWelcome(){
        io.print(" Welcome Christina's Vending Machine! \n");
    }

    public void displayItemHeader() {
        io.print("No\tItem\t\tPrice");
        io.print("--------------------");
    }

    public void displayItem(Items item) {
        io.print(item.getItemId() + "\t" + item.getItemName() + "\t\t\t\t" + item.getPrice());
    }

    public BigDecimal promptUserMoneyInput() {
        return io.readBigDecimal("Please enter money: ");
    }

    public String promptUserItemChoice() {
        return io.readString("Please choose the item number you want to buy.");
    }

    public void displayUserChoiceofItem(Items item) {
        io.print("You have chosen " + item.getItemName() + "."); 
    }

    public void displayUserMoneyInput(BigDecimal amount) {
        io.print("You have deposited $" + amount + ".");
    }

    public void displayChangeDue(Coins change) {
        io.print("The change due: ");
        io.print(CoinValues.quarters + " : " + change.getQuarters());
        io.print(CoinValues.dime + " : " + change.getDimes());
        io.print(CoinValues.nickles + " : " + change.getNickles());
        io.print(CoinValues.pennies + " : " + change.getPennies());
    }

    public void displayErrorMessage(String errorMessage) {
        io.print ("===ERROR===");
        io.print(errorMessage);
    }

    public boolean toExit() {
        String answer = io.readString("Do you want to exit the Vending Machine? (y/n)").toLowerCase();
        if(answer.startsWith("y")){
            return true;
        } else {
        return false; 
    }
        }

    public void displayFinalMessage() {
        io.print("THANK YOU FOR USING CHRISTINA'S VENDING MACHINE!");
    }

    public void displayUserResponse(Items item) {
        io.print("****Do you want to make another selection?"); 
    }
 
}
