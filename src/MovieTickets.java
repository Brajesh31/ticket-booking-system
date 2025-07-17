import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

class MovieTickets {
    private Scanner sc = new Scanner(System.in);
    private String name;
    private String phone;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void welcome() {
        System.out.println("Welcome to PVR Cinemas!");
        System.out.print("Enter your Name: ");
        name = sc.nextLine();
        System.out.print("Enter your Phone Number: ");
        phone = sc.nextLine();
        saveToExcel();
    }

    private void saveToExcel() {
        try (FileWriter writer = new FileWriter("customerDetails.csv", true)) {
            writer.append(name).append(",").append(phone).append("\n");
            System.out.println("Details saved successfully!");
        } catch (IOException e) {
            System.out.println("Error saving details to file: " + e.getMessage());
        }
    }
}