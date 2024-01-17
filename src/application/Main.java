package application;


import entities.Pessoa;
import entities.PessoaFisica;
import entities.PessoaJuridica;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        List<Pessoa> list = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the number of tax payers: ");
        int taxPayers = scanner.nextInt();
        for (int i = 1; i <= taxPayers; i++) {
            System.out.println("Tax payer #" + i + " data: ");
            System.out.print("Individual or Company (i/c)? ");
            char c = scanner.next().charAt(0);
            System.out.print("Name: ");
            scanner.nextLine();
            String name = scanner.nextLine();
            System.out.println("Annual income: ");
            double income = scanner.nextDouble();
            if(c == 'i'){
                System.out.print("Health expenditures: ");
                double healthExpenditures = scanner.nextDouble();
                list.add(new PessoaFisica(name, income, healthExpenditures));
            }
            else {
                System.out.print("Number of employees: ");
                int numberOfEmployees = scanner.nextInt();
                list.add(new PessoaJuridica(name, income, numberOfEmployees));
            }
        }
        double sum = 0.0;
        System.out.println();
        System.out.println("TAXES PAID:");
        for (Pessoa tp : list) {
            double tax = tp.PagarImposto();
            System.out.println(tp.getName() + ": $ " + String.format("%.2f", tax));
            sum += tax;
        }

        System.out.println();
        System.out.println("TOTAL TAXES: $ " + String.format("%.2f", sum));


        scanner.close();
    }
}