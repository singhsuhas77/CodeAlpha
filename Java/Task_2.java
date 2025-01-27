import java.util.ArrayList;
import java.util.Scanner;

class Destination {
    String name;
    String date;
    String preferences;
    double budget;

    public Destination(String name, String date, String preferences, double budget) {
        this.name = name;
        this.date = date;
        this.preferences = preferences;
        this.budget = budget;
    }

    @Override
    public String toString() {
        return "Destination: " + name + "\n" +
                "Date: " + date + "\n" +
                "Preferences: " + preferences + "\n" +
                "Budget: ₹" + budget;
    }
}

public class Task_2 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Destination> itinerary = new ArrayList<>();

        System.out.println("Welcome to the Travel Itinerary Planner!");

        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. Add Destination");
            System.out.println("2. View Itinerary");
            System.out.println("3. Calculate Total Budget");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    addDestination(scanner, itinerary);
                    break;
                case 2:
                    viewItinerary(itinerary);
                    break;
                case 3:
                    calculateTotalBudget(itinerary);
                    break;
                case 4:
                    System.out.println("Thank you for using the Travel Itinerary Planner. Safe travels!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void addDestination(Scanner scanner, ArrayList<Destination> itinerary) {
        System.out.print("\nEnter the destination name: ");
        String name = scanner.nextLine();
        System.out.print("Enter the travel date (e.g., YYYY-MM-DD): ");
        String date = scanner.nextLine();
        System.out.print("Enter your preferences (e.g., sightseeing, relaxation, adventure): ");
        String preferences = scanner.nextLine();
        System.out.print("Enter the budget for this destination: ");
        double budget = scanner.nextDouble();
        scanner.nextLine(); // Consume newline

        Destination destination = new Destination(name, date, preferences, budget);
        itinerary.add(destination);
        System.out.println("Destination added successfully!\n");
    }

    private static void viewItinerary(ArrayList<Destination> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("\nYour itinerary is empty. Add some destinations first.\n");
        } else {
            System.out.println("\n===== Your Travel Itinerary =====");
            for (int i = 0; i < itinerary.size(); i++) {
                System.out.println("\nDestination " + (i + 1) + ":");
                System.out.println(itinerary.get(i));
            }
        }
    }

    private static void calculateTotalBudget(ArrayList<Destination> itinerary) {
        if (itinerary.isEmpty()) {
            System.out.println("\nYour itinerary is empty. Add some destinations first.\n");
        } else {
            double totalBudget = 0;
            for (Destination destination : itinerary) {
                totalBudget += destination.budget;
            }
            System.out.println("\nTotal Budget for your trip: ₹" + totalBudget + "\n");
        }
    }
}
