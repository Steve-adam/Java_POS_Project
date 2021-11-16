package com.company;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        int password = 333;
        System.out.print("Enter password: ");

        int inputPassword = input.nextInt();
        if (password == inputPassword){
            System.out.print("Enter name: ");
            String name = input.next();


            System.out.print("Select an Action: ");
            int action = input.nextInt();

            if(action == 1 || action==2){
                switch(action){
                    case 1 -> {
                        System.out.print("Enter number of products to purchase: ");
                        int numProducts = input.nextInt();
                        MakeSale Sales = new MakeSale(name,numProducts);
                        MyJDB connection = new MyJDB();
                        Sales.makeSale();
                        connection.connect();

                    }
                    case 2 -> {
                        ExitSystem exit = new ExitSystem();
                        exit.exitSystem();
                    }

                }
            }else{
                System.out.println("Invalid Operation");}
        }else{
            System.out.println("Incorrect Password");
        }


    }

}


