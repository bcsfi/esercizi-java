import java.lang.reflect.AccessFlag;
import java.sql.Array;
import java.util.Scanner;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.Vector;
import java.lang.reflect.Method;

class Main {

    public static void main(String[] args) {

        int[] intArray = {0, 2, 4, 6, 8, 10, 9, 7, 5, 3, 1};

        int total = intArray.length;
        int backInt = 0;

        for(int i=0; i < intArray.length/2+1; i++){

            if(intArray.length/2+1 > intArray.length/2+1){break;}
            backInt = total-1;
            total--;
            System.out.print(intArray[i]);
            System.out.print(intArray[backInt]);



        }

    }

}



