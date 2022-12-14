/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package christina.venmachineweek3.ui;

import java.math.BigDecimal;

/**
 *
 * @author chris
 */
public interface UserIO {
     void print(String msg);

    String readString(String prompt);

    int readInt(String prompt);

    int readInt(String prompt, int min, int max);
    
    double readDouble(String prompt);

    double readDouble(String prompt, double min, double max);

    float readFloat(String prompt);

    float readFloat(String prompt, float min, float max);

    long readLong(String prompt);

    long readLong(String prompt, long min, long max);

    BigDecimal readBigDecimal(String prompt);

    BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max);

}
