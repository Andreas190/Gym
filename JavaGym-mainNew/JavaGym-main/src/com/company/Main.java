package com.company;

import java.util.Scanner;

import static com.company.Login.currentUser;

public class Main {

    public static void main(String[] args) {
        // Menu to take in value
        Scanner sc = new Scanner(System.in);
        String textmenu = "\nWelcome to The Gym!\nChoose an option from the menu:\n1.Login\n2.Book exercise\n3.Register\n0.Exit";

        //Nested while loop to be able to go back when inside a choice
        while (true) {
            System.out.println(textmenu);
            int menu = sc.nextInt();

            if (menu == 0) {
                System.out.println("See you soon at the gym!");
                Login.currentUser.removeAll(currentUser);
                sc.close();
                System.exit(1);
            }

            if (menu == 1) {
                // Login in
                new Login();
            } else if (menu == 2) {
                // Login and book exercise
                new Login();
            } else if (menu == 3) {
                new Authentication();
                new Register();
            } else {
                System.out.println("Try again. Enter 0, 1, 2 or 3. ");
                }
        }
    }
}
















































