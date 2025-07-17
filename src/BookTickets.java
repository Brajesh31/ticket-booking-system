import java.util.*;

class BookTickets
{
    private Scanner sc = new Scanner(System.in);
    private SelectScreen selectScreen;
    private List<String> bookedTickets = new ArrayList<>();
    private Map<String, List<String>> userBookings = new HashMap<>();
    private double totalAmount;
    private String movieDetails;

    public BookTickets(SelectScreen selectScreen) {
        this.selectScreen = selectScreen;
    }

    public void bookTickets() {
        selectScreen.showMovies();
        System.out.print("Select the screen for the movie you want to book: ");
        int screenChoice = sc.nextInt();

        if (!selectScreen.getMovieDetails(screenChoice).equals(selectScreen.getMovieDetails(screenChoice))) {
            System.out.println("Invalid screen selected. Try again.");
            return;
        }

        movieDetails = selectScreen.getMovieDetails(screenChoice);
        System.out.println("Selected Movie: " + movieDetails);

        int[][] currentSeats = selectScreen.getSeatLayout(screenChoice);
        System.out.print("Enter number of tickets to book: ");
        int ticketCount = sc.nextInt();
        double pricePerTicket = movieDetails.contains("International") ? 150 : 80;

        selectScreen.displaySeatLayout(currentSeats);

        bookedTickets.clear();
        for (int i = 0; i < ticketCount; i++) {
            System.out.print("Enter seat " + (i + 1) + " (e.g., A1): ");
            String seat = sc.next().toUpperCase();
            if (!selectSeat(currentSeats, seat)) {
                i--;
            } else {
                bookedTickets.add(seat);
            }
        }

        totalAmount = bookedTickets.size() * pricePerTicket;
        System.out.println("\nBooking Confirmed!");
        System.out.println("Movie: " + movieDetails);
        System.out.println("Seats: " + bookedTickets);
        System.out.println("Total Amount: " + totalAmount + " rs.");

        userBookings.put(movieDetails, bookedTickets);
    }

    private boolean selectSeat(int[][] seats, String seat) {
        int row = seat.charAt(0) - 'A';
        int col = Integer.parseInt(seat.substring(1)) - 1;

        if (row < 0 || row >= 5 || col < 0 || col >= 10 || seats[row][col] == 1) {
            System.out.println("Invalid or already booked seat. Try again.");
            return false;
        }

        seats[row][col] = 1;
        return true;
    }

    public Map<String, List<String>> getUserBookings() {
        return userBookings;
    }
}