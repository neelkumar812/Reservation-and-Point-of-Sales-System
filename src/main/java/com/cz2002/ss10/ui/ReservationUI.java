package com.cz2002.ss10.ui;

import com.cz2002.ss10.objects.food.MenuItem;
import com.cz2002.ss10.objects.logistics.Order;
import com.cz2002.ss10.objects.person.Staff;
import com.cz2002.ss10.logistics.Reservation;
import java.util.*;
import java.time.*;



public class ReservationUI{

    Scanner sc = new Scanner(System.in);

    protected int generateMenuScreen() {
        printHeader("Reservation Booking System");
        System.out.println("1) Create a new reservation");
        System.out.println("2) Check reservation ");
        System.out.println("3) Remove reservation");
        System.out.println("4) List all current reservations");
        System.out.println("5) Check for expired reservations");
        System.out.println("6) Back to main menu");
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
            case 4:
                this.listReservations();
                break;
            case 5:
                this.checkExpiredReservations();
                break;
            case 6:
                return -1;
            case 0:
                return 1;
            default:
                throw new MenuChoiceInvalidException("Reservation Menu");
        }
        return 0;
    }

    //create newReservation
    public void createNewReservation(){
        Reservation newResv;
        String newCustName,strUserDate,strUserTime;
        int dinerSize =0,tableNo = 0, telNo = 0,temp =-1,time =-1;
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

        //get session and time
        while(temp=-1){
            System.out.println( "The restaurant operating hours are 1100-1500 for the AM Session and 1700-2200 for the PM Session"+"Please enter session that you would like to make your booking:"+"/nAM = 1" +  "/nPM = 2");
            temp = sc.nextInt();
            if (temp==1)
                Reservation.ReservationSession sess = Reservation.ReservationSession.AM;
                System.out.println("Please enter the hour that you would like to make your booking(AM Session: 1100-1500) < E.g if 1100,enter 11 > ");
                time =sc.nextInt();
                while(time<11 || time > 15){
                    System.out.println("Please input the first 2 digits of the time you want to book < E.g if 1100,enter 11 > :");
                    time =sc.nextInt();
                    }
                resvTime = LocalTime.of(time,00)

            else if(temp =2)
                Reservation.ReservationSession sess = Reservation.ReservationSession.PM;
                System.out.println("Please enter the hour that you would like to make your booking(PM Session: 1700-2200) < E.g if 1100,enter 11 > ");
                time =sc.nextInt();
                while(time<11 || time > 15){
                        System.out.println("Please input the first 2 digits of the time you want to book < E.g if 1100,enter 11 > :");
                        time =sc.nextInt();
                    }
                resvTime = LocalTime.of(time,00)

            else
                 System.out.println("Please enter a valid selection(1/2)")
        }

        //get dinerSize
        System.out.println("Please enter the number of pax that will be dining:"+"***Please note that we only have table seatings available for pax up to 4")
        dinerSize=sc.nextInt();
        while(dinerSize <=0||dinerSize>4){
            System.out.println("Error: Please input a number from 1 to 4 for the number of pax that will be dining: ")
            dinerSize=sc.nextInt();

        }
        

        newResv = new Reservation(LocalDate resDate, LocalTime resTime,char session, int contactNumber, String name, int dinerSize);

        System.out.println("Booking Completed, please note that the telephone number you gave will be the reference for your booking")
    }


    /**
     * Method to check reservation booking(s) with telephone number.
     */
    private void checkReservationBooking() {
        int count = 0;
        //Scanner input = new Scanner(System.in);
        System.out.println("Checking of reservation booking............................................");
        System.out.print("Enter your telephone number linked to reservation(s): ");
        int telNo = input.nextInt();

        count = printReservationLine(telNo);

        if (count == 0) {
            System.out.println("There are no reservation bookings linked to the telephone number.");
        }
    }

    private void removeReservationBooking() {
        //Scanner input = new Scanner(System.in);
        int count = 0;
        int resvId = 0;

        System.out.println("Remove Reservation Booking............................................");
        System.out.print("Enter telephone number linked to the reservation to be deleted: ");
        int telNo = input.nextInt();

        count = printReservationLine(telNo);


        if (count == 1) {
            System.out.print("Are you sure you want to delete this reservation (Y/N)? ");
            switch (Character.toUpperCase(input.nextLine().charAt(0))) {
                case 'Y':
                    Reservation.removeReservationFromList(telNo);
                    break;
                case 'N':
                    break;
                default:
                    System.out.println("Invalid option. Returning Reservation Menu...");
                    break;
            }

        } else
            System.out.println("There are no reservation bookings linked to the telephone number.");
    }

    private void checkExpiredReservations() {
        int expiredCount = 0;
        Reservation r;
        Iterator<Reservation> iter = MainApp.reservations.iterator();
        while (iter.hasNext()) {
            r = iter.next();
            if (r.getResvDate().equals(LocalDate.now()))
                if (DateTimeFormatHelper.getTimeDifferenceMinutes(LocalTime.now(), r.getResvTime()) <= -30) {
                    iter.remove();
                    expiredCount++;
                }
        }
        System.out.println(expiredCount + " reservations have since expired, and deleted from the system.");

    }

    /**
     * Method for listing all reservations made by customers, in ascending order of Reservation ID.
     */
    private void listReservations() {
        printHeader("List of all Reservations");
        System.out.printf("%-6s %-15s %-10s %-10s %-15s %-30s %-3s %-9s\n", "ID", "Date", "Session", "Time", "Tel. No", "Name", "Pax", "Table No.");
        printBreaks();
        for (Reservation r : RestaurantApp.reservations) {
            printReservationLine(r);
        }
    }

    /**
     * Overloaded method to print details of a single reservation
     *
     * @param r Reservation object
     */
    private void printReservationLine(Reservation r) {
        System.out.printf("%-6d %-15s %-10s %-10s %-15s %-30s %-3d %-9d\n",
                r.getReservationId(),
                DateTimeFormatHelper.formatToStringDate(r.getReservationDate()),
                r.getResvSession() == Reservation.ReservationSession.AM_SESSION ? 'AM' : 'PM',
                DateTimeFormatHelper.formatToStringTime(r.getReservationTime()),
                r.getCustomerContact(),
                r.getCustomerName(),
                r.getDinerSize(),
                r.getTableNum());
    }

    /**
     * Method to print details of reservation lines by phone number.
     * Uses overloaded method of same name {@link ReservationMenuUI#printReservationLine(Reservation)} that passes in Reservation object
     *
     * @param telNo String variable containing customer's telephone number
     * @return The number of reservations linked to the same telephone number passed in.
     */
    private int printReservationLine(String telNo) {
        int count = 0;
        System.out.println("Below are the reservations linked to the number " + telNo);
        System.out.printf("%-6s %-15s %-10s %-10s %-15s %-30s %-3s %-9s\n", "ID", "Date", "Session", "Time", "Tel. No", "Name", "Pax", "Table No.");
        printBreaks();
        for (Reservation r : MainApp.reservations) {
            if (telNo.equals(r.getCustomerContact())) {
                printReservationLine(r);
                count++;
            }
        }
        return count;
    }

    /**
     * Method to check if the restaurant is open to reservations for the morning session
     * given the specified date
     *
     * @param date    LocalDate variable
     * @param isToday Boolean variable indicating whether date input is today.
     * @return True if available, false if slot is taken
     */
    private boolean checkMorningSessionDate(LocalDate date, boolean isToday) {
        if (isToday &&
                LocalTime.now().isAfter(LocalTime.of(15, 00))) return false;

        int amCount = 0;
        for (Reservation r : MainApp.reservations) {
            if (r.getResvDate().isEqual(date) &&
                    r.getResvSession() == Reservation.ReservationSession.AM_SESSION)
                amCount++;
        }
        System.out.println("There are " + (MAX_TABLES - amCount) + " reservations slots free for the AM session.");
        return amCount < MAX_TABLES;
    }

    /**
     * Method to check if the restaurant is open to reservations for the evening session
     * given the specified date
     *
     * @param date    LocalDate variable
     * @param isToday Boolean variable indicating whether date input is today.
     * @return True if available, false if slot is taken
     */
    private boolean checkEveningSessionDate(LocalDate date, boolean isToday) {

        if (isToday &&
                LocalTime.now().isAfter(LocalTime.of(22, 00))) return false;

        int pmCount = 0;
        for (Reservation r : MainApp.reservations) {
            if (r.getResvDate().isEqual(date) &&
                    r.getResvSession() == Reservation.ReservationSession.PM_SESSION)
                pmCount++;
        }
        System.out.println("There are " + (MAX_TABLES - pmCount) + " reservations slots free for the PM session.");
        return pmCount < MAX_TABLES;
    }
}


        



        






    
   















