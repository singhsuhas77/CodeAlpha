import java.util.ArrayList;
import java.util.Scanner;

class Room {
    int roomNumber;
    String category;
    boolean isAvailable;
    double price;

    public Room(int roomNumber, String category, boolean isAvailable, double price) {
        this.roomNumber = roomNumber;
        this.category = category;
        this.isAvailable = isAvailable;
        this.price = price;
    }

    @Override
    public String toString() {
        return "Room Number: " + roomNumber + " | Category: " + category + " | Price: ₹" + price + " | Available: " + (isAvailable ? "Yes" : "No");
    }
}

class Reservation {
    String guestName;
    int roomNumber;
    double payment;

    public Reservation(String guestName, int roomNumber, double payment) {
        this.guestName = guestName;
        this.roomNumber = roomNumber;
        this.payment = payment;
    }

    @Override
    public String toString() {
        return "Guest Name: " + guestName + " | Room Number: " + roomNumber + " | Payment: ₹" + payment;
    }
}

public class Task_3 {

    static ArrayList<Room> rooms = new ArrayList<>();
    static ArrayList<Reservation> reservations = new ArrayList<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        initializeRooms();

        System.out.println("Welcome to the Hotel Reservation System!");

        while (true) {
            System.out.println("\n===== Main Menu =====");
            System.out.println("1. View Available Rooms");
            System.out.println("2. Make a Reservation");
            System.out.println("3. View Reservations");
            System.out.println("4. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    viewAvailableRooms();
                    break;
                case 2:
                    makeReservation(scanner);
                    break;
                case 3:
                    viewReservations();
                    break;
                case 4:
                    System.out.println("Thank you for using the Hotel Reservation System. Goodbye!");
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.\n");
            }
        }
    }

    private static void initializeRooms() {
        rooms.add(new Room(101, "Single", true, 50.0));
        rooms.add(new Room(102, "Single", true, 50.0));
        rooms.add(new Room(201, "Double", true, 100.0));
        rooms.add(new Room(202, "Double", true, 100.0));
        rooms.add(new Room(301, "Suite", true, 200.0));
    }

    private static void viewAvailableRooms() {
        System.out.println("\n===== Available Rooms =====");
        for (Room room : rooms) {
            if (room.isAvailable) {
                System.out.println(room);
            }
        }
    }

    private static void makeReservation(Scanner scanner) {
        System.out.println("\n===== Make a Reservation =====");
        System.out.print("Enter your name: ");
        String guestName = scanner.nextLine();
        System.out.print("Enter room number to reserve: ");
        int roomNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        for (Room room : rooms) {
            if (room.roomNumber == roomNumber && room.isAvailable) {
                room.isAvailable = false;
                reservations.add(new Reservation(guestName, roomNumber, room.price));
                System.out.println("Reservation successful!\n");
                return;
            }
        }
        System.out.println("Room not available or invalid room number.\n");
    }

    private static void viewReservations() {
        System.out.println("\n===== Reservations =====");
        if (reservations.isEmpty()) {
            System.out.println("No reservations found.\n");
        } else {
            for (Reservation reservation : reservations) {
                System.out.println(reservation);
            }
        }
    }
}
