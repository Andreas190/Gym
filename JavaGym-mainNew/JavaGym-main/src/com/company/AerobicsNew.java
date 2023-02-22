package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class AerobicsNew {
    static ArrayList<String> aerobicsbooked = new ArrayList<>(18);
    static ArrayList<String> aerobicsavailable = new ArrayList<>(9);

    static {
        aerobicsavailable.add("1a");
        aerobicsavailable.add("1b");
        aerobicsavailable.add("1c");
        aerobicsavailable.add("2a");
        aerobicsavailable.add("2b");
        aerobicsavailable.add("2c");
        aerobicsavailable.add("3a");
        aerobicsavailable.add("3b");
        aerobicsavailable.add("3c");
    }

    public static void aerobics() {
        Scanner input = new Scanner(System.in);
        String response = "";
        String bookingstop = "stop";
        String passresponse;
        String str = "";
        String aerobics = "aerobics";

        if (aerobicsbooked.size() >= 18) {
            System.out.println("\nSorry, aerobics class is fully booked");
            Booking.booking();
        }
        else {
            System.out.printf("\nWelcome to aerobics class. %nTo continue, enter 'aerobics' again otherwise exit with 'stop': ");
            response = input.nextLine();

            if (response.equalsIgnoreCase(bookingstop)) {
                Booking.booking();
            }
            else if (!response.equalsIgnoreCase(aerobics)) {
                System.out.printf("%nTry again. %n");
                AerobicsNew.aerobics();
            }
        }
            while (response.equalsIgnoreCase(aerobics)) {
                if (aerobicsbooked.contains(Login.currentUser.get(Login.currentUser.size() - 1))) {
                    System.out.printf("%nSorry, you've already booked a spot for this exercise. Try a different activity.%n");
                    Booking.booking();
                    break;
                }
                else for (String aerobicsspots : aerobicsavailable) {
                    str += aerobicsspots + ",";
                }

                System.out.printf("Choose one of these placings or exit with 'stop': %s: ", aerobicsavailable); // available choice after entry
                passresponse = input.nextLine();

                if (passresponse.equalsIgnoreCase(bookingstop)) {
                    Booking.booking();
                    break;
                }
                // if placing already booked error message
                if (aerobicsbooked.contains(passresponse)) {
                    System.out.printf("%nThis place is already booked. Try again.");
                }
                // if passresponse doesn't match one of aerobicsavailable placings.
                if (!aerobicsavailable.contains(passresponse)) {
                    System.out.printf("%nEnter a valid placing.%n");
                }
                else {
                    aerobicsbooked.add(passresponse);
                    aerobicsavailable.remove(passresponse);
                    aerobicsbooked.add(Login.currentUser.get(Login.currentUser.size() - 1));
                    System.out.printf("%nAerobics booking successful! You have placing: %s.%nHow about a different activity as well?...%n%n", passresponse);
                    Booking.booking();
                    break;
                }
            }
        }
    }
