package com.cz2002.ss10.ui;

import java.util.Scanner;

import com.cz2002.ss10.utils.RevenueReportCsv.ReportDuration;

public class RevenueReportUI {
    public static ReportDuration getRevenueDuration() {
        Scanner sc = new Scanner(System.in);
        System.out.println("==================================================================");
        System.out.println("      What duration would you like for your revenue report?      ");
        System.out.println("                  1. Daily Sales (Today)                         ");
        System.out.println("                  2. Monthly Sales (This Month)                  ");
        System.out.println("                  3. Annual Sales (This Year)         		     ");
        System.out.println("                  4. Back to main menu                		     ");
        System.out.println("=================================================================");
        int selection = sc.nextInt();
        do {
            switch (selection) {
            case 1:
                return ReportDuration.DAY;
            case 2:
                return ReportDuration.MONTH;
            case 3:
                return ReportDuration.YEAR;
            default:
                System.out.println("Invalid choice.");
                break;
            }

        } while (selection != 4);
        sc.close();
        return ReportDuration.YEAR;
    }

    public static int getReportChoice() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Which Action would you like to perform?");
            System.out.println("1. Generate Revenue Report in Console");
            System.out.println("2. Export Revenue Report to CSV");
            System.out.println("3. Back to Management Handler");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Generating report in console!");
                return 1;
            case 2:
                System.out.println("Exporting report to CSV!");
                return 2;
            case 3:
                break;
            default:
                System.out.println("Invalid choice.");
            }
            sc.close();
            return 0;
        } while (choice != 3);
    }

    public static String getFilePath() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Where would the CSV file be stored?");
        String filePath = sc.nextLine();
        sc.close();
        return filePath;
    }
}
