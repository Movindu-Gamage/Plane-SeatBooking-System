import java.util.Scanner;

public class PlaneManagement {
    static int[][] seats = new int[4][];  // 4 rows total

    static {
        seats[0] = new int[14]; // Row A
        seats[1] = new int[12]; // Row B
        seats[2] = new int[12]; // Row C
        seats[3] = new int[14]; // Row D
    }

    static int[] rowPrices = {200, 150, 150, 180};

    static Ticket[] tickets = new Ticket[100];
    static int ticketCount = 0;

    public static void main(String[] args) {
        Scanner input  = new Scanner(System.in);

        System.out.println("Welcome to the plane Management application");


        int option;

        do {
            System.out.println("\n========= MENU =========");
            System.out.println("1. Buy seat");
            System.out.println("2. Cancel seat");
            System.out.println("3. Find first available seat");
            System.out.println("4. Show seating plan");
            System.out.println("5. Print tickets info");
            System.out.println("0. Exit");
            System.out.println("========================");
            System.out.print("Choose an option: ");

            option = input.nextInt();

            switch (option) {
                case 1:
                   buySeats();
                    break;
                case 2:
                    cancelSeat();
                    break;
                case 3:
                    find_first_available();
                    break;
                case 4:
                    show_seating_plan();
                    break;
                case 5:
                     print_tickets_info();
                    break;
                case 0:
                    System.out.println("Exiting program...");
                    break;
                default:
                    System.out.println("Invalid option! Please try again.");
            }

        }while (option != 0);
    }

    public static void buySeats(){
        Scanner input = new Scanner(System.in);
        System.out.println("Tickets Prices: Row A: 200 || Row B: 150 || Row C: 150 || Row D: 180 \n");

        System.out.print("Enter the row letter (A-D): ");
        char rowLetter = input.next().toUpperCase().charAt(0);

        System.out.print("Enter the seat number: ");
        int seatNumber = input.nextInt();

        int rowIndex = rowToIndex(rowLetter);

        if(rowIndex == -1 || seatNumber < 1 ){
            System.out.println("Invalid Row or Seat Number");
            return;
        }
        if (seats[rowIndex][seatNumber - 1 ] == 1){
            System.out.println("The seat already booked...");
        }else {
            System.out.print("Enter Name: ");
            String name = input.next();

            System.out.print("Enter Surname: ");
            String surName = input.next();

            System.out.print("Enter Email: ");
            String email = input.next();

            Person person = new Person(name,surName,email);
            int price  = rowPrices[rowIndex];
            Ticket ticket = new Ticket(rowLetter,seatNumber,price,person);

            seats[rowIndex][seatNumber - 1] = 1;
            tickets[ticketCount] = ticket;
            ticketCount++;

            ticket.save();
            System.out.println("Seat " + rowLetter + seatNumber + " Successfully Booked");

        }

    }

    public static void cancelSeat(){
        Scanner input = new Scanner(System.in);

        System.out.print("Enter the row letter (A-D): ");
        char rowLetter = input.next().toUpperCase().charAt(0);

        System.out.print("Enter the seat number: ");
        int seatNumber = input.nextInt();

        int rowIndex = rowToIndex(rowLetter);

        if (rowIndex == -1 || seatNumber < 1){
            System.out.println("Invalid Row or Seat Number...");
            return;
        }
        if (seats[rowIndex][seatNumber - 1] == 0) {
            System.out.println("Seat is already available.");
        } else {
            seats[rowIndex][seatNumber - 1] = 0;
            System.out.println("Seat " + rowLetter + seatNumber + " cancelled successfully.");
        }
    }

    public static void find_first_available(){
        char [] rows = {'A', 'B', 'C', 'D'};

        for (int i = 0; i < seats.length; i++){
            for (int j = 0; j < seats[i].length; j++){
                if (seats[i][j] == 0){
                    System.out.println("First available seat: " + rows[i] + (j + 1));
                    return;
                }
            }
        }
        System.out.println("No seats Left");
    }

    public static void show_seating_plan() {
        char[] rows = {'A', 'B', 'C', 'D'};

        for (int i = 0; i < seats.length; i++) {
            System.out.print(rows[i] + " " + " ");
            for (int j = 0; j < seats[i].length; j++) {

                if (seats[i][j] == 0) {
                    System.out.print("O ");  // Available
                } else {
                    System.out.print("X ");  // Sold
                }
            }
            System.out.println();
        }
    }

    public static void print_tickets_info() {
        if (ticketCount == 0) {
            System.out.println("No tickets sold yet.");
            return;
        }

        int total = 0;
        for (int i = 0; i < ticketCount; i++) {
            tickets[i].displayTicketInfo();
            System.out.println("-----------------");
            total += tickets[i].getPrice();
        }
        System.out.println("Total sales: £" + total);
    }





    // Convert row letter to index
    public static int rowToIndex(char row) {
        switch (row) {
            case 'A': return 0;
            case 'B': return 1;
            case 'C': return 2;
            case 'D': return 3;
            default: return -1;
        }
    }

}

