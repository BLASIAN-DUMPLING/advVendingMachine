/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.dto;

import christina.venmachineweek3.service.VendingMachinePersistenceException;
import java.math.BigDecimal;
import java.util.Objects;
import java.util.regex.PatternSyntaxException;

/**
 *
 * @author chris
 */
public class Items {
   private String itemId;
    private String itemName;
    private BigDecimal price;
    private int itemsInStock;

    private final String DELIMITER = "::"; 


    //constructor
    public Items(String itemId, String itemName, BigDecimal price, int itemsInStock){
        this.itemId = itemId;
        this.itemName = itemName;
        this.price = price;
        this.itemsInStock = itemsInStock;
    }

    public Items(String currentLine) throws VendingMachinePersistenceException{
        try{
        String[] fields = currentLine.split(DELIMITER);
        this.itemId = fields[0];
        this.itemName = fields[1];
        this.price = new BigDecimal(fields[2]);
        this.itemsInStock = Integer.parseInt(fields[3]);
    } catch(PatternSyntaxException ex) {
        throw new VendingMachinePersistenceException(ex.getMessage());
    } catch(NullPointerException | NumberFormatException ex) {
        throw new  VendingMachinePersistenceException(ex.getMessage());
    }
    }


    //getter and setters
    public int getItemsInStock(){
        return itemsInStock;
    }

    public void setItemsInStock(int itemsInStock){
        this.itemsInStock = itemsInStock;
    }

    public String getItemId(){
        return itemId;
    }

    public void setItemId(String itemId){
        this.itemId= itemId;
    }

    public String getItemName(){
        return itemName;
    }

    public void setItemName(String itemName){
        this.itemName = itemName;
    }

    public BigDecimal getPrice(){
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price; 
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 79 * hash + Objects.hashCode(this.itemId);
        hash = 79 * hash + Objects.hashCode(this.itemName);
        hash = 79 * hash + Objects.hashCode(this.price);
        hash = 79 * hash + this.itemsInStock;
        return hash;
    }


    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Items other = (Items) obj;
        if (this.itemsInStock != other.itemsInStock) {
            return false;
        }
        if (!Objects.equals(this.itemId, other.itemId)) {
            return false;
        }
        if (!Objects.equals(this.itemName, other.itemName)) {
            return false;
        }
        return true;
        }

    public String marshalItemAsText() {
        return itemId + DELIMITER + itemName + DELIMITER + price + DELIMITER + itemsInStock;
    } 
}
