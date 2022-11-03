/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package christina.venmachineweek3.dto;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 *
 * @author chris
 */
public enum CoinValues {
  pennies(new BigDecimal(0.01)),
    nickles(new BigDecimal(0.05)),
    dime(new BigDecimal(0.1)),
    quarters(new BigDecimal(0.25));
    
    private final BigDecimal value;

    private CoinValues(BigDecimal value) {
        this.value = value;
    }

    public BigDecimal getValue(){
        
        return value.setScale(2, RoundingMode.DOWN);
    }   
}
