import java.util.*;

class CancelAndRefund {
    private BookTickets bookTickets;

    public CancelAndRefund(BookTickets bookTickets) {
        this.bookTickets = bookTickets;
    }

    public void cancelTickets() {
        Scanner sc = new Scanner(System.in);
        Map<String, List<String>> userBookings = bookTickets.getUserBookings();

        if (userBookings.isEmpty()) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Your Booked Movies:");
        List<String> moviesList = new ArrayList<>(userBookings.keySet());
        for (int i = 0; i < moviesList.size(); i++) {
            System.out.println((i + 1) + ". " + moviesList.get(i) + " (Seats: " + userBookings.get(moviesList.get(i)) + ")");
        }

        System.out.print("Enter the number to the movie you want to cancel tickets for: ");
        int movieChoice = sc.nextInt();
        sc.nextLine(); // Consume the newline character

        if (movieChoice < 1 || movieChoice > moviesList.size()) {
            System.out.println("Invalid choice. Try again.");
            return;
        }

        String movieToCancel = moviesList.get(movieChoice - 1);
        System.out.println("Selected Movie: " + movieToCancel);

        System.out.print("Enter seats to cancel (e.g : A1,B2): ");
        String[] seatsToCancel = sc.nextLine().split(",");
        List<String> remainingSeats = userBookings.get(movieToCancel);

        // Remove canceled seats
        boolean allSeatsValid = true;
        for (String seat : seatsToCancel) {
            if (!remainingSeats.contains(seat.trim())) {
                allSeatsValid = false;
                System.out.println("Invalid seat: " + seat + ". It was not booked.");
            }
        }

        if (allSeatsValid) {
            remainingSeats.removeAll(Arrays.asList(seatsToCancel));
            if (remainingSeats.isEmpty()) {
                userBookings.remove(movieToCancel);
                System.out.println("All seats for " + movieToCancel + " have been canceled.");
            } else {
                userBookings.put(movieToCancel, remainingSeats);
                System.out.println("Remaining seats for " + movieToCancel + ": " + remainingSeats);
            }
            System.out.println("Tickets canceled successfully!");
        } else {
            System.out.println("Please verify your seat selection and try again.");
        }
    }
}
