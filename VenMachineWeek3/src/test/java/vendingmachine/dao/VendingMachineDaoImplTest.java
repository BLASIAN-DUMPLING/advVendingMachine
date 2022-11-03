/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package vendingmachine.dao;


import christina.venmachineweek3.dao.VendingMachineDao;
import christina.venmachineweek3.dao.VendingMachineDaoImpl;
import christina.venmachineweek3.dto.Items;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


/**
 *
 * @author chris
 */
public class VendingMachineDaoImplTest {
    String testFile = "testproducts.txt";
    VendingMachineDao testDao = new VendingMachineDaoImpl(testFile);
    
    public VendingMachineDaoImplTest(){
    }
    
    @BeforeEach
    public void setUp() throws Exception{   
    }
    
    @Test
       
     public void testAddGetItem(){
        System.out.println("addItem");
        BigDecimal bd = new BigDecimal ("2.99");
        Items p1 = new Items("1", "Fanta", bd, 10);
        testDao.addItem(p1.getItemId(), p1);
        //result
        Items result = new Items ("1", "Fanta", bd, 10);
        //expected result
        Items expResult = new Items ("1", "Fanta", bd, 10);
        //assert
        assertEquals(expResult.getItemId(), result.getItemId(), "Checking added Product Id.");
        assertEquals(expResult.getItemName(), result.getItemName(), "Checking added Product Name.");
        assertEquals(expResult.getPrice(), result.getPrice(), "Checking added Product Price.");
        assertEquals(expResult.getItemsInStock(), result.getItemsInStock(), "Checking added Product in Stock.");
    }
     
     @Test
    public void  testGetAllItems(){
        System.out.println("getAllItems");
        BigDecimal bd = new BigDecimal ("2.99");
        Items p1 = new Items("1", "Fanta", bd, 10);
        bd = new BigDecimal("2.49");
        Items p2 = new Items("2", "Canada Dry", bd, 12);
        testDao.addItem(p1.getItemId(), p1);
        testDao.addItem(p2.getItemId(), p2);
        //result
        List<Items> result = testDao.getAllItems();
        //expected result
        List<Items> expResult = new ArrayList<>();
        expResult.add(p1);
        expResult.add(p2);
        //assert
        assertNotNull(result, "The list of products must not null.");
        assertEquals(2, result.size(), "List of products should have 2 items.");
        assertTrue(result.contains(p1), "The list of products should include Fanta.");
        assertTrue(result.contains(p2), "The list of products should include Canada Dry.");      
    }
   
    @Test
    public void  testGetAllItemId(){
        System.out.println("getAllItemId");
        BigDecimal bd = new BigDecimal ("2.99");
        Items p1 = new Items("1", "Fanta", bd, 10);
        bd = new BigDecimal("2.49");
        Items p2 = new Items("2", "Canada Dry", bd, 12);
        testDao.addItem(p1.getItemId(), p1);
        testDao.addItem(p2.getItemId(), p2);
        //result
        List<String> result = testDao.getAllItemsId();
        //expected result
        List<String> expResult = new ArrayList<>();
        expResult.add("1");
        expResult.add("2");
        //assert
        assertNotNull(result, "The list of products must not null.");
        assertEquals(2, result.size(), "List of products should have 2 items.");
        assertTrue(result.contains(p1.getItemId()), "The list of products should include Fanta.");
        assertTrue(result.contains(p2.getItemId()), "The list of products shoul include Canada Dry.");  
    } 
     
    @Test
    public void testRemoveItems(){
        System.out.println("removeItem");
        BigDecimal bd = new BigDecimal ("2.99");
        Items p1 = new Items("1", "Fanta", bd, 10);
        bd = new BigDecimal("2.49");
        Items p2 = new Items("2", "Canada Dry", bd, 12);
        testDao.addItem(p1.getItemId(), p1);
        testDao.addItem(p2.getItemId(), p2);
        Items removeItem = testDao.removeItem(p1.getItemId());
        assertEquals(removeItem, p1, "The removed product should be Fanta");
        //result
        List<Items> result = testDao.getAllItems();
        //test result
        assertNotNull(result, "The list of products must not null.");
        assertEquals(1, result.size(), "List of products should have 1 item.");
        //test removed p2
        removeItem = testDao.removeItem(p2.getItemId());
        assertEquals(removeItem, p2, "The removed product should be Canada Dry.");
        //test result
        result = testDao.getAllItems();
        assertEquals(0, result.size(), "List of products should have 0 items.");
        //test for empty list
        Items retrievedItems = testDao.getItem(p1.getItemId());
        assertNull(retrievedItems, "Fanta was removed, should be null.");
        retrievedItems = testDao.getItem(p2.getItemId());
        assertNull(retrievedItems, "Canada Dry was removed, should be null.");
    }
 }
