import java.util.ArrayList;
import java.util.Scanner;

public class Task_1 {

    public static void main(String[] args) {
        // Create an ArrayList to store student grades
        ArrayList<Integer> grades = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);

        // Input student grades
        System.out.println("Enter student grades out of 100 (-1 to stop):");
        while (true) {
            System.out.print("Enter grade: ");
            int grade = scanner.nextInt();
            if (grade == -1) {
                break; // Exit loop when -1 is entered
            } else if (grade < 0 || grade > 100) {
                System.out.println("Invalid grade. Please enter a value between 0 and 100.");
            } else {
                grades.add(grade);
            }
        }

        // Check if grades list is empty
        if (grades.isEmpty()) {
            System.out.println("No grades were entered.");
        } else {
            // Compute and display average, highest, and lowest scores
            double average = calculateAverage(grades);
            int highest = findHighest(grades);
            int lowest = findLowest(grades);

            System.out.println("\nResults:");
            System.out.println("Total students: " + grades.size());
            System.out.println("Average grade: " + average);
            System.out.println("Highest grade: " + highest);
            System.out.println("Lowest grade: " + lowest);
        }

        scanner.close();
    }

    // Method to calculate the average grade
    public static double calculateAverage(ArrayList<Integer> grades) {
        int sum = 0;
        for (int grade : grades) {
            sum += grade;
        }
        return (double) sum / grades.size();
    }

    // Method to find the highest grade
    public static int findHighest(ArrayList<Integer> grades) {
        int highest = grades.get(0);
        for (int grade : grades) {
            if (grade > highest) {
                highest = grade;
            }
        }
        return highest;
    }

    // Method to find the lowest grade
    public static int findLowest(ArrayList<Integer> grades) {
        int lowest = grades.get(0);
        for (int grade : grades) {
            if (grade < lowest) {
                lowest = grade;
            }
        }
        return lowest;
    }
}
