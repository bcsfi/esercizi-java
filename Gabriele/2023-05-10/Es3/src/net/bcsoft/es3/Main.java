package net.bcsoft.es3;

import java.util.Scanner;

public class Main {
    public static void main(String[] args)  {
        String nome = null;
        int numeroConto = 0;
        double saldo = 0;
        double prelievo;
        BankAccount accountBancario = new BankAccount();
        Scanner input = new Scanner(System.in);
        try {
            System.out.println("Inserisci il tuo nome: ");
            nome = input.next();
            accountBancario.setNomeTitolare(nome);
            System.out.println("Inserisci il tuo numero di conto: ");
            numeroConto = input.nextInt();
            accountBancario.setNumeroConto(numeroConto);
            System.out.println("Inserisci il tuo saldo corrente: ");
            saldo = input.nextDouble();
            accountBancario.setSaldoConto(saldo);
            accountBancario.controlloAttributi();
        }
        catch(AttributeNullException e){
            System.out.println("AttributeNullException" + e.getMessage());

        }

        System.out.println("Quanti soldi vuoi prelevare? ");
        prelievo = input.nextDouble();
        try {
            accountBancario.collect(prelievo);
        }
        catch(InsufficentFoundException e){
            System.out.println("InsufficentFoundException: " + e.getMessage());
        }
    }
}