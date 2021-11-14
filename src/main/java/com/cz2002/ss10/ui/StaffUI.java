package com.cz2002.ss10.ui;

import java.util.Scanner;
import java.util.ArrayList;

public class StaffUI {
    public static int getStaffInsertionChoice() {
        int choice = 0;
        Scanner sc = new Scanner(System.in);
        do {
            System.out.println("Which Action would you like to perform?");
            System.out.println("1. Insert staff via CSV");
            System.out.println("2. Insert staff manually");
            System.out.println("3. Back to Management Handler");
            choice = sc.nextInt();
            switch (choice) {
            case 1:
                System.out.println("Staff to be inserted by CSV!");
                return 1;
            case 2:
                System.out.println("Staff to be inserted manually!");
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

    public static ArrayList<String> getDetails() {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> staffDetails = new ArrayList<String>();
        System.out.println("What is name of the employee?");
        String name = sc.nextLine();
        staffDetails.add(name);
        System.out.println("What is gender of the employee?");
        char gender = sc.nextLine().charAt(0);
        staffDetails.add(Character.toString(gender));
        System.out.println("What is the chosen employee id?");
        int staffId = sc.nextInt();
        staffDetails.add(((Integer) staffId).toString());
        System.out.println("What is the job title for the employee?");
        String jobTitle = sc.nextLine();
        staffDetails.add(jobTitle);
        sc.close();
        return staffDetails;
    }

    public static String getFilePath() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the full path for the CSV file?");
        String filePath = sc.nextLine();
        sc.close();
        return filePath;
    }

    public static int getStaffId() {
        Scanner sc = new Scanner(System.in);
        System.out.println("What is the id for the staff to be removed?");
        int staffId = sc.nextInt();
        sc.close();
        return staffId;
    }
}
