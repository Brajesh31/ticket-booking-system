import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

class SelectScreen {
    private Map<Integer, String> movies = new HashMap<>();
    private Map<Integer, int[][]> seatLayouts = new HashMap<>();
    private int selectedScreen;

    public SelectScreen() {
        movies.put(1, "Avatar (International, 150 rs.)");
        movies.put(2, "Inception (International, 150 rs.)");
        movies.put(3, "Pushpa (Local, 80 rs.)");
        movies.put(4, "Kantara (Local, 80 rs.)");

        for (int i = 1; i <= 4; i++) {
            seatLayouts.put(i, new int[5][10]);
        }
    }

    public void showMovies() {
        System.out.println("\nAvailable Movies and Screens:");
        for (Map.Entry<Integer, String> entry : movies.entrySet()) {
            System.out.println(entry.getKey() + ". Screen " + entry.getKey() + ": " + entry.getValue());
        }
    }

    public void viewSeats() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Select a screen to view seats:");
        showMovies();
        selectedScreen = sc.nextInt();

        if (!movies.containsKey(selectedScreen)) {
            System.out.println("Invalid screen. Try again.");
            return;
        }

        displaySeatLayout(seatLayouts.get(selectedScreen));
    }

    public int getSelectedScreen() {
        return selectedScreen;
    }

    public int[][] getSeatLayout(int screen) {
        return seatLayouts.get(screen);
    }

    public String getMovieDetails(int screen) {
        return movies.get(screen);
    }

    public void displaySeatLayout(int[][] seats) {
        System.out.println("\nSeat Layout (O: Available, X: Booked):");
        System.out.println("  1  2  3  4  5  6  7  8  9 10");
        for (int i = 0; i < 5; i++) {
            System.out.print((char) ('A' + i) + " ");
            for (int j = 0; j < 10; j++) {
                System.out.print((seats[i][j] == 1 ? "X" : "O") + "  ");
            }
            System.out.println();
        }
    }
}