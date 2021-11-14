package com.cz2002.ss10.ui;

import com.cz2002.ss10.objects.food.MenuItem;
import com.cz2002.ss10.objects.logistics.Order;
import com.cz2002.ss10.objects.person.Staff;
import com.cz2002.ss10.logistics.Reservation;
import com.cz2002.ss10.operations.RestaurantService;
import com.cz2002.ss10.RestaurantApp;
import java.util.*;
import java.time.*;



public class ReservationUI{

    Scanner sc = new Scanner(System.in);

    public void ReservationUIScreen() {
        printHeader("Reservation Booking System");
        System.out.println("1) Create a new reservation");
        System.out.println("2) Check reservation ");
        System.out.println("3) Remove reservation");
        System.out.println("0) Exit Application");
        

        int choice = sc.nextInt();
        switch (choice) {
            case 1:
                this.createNewReservation();
                break;
            case 2:
                this.checkReservation();
                break;
            case 3:
                this.removeReservation();
                break;
            case 0:
                return ;
            default:
                System.out.println("Please Choose a Valid Option.");
        }
        return 0;
    }

    /**
     * Method to create new reservation booking
     */
    public void createNewReservation(){
        
        String newCustName,strUserDate,strUserTime;
        int dinerSize =0,tableNo = 0, telNo = 0,temp =-1,time =-1,resvID=0;
        LocalDate resvDate = LocalDate.now();
        LocalDate limitDate = LocalDate.plusMonths(1);
        LocalTime resvTime = LocalTime.now();

        //format date to <d/MM/yyyy>
        DateTimeFormatter formatDate = DateTimeFormatter.ofPatter("d/MM/yyyy");        

        System.out.println("Creating Reservation Booking............................................");

        //get customerName
        System.out.print("Please enter the name you would like the reservation to be booked under: ");
        custName = sc.nextLine();
            
        //get telNo
        System.out.print("Please enter your contact number: ");
        telNo = sc.nextInt();

        //get date
        System.out.print("Current Date: " + resvDate +  "/n" + "Please enter date that you will like to make your booking<dd/MM/yyyy>: " + "/nPLease note that we only allow booking up to 1 month in advance ("+ limitDate +")");
        strUserDate = input.nextLine();
        LocalDate userDate= LocalDate.parse(strUserDate,formatDate);

        while (userDate.compareTo(resvDate)>1 || userDate.compareTo(resvDate)<0){
            System.out.println("ERROR: Please input a valid date between today and"+limitDate)
            strUserDate = input.nextLine();
            LocalDate userDate= LocalDate.parse(strUserDate,formatDate);
        }

        //get time
        
        System.out.println( "The restaurant operating hours are from "+ RestaurantApp.openingTime + " to " + RestaurantApp.closingTime + "Please enter the HOUR that you would like to make your booking <E.g if 1100,enter 11>");
        time =sc.nextInt();

        while(time< || time > 15){
            System.out.println("Please input the first 2 digits of the time you want to book that is within the opereating hours < E.g if 1100,enter 11 > :");
            time =sc.nextInt();
        }
            
        resvTime = LocalTime.of(time,00)
        

        //get dinerSize
        System.out.println("Please enter the number of pax that will be dining: "+"/n***Please note that we only have table seatings available for pax up to 5")
        dinerSize=sc.nextInt();
        while(dinerSize <=0||dinerSize>5){
            System.out.println("Error: Please input a number from 1 to 5 for the number of pax that will be dining: ")
            dinerSize=sc.nextInt();
        }

        //get reservationID
        System.out.println("Please enter the reservationID: ")
        resvIDe=sc.nextInt();

        RestaurantService.createNewReservation(resvID,userDate,  resvTime,  telNo,  custName, dinerSize);


    }



        
        

        
    


    /**
     * Method to check reservation booking(s) with telephone number.
     */
    private void checkReservation() {
        
        //Scanner sc = new Scanner(System.in);
        System.out.println("Checking of reservation booking............................................");
        System.out.print("Enter your telephone number linked to reservation(s): ");
        int telNo = sc.nextInt();
        
        if(RestaurantService.checkReservation(telNo)==false){
          System.out.println("Sorry, there is no reservation with the booking with the telephone Number "+ telNo);  
        }
    }

    private void removeReservation() {
        
        //Scanner sc = new Scanner(System.in);
        System.out.println("Remove Reservation Booking............................................");
        System.out.print("Enter your telephone number linked to reservation(s): ");
        int telNo = sc.nextInt();
        boolean existResv = false;

        if(RestaurantService.checkReservation(telNo)==true){
            RestaurantService.removeReservation(telNo);
        }
        else{
            System.out.println("Sorry, there is no reservation with the booking with the telephone Number "+ telNo);
        }
    }

    
}