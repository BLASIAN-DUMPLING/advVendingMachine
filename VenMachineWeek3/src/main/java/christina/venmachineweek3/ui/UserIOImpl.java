/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package christina.venmachineweek3.ui;

import java.math.BigDecimal;
import java.util.Scanner;

/**
 *
 * @author chris
 */
public class UserIOImpl implements UserIO {

    final private Scanner input = new Scanner(System.in);

    @Override
    public void print(String message) {
      System.out.println(message);  
    }
    
    @Override
    public String readString(String prompt) {
       while (true) {
        System.out.println(prompt);
        return input.nextLine(); }
    }

    @Override
    public double readDouble(String prompt) {
        while (true) {
            try {
                return Double.parseDouble(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public double readDouble(String prompt, double min, double max) {
        double result;
        do {
            result = readDouble(prompt);
        } while (result < min || result > max);
        return result;
    }

    @Override
    public float readFloat(String prompt) {
        while (true) {
            try {
                return Float.parseFloat(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public float readFloat(String prompt, float min, float max) {
        float result;
        do {
            result = readFloat(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public int readInt(String prompt) {
        boolean invalidInput = true;
        int num = 0;
        while (invalidInput) {
            try {
                
                String stringValue = this.readString(prompt);
        
                num = Integer.parseInt(stringValue); 
                invalidInput = false; 
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
        return num;
    }

    @Override
    public int readInt(String prompt, int min, int max) {
        int result;
        do {
            result = readInt(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public long readLong(String prompt) {
        while (true) {
            try {
                return Long.parseLong(this.readString(prompt));
            } catch (NumberFormatException e) {
                this.print("Input error. Please try again.");
            }
        }
    }

    @Override
    public long readLong(String prompt, long min, long max) {
        long result;
        do {
            result = readLong(prompt);
        } while (result < min || result > max);

        return result;
    }

    @Override
    public BigDecimal readBigDecimal(String prompt) {
        BigDecimal bigDecimalInput = null;
        boolean invalidInput = true;
           while (invalidInput) {
            try {
                System.out.println(prompt);
                String stringInput = input.nextLine();
                bigDecimalInput = new BigDecimal(stringInput); 
                invalidInput = false;
            } catch (NumberFormatException e) {
                this.print("Input error. Please enter numbers only again."); 
            }
        }
        return bigDecimalInput;
    }
   

    @Override
    public BigDecimal readBigDecimal(String prompt, BigDecimal min, BigDecimal max) {
      
    return null;
}
    
}
