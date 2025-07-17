import java.util.List;
import java.util.Map;

// ShowBookedTickets Class
class ShowBookedTickets {
    private BookTickets bookTickets;

    public ShowBookedTickets(BookTickets bookTickets) {
        this.bookTickets = bookTickets;
    }

    public void displayBookedTickets() {
        Map<String, List<String>> userBookings = bookTickets.getUserBookings();

        if (userBookings.isEmpty()) {
            System.out.println("No tickets booked.");
            return;
        }

        System.out.println("Your Booked Tickets:");
        for (Map.Entry<String, List<String>> entry : userBookings.entrySet()) {
            System.out.println("Movie: " + entry.getKey() + ", Seats: " + entry.getValue());
        }
    }
}
