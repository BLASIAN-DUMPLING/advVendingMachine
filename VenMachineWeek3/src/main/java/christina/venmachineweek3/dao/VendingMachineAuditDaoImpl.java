/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.dao;

import christina.venmachineweek3.service.VendingMachinePersistenceException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.time.LocalDateTime;

/**
 *
 * @author chris
 */
public class VendingMachineAuditDaoImpl implements VendingMachineAuditDao {
   
    public static final String  AUDIT_FILE = "audit.txt";
    
      
    @Override
    public void writeAuditEntry(String entry) throws VendingMachinePersistenceException{
        PrintWriter out;
        try{
            out = new PrintWriter(new FileWriter(AUDIT_FILE, true));
        } catch (IOException e){
            throw new VendingMachinePersistenceException("Could not persist audit information.", e);
        }
    

    LocalDateTime timestamp = LocalDateTime.now();
    out.print(timestamp.toString() + " : " + entry);
    out.flush();
    out.close();
}
    
}
