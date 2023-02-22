package com.company;

import java.util.Scanner;

public class Booking {

    public static void booking() {

        System.out.printf("Activity bookings! %nEnter yoga, aerobics, spinning or stop to exit:  ");

        Scanner input = new Scanner(System.in);
        String response = input.nextLine();
        String yoga = "yoga";
        String aerobics = "aerobics";
        String spinning = "spinning";
        String bookingstop = "stop";

        while (true) {
            if (response.equalsIgnoreCase(bookingstop)) {
                break;
            }
            if (response.equalsIgnoreCase(yoga)) {
                YogaNew.yoga();
                break;
            }
            if (response.equalsIgnoreCase(aerobics)) {
                AerobicsNew.aerobics();
                break;
            }
            else if (response.equalsIgnoreCase(spinning)) {
                SpinningNew.spinning();
                break;
            } else {
                System.out.println("Enter yoga, aerobics, spinning or stop: ");
                Booking.booking();
                break;
            }
        }
    }
}






