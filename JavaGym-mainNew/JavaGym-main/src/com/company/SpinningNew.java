package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class SpinningNew {
    static ArrayList<String> spinningbooked = new ArrayList<>(18);
    static ArrayList<String> spinningavailable = new ArrayList<>(9);

    static {
        spinningavailable.add("1a");
        spinningavailable.add("1b");
        spinningavailable.add("1c");
        spinningavailable.add("2a");
        spinningavailable.add("2b");
        spinningavailable.add("2c");
        spinningavailable.add("3a");
        spinningavailable.add("3b");
        spinningavailable.add("3c");
    }

    public static void spinning() {
        Scanner input = new Scanner(System.in);
        String response = "";
        String bookingstop = "stop";
        String passresponse;
        String str = "";
        String spinning = "spinning";

        if (spinningbooked.size() >= 18) {
            System.out.println("\nSorry, spinning class is fully booked");
            Booking.booking();
        }
        else {
            System.out.printf("\nWelcome to spinning class. %nTo continue, enter 'spinning' again otherwise exit with 'stop': ");
            response = input.nextLine();

            if (response.equalsIgnoreCase(bookingstop)) {
                Booking.booking();
            }
            else if (!response.equalsIgnoreCase(spinning)) {
                System.out.printf("%nTry again. %n");
                SpinningNew.spinning();
            }
        }
            while (response.equalsIgnoreCase(spinning)) {
                if (spinningbooked.contains(Login.currentUser.get(Login.currentUser.size() - 1))) {
                    System.out.printf("%nSorry, you've already booked a spot for this exercise. Try a different activity.%n");
                    Booking.booking();
                    break;
                }
                else for (String spinningspots : spinningavailable) {
                    str += spinningspots + ",";
                }

                System.out.printf("Choose one of these placings or exit with 'stop': %s: ", spinningavailable); // available choice after entry
                passresponse = input.nextLine();

                if (passresponse.equalsIgnoreCase(bookingstop)) {
                    Booking.booking();
                    break;
                }
                // if placing already booked error message
                if (spinningbooked.contains(passresponse)) {
                    System.out.printf("%nThis place is already booked. Try again.");
                }
                // if passresponse doesn't match one of spinningavailable placings.
                if (!spinningavailable.contains(passresponse)) {
                    System.out.printf("%nEnter a valid placing.%n");
                }
                else {
                    spinningbooked.add(passresponse);
                    spinningavailable.remove(passresponse);
                    spinningbooked.add(Login.currentUser.get(Login.currentUser.size() - 1));
                    System.out.printf("%nSpinning booking successful! You have placing: %s.%nHow about a different activity as well?...%n%n", passresponse);
                    Booking.booking();
                    break;
                }
            }
        }
    }
