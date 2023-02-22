package com.company;

import java.util.ArrayList;
import java.util.Scanner;

import static com.company.Register.addNewMember;


public class Login {
    static ArrayList<String> currentUser = new ArrayList<>();


    public ArrayList<String> displayCurrentUser() {
        return Login.currentUser;
    }

    public  Login(){
        // printing list to see that member is in list
        Scanner sc= new Scanner(System.in);
        System.out.print("To log in enter your 10 digit personal ID number: ");
        String idNummer = sc.nextLine();

        // if list contains member login and choose exercise
        if(addNewMember.contains(idNummer))
        {
            System.out.println("\nWelcome to your account!");
            currentUser.add(idNummer);

            // when logged in run booking
           Booking.booking();
        }
        else
        // error message if not member
        {
            System.out.println("\nUnsuccessful Login.\nChoose again from the option menu.\n(NB: Make sure you are registered first to use Gym WakeUp app (choose menu option 3).\n");
        }
    }
}
