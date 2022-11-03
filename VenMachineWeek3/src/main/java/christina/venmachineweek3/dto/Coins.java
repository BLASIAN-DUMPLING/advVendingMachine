/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.dto;

import java.math.BigDecimal;

/**
 *
 * @author chris
 */
public class Coins {
  private int quarters;
    private int dimes;
    private int nickles;
    private int pennies;
    
    public Coins (BigDecimal amount) {
        this.quarters = amount.divide(new BigDecimal("25")).intValue();
        amount = amount.remainder(new BigDecimal("25"));
        this.dimes = amount.divide(new BigDecimal("10")).intValue();
        amount = amount.remainder(new BigDecimal("10"));
        this.nickles = amount.divide(new BigDecimal("5")).intValue();
        amount = amount.remainder(new BigDecimal("5"));
        this.pennies = amount.divide(new BigDecimal("1")).intValue();
        amount = amount.remainder(new BigDecimal("1"));
    }

    
//constructors used to initalize so no need for setter method
    public int getQuarters(){
        return quarters;
    }

    public int getDimes(){
        return dimes;
    }

    public int getNickles(){
        return nickles;
    }

    public int getPennies(){
        return pennies;
    }
  
}
