/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.dao;

import christina.venmachineweek3.dto.Items;
import christina.venmachineweek3.service.VendingMachinePersistenceException;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class VendingMachineDaoImpl implements VendingMachineDao {
    
    public final String ITEMS_FILE;
    private Map<String, Items> items = new HashMap<>();

  
    public VendingMachineDaoImpl(){
        ITEMS_FILE = "item.txt";
    }
    public VendingMachineDaoImpl (String itemsTextFile) {
        ITEMS_FILE = itemsTextFile;
    }
            
   
    @Override
    public Map<String, Items> loadItemsFromFile() throws VendingMachinePersistenceException{
        Scanner scanner;
        try {
            scanner = new Scanner(new BufferedReader(new FileReader(ITEMS_FILE)));
        } catch (FileNotFoundException ex) {
            throw new VendingMachinePersistenceException("-_- Could not load roster data into memory", ex);
        }
            String currentLine;
            Items currentItems;

            while (scanner.hasNextLine()) {
                currentLine = scanner.nextLine();
                currentItems = new Items(currentLine);
                items.put(currentItems.getItemId(), currentItems);
            }
            scanner.close();
            return items;
        }

        @Override
    public void writeItemsToFile() throws VendingMachinePersistenceException{
        PrintWriter out;
        try {
            out = new PrintWriter(new FileWriter(ITEMS_FILE));
        } catch (IOException ex){
            throw new VendingMachinePersistenceException("Could not save item data.");
        }
        String itemAsText;
        List<Items> itemList = this.getAllItems();
        for (Items currentItems : itemList) {
            itemAsText = currentItems.marshalItemAsText();
            out.println(itemAsText);
            out.flush();
        }
        out.close();       
        
    }
      
    @Override
    public Items addItem(String itemId, Items item) {
        Items prevItem = items.put(itemId, item);
        return prevItem;
    }

    @Override
    public List<Items> getAllItems() {
        return new ArrayList<Items>(items.values());
    }

    @Override
    public List<String> getAllItemsId() {
        return new ArrayList<>(items.keySet());
    }

    @Override
    public Items getItem(String itemId) {
        return items.get(itemId);
    }

    @Override
    public Items updateItem(String itemId, Items item) {
        return items.replace(itemId, item);
    }

    @Override
    public Items removeItem(String itemId) {
        Items removedItem = items.remove(itemId);
        return removedItem;
    }
}
