/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package helper;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

/**
 *
 * @author samuelbond
 */
public class RandomGenerator {
    private int digit;
    
   public RandomGenerator(int digit) {
        this.digit = digit;
    }
   
    public String generate(){
        StringBuilder random = new StringBuilder();
        Random rand = new Random();
        String[] sh = {"A", "B", "C", "D", "E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V",
                      "W","X","Y","Z"}; 
       List<String> input = new ArrayList<>();
        input.addAll(Arrays.asList(sh));
        
        for(int k =0; k < this.digit; k++){
        int num = (2-1)+1;
        long fraction = (long)(num * rand.nextDouble());
        num = (int) (fraction+1);
         if(num == 1){
             random.append(input.get(rand.nextInt(input.size())));
         }
         else{
            random.append(rand.nextInt(9));
         }
        }
        
        return random.toString();
    }
    
    
    public void setDigit(int digit) {
        this.digit = digit;
    } 
}
