package com.company;
import java.util.ArrayList;
import java.util.Scanner;
import static com.company.Authentication.luhn_validering;
import static com.company.Authentication.printInprompt;

public class Register {
    // list for members
    static ArrayList<String> addNewMember = new ArrayList<>();

    public Register() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter your 10 digit personal ID number:");
        String personalNumber = sc.nextLine();
        // if validation is valid add member in list and give member choice for membership
        boolean personalNumberCheck = luhn_validering(personalNumber);
        printInprompt(personalNumberCheck);

        if(personalNumberCheck)
        {
            addNewMember.add(personalNumber);
            System.out.println("\nSuccessful registration" );
            new Membertype();
        }
        // error message if not authenticated
        else
        {
            System.out.println("\nRegistration unsuccessful. Your 10 digit personal ID number could not be authenticated. Please try again");
        }
    }
}



