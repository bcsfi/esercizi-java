package net.bcsoft.divisioneperzero;
import java.util.Random;
public class Calc {
    public static int division(int userNumber){
        Random generator = new Random();
        int randNumber;
        randNumber = generator.nextInt(3);
        System.out.println("numero random: " + randNumber);
        return userNumber / randNumber;
    }
}
