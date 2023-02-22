package com.company;

import java.util.ArrayList;
import java.util.Scanner;

public class YogaNew {
    static ArrayList<String> yogabooked = new ArrayList<>(18);
    static ArrayList<String> yogaavailable = new ArrayList<>(9);

    static {
        yogaavailable.add("1a");
        yogaavailable.add("1b");
        yogaavailable.add("1c");
        yogaavailable.add("2a");
        yogaavailable.add("2b");
        yogaavailable.add("2c");
        yogaavailable.add("3a");
        yogaavailable.add("3b");
        yogaavailable.add("3c");
    }

    public static void yoga() {
        Scanner input = new Scanner(System.in);
        String response = "";
        String bookingstop = "stop";
        String passresponse;
        String str = "";
        String yoga = "yoga";

        if (yogabooked.size() >= 18) {
            System.out.println("\nSorry, yoga class is fully booked");
            Booking.booking();
        }
        else {
            System.out.printf("\nWelcome to yoga class. %nTo continue, enter 'yoga' again otherwise exit with 'stop': ");
            response = input.nextLine();

            if (response.equalsIgnoreCase(bookingstop)) {
                Booking.booking();
            }
            else if (!response.equalsIgnoreCase(yoga)) {
                System.out.printf("%nTry again. %n");
                YogaNew.yoga();
            }
        }
            while (response.equalsIgnoreCase(yoga)) {
                if (yogabooked.contains(Login.currentUser.get(Login.currentUser.size() - 1))) {
                    System.out.printf("%nSorry, you've already booked a spot for this exercise. Try a different activity.%n");
                    Booking.booking();
                    break;
                }
                else for (String yogaspots : yogaavailable) {
                    str += yogaspots + ",";
                }

                System.out.printf("Choose one of these placings or exit with 'stop': %s: ", yogaavailable); // available choice after entry
                passresponse = input.nextLine();

                if (passresponse.equalsIgnoreCase(bookingstop)) {
                    Booking.booking();
                    break;
                }
                // if placing already booked error message
                if (yogabooked.contains(passresponse)) {
                    System.out.printf("%nThis place is already booked. Try again.");
                }
                // if passresponse doesnt match one of yogaavailable placings.
                if (!yogaavailable.contains(passresponse)) {
                    System.out.printf("%nEnter a valid placing.%n");
                }
                else {
                    yogabooked.add(passresponse);
                    yogaavailable.remove(passresponse);
                    yogabooked.add(Login.currentUser.get(Login.currentUser.size() - 1));
                    System.out.printf("%nYoga booking successful! You have placing: %s.%nHow about a different activity as well?...%n%n", passresponse);
                    Booking.booking();
                    break;
                }
            }
        }
    }
