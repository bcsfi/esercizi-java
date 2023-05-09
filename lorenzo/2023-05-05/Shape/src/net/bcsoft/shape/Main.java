package net.bcsoft.shape;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int userInitialRequest = UserCLI.initialRequest();
        System.out.println(userInitialRequest);


        Shape rettangolo = new Rettangolo(13,14);
    }
}
