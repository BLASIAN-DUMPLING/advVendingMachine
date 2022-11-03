/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.service;

/**
 *
 * @author chris
 */
public class VendingMachineDataValidationException extends Exception {
    
    public VendingMachineDataValidationException(String message){
        super(message);
    }
    public VendingMachineDataValidationException (String message, Throwable cause){
        super (message, cause);
    }
    
}
