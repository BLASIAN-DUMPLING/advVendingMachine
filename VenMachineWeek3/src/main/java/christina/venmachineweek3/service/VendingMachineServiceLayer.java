/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package christina.venmachineweek3.service;

import christina.venmachineweek3.dto.Coins;
import christina.venmachineweek3.dto.Items;
import java.math.BigDecimal;
import java.util.Map;

/**
 *
 * @author chris
 */
public interface VendingMachineServiceLayer {
    public Map<String, Items> loadItemsInStock() throws VendingMachinePersistenceException, VendingMachineNoItemInventoryException;

    public void saveItemList() throws VendingMachinePersistenceException;

    public Items getChosenItem(String itemId) throws VendingMachineNoItemInventoryException;

    public void checkSufficientMoney(BigDecimal moneyDeposited, Items item) throws VendingMachineInsufficientFundsException;

    public Coins calculateChange(BigDecimal amount, Items item);

    public void updateSoldItem(Items item) throws VendingMachineNoItemInventoryException, VendingMachinePersistenceException;
}
