package net.bcsoft.divisioneperzero;

public class DivisionePerZero {
    public static void main(String[] args){

        try {

            int numberUser = UserInput.getNumber();
            int operation = Calc.division(numberUser);

            System.out.print(operation);
        } catch (ArithmeticException e){
            System.out.print("IMPOSSIBILE DIVIDERE PER ZERO!");
        }

    }
}
