package net.bcsoft.GameStore;

public class Main {
    public static void main(String[] args) {
        ConsoleGame gioco1 = new ConsoleGame("Elden ring", 60.00, 2022, "ps4");
        PCGame gioco2 = new PCGame("Fifa22", 59.99, 2023, "i7 12000k");

        System.out.println(gioco1.getTitolo());
       }
}