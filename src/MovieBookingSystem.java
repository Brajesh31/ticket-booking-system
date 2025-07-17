import java.util.*;
import java.io.*;

// Main Class
public class MovieBookingSystem {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        MovieTickets movieTickets = new MovieTickets();
        movieTickets.welcome();

        SelectScreen selectScreen = new SelectScreen();
        BookTickets bookTickets = new BookTickets(selectScreen);
        CancelAndRefund cancelAndRefund = new CancelAndRefund(bookTickets);
        ShowBookedTickets showBookedTickets = new ShowBookedTickets(bookTickets);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. View Available Seats for a Screen");
            System.out.println("2. Book Tickets");
            System.out.println("3. Cancel Tickets");
            System.out.println("4. Show Booked Tickets");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            int choice = sc.nextInt();

            switch (choice) {
                case 1:
                    selectScreen.viewSeats();
                    break;
                case 2:
                    bookTickets.bookTickets();
                    break;
                case 3:
                    cancelAndRefund.cancelTickets();
                    break;
                case 4:
                    showBookedTickets.displayBookedTickets();
                    break;
                case 5:
                    System.out.println("Thank you for using PVR Cinemas!");
                    return;
                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }
}
