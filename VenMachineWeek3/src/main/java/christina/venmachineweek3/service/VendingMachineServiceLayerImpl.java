/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.service;

import christina.venmachineweek3.dao.VendingMachineAuditDao;
import christina.venmachineweek3.dao.VendingMachineDao;
import christina.venmachineweek3.dto.Coins;
import christina.venmachineweek3.dto.Items;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {
    
    VendingMachineDao dao;
    public VendingMachineAuditDao auditDao;

    //Dependency Injection
    public VendingMachineServiceLayerImpl(VendingMachineDao dao, VendingMachineAuditDao auditDao){
    this.dao = dao;
    this.auditDao = auditDao;
}


    @Override
    public Map<String, Items> loadItemsInStock() throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException{
        Map<String, Items> itemsInStock = new HashMap<>();
        for(Items p : dao.loadItemsFromFile().values()) {
            if (p.getItemsInStock() < 1){
                auditDao.writeAuditEntry("Item Id: " + p.getItemId() + " quantity in stock is zero.");
            } else {
                itemsInStock.put(p.getItemId(), p);
            }
        }
        return itemsInStock;
    }

    @Override
    public void saveItemList() throws VendingMachinePersistenceException {
        dao.writeItemsToFile(); 
        auditDao.writeAuditEntry("Item list saved to file.");
    }

    @Override
    public Items getChosenItem(String itemId) throws VendingMachineNoItemInventoryException {
        validateItemInStock(itemId);
        return dao.getItem(itemId);
    }

    @Override
    public void checkSufficientMoney(BigDecimal moneyDeposited, Items item) throws VendingMachineInsufficientFundsException{
        if (moneyDeposited.compareTo(item.getPrice()) < 0) {
            throw new VendingMachineInsufficientFundsException("Insufficient funds to buy " + item.getItemName() + ".");
        } 
    }
    
    @Override
    public Coins calculateChange(BigDecimal amount, Items item) {
        BigDecimal change = amount.subtract(item.getPrice()).multiply(new BigDecimal("100"));
        return new Coins(change);
    }

    @Override
    public void updateSoldItem(Items item) 
            throws VendingMachineNoItemInventoryException, VendingMachinePersistenceException { if(item.getItemsInStock() > 0) {
                item.setItemsInStock(item.getItemsInStock() - 1);
            }else{
                throw new VendingMachineNoItemInventoryException("Selected Item is not in Stock.");
            }
            dao.updateItem(item.getItemId(), item);
            auditDao.writeAuditEntry("Item Id: " +item.getItemId() + " is updated.");
    } 

    
    private void validateItemInStock(String itemId) throws VendingMachineNoItemInventoryException {
        List<String> ids = dao.getAllItemsId();
        Items item = dao.getItem(itemId);
        if(!ids.contains(itemId) || (item.getItemsInStock() < 1)){
         throw new VendingMachineNoItemInventoryException("Selected Item is not in stock.");   
        }
    }
    
}
