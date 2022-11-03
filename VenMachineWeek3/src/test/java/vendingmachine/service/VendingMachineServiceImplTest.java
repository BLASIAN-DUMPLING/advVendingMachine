/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template

package vendingmachine.service;

import christina.venmachineweek3.dao.VendingMachineAuditDao;
import christina.venmachineweek3.dao.VendingMachineAuditDaoImpl;
import christina.venmachineweek3.dao.VendingMachineDao;
import christina.venmachineweek3.dao.VendingMachineDaoImpl;
import christina.venmachineweek3.dto.Items;
import christina.venmachineweek3.service.VendingMachineNoItemInventoryException;
import christina.venmachineweek3.service.VendingMachinePersistenceException;
import christina.venmachineweek3.service.VendingMachineServiceLayerImpl;
import java.math.BigDecimal;
import java.util.Map;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.Test;

/**
 *
 * @author chris

public class VendingMachineServiceImplTest {
   
    public static VendingMachineServiceLayerImpl testService;
    
    public VendingMachineServiceImplTest(){
       VendingMachineDao dao = new VendingMachineDaoImpl(); 
       VendingMachineAuditDao auditDao = new VendingMachineAuditDaoImpl();
       testService = new VendingMachineServiceLayerImpl(dao, auditDao);
    }
    
    @Test
    public void testLoadItemsInStock() throws VendingMachineNoItemInventoryException{
        try {
            System.out.println("loadItemsInStock");
            BigDecimal bd = new BigDecimal("2.99");
            Items p1 = new Items("1", "Fanta", bd, 8);
            //expected result
            Map<String, Items> expResult = new TreeMap<>();
            expResult.put("1",p1);
            //result
            Map<String, Items> result = testService.loadItemsInStock();
            //assert
            assertEquals(expResult, result, "Test Items loaded from the file.");          
        } catch(VendingMachineNoItemInventoryException | VendingMachinePersistenceException ex){
            fail("Item was valid. No exception should have been thrown.");
        }
    }
    
    @Test
    public void testGetChosenItem() throws VendingMachineNoItemInventoryException{
        System.out.println("getChosenItem");
        BigDecimal bd = new BigDecimal ("2.99");
        //expected result
        Items expResult = new Items("1", "Fanta", bd, 8);
        //result
        Items result = testService.getChosenItem("1");
        //assert
        assertEquals(expResult, result, "Check bothe Items equal.");
        assertEquals(expResult.getItemName(), result.getItemName(), "Check both Items equal.");
    }
    
    @Test
  public void testCheckSufficientMoney() throws VendingMachineInsufficientFundsException, VendingMachineNoItemInventoryException{
      System.out.println("checkSufficientMoney");
      BigDecimal moneyDeposited = new BigDecimal("5.00");
      Items item = testService.getChosenItem("1");
      testService.checkSufficientMoney(moneyDeposited, item);
  }

}
 */