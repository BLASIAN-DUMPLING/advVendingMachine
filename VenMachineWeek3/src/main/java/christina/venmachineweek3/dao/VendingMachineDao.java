/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package christina.venmachineweek3.dao;

import christina.venmachineweek3.dto.Items;
import christina.venmachineweek3.service.VendingMachinePersistenceException;
import java.util.List;
import java.util.Map;

/**
 *
 * @author chris
 */
public interface VendingMachineDao {
  Items addItem(String itemId, Items item);
    
    List<Items> getAllItems();

    List<String> getAllItemsId();

    Items getItem(String itemId);

    Items updateItem(String itemId, Items item);

    Items removeItem(String itemId);

    Map<String, Items> loadItemsFromFile() throws VendingMachinePersistenceException;

    void writeItemsToFile() throws VendingMachinePersistenceException;  
}
