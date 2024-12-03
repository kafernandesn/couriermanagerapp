import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourierManager manager = new CourierManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("===============================");
        System.out.println(" Welcome to Delivery Dilemmas!");
        System.out.println("===============================");

        while (true) {
            System.out.println("\nPlease select an option:");
            System.out.println("1. Add a new package");
            System.out.println("2. Display all packages and shipping costs");
            System.out.println("3. Sort packages by weight");
            System.out.println("4. Search for a package by Tracking ID");
            System.out.println("5. Exit");
            System.out.print("\nEnter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter package type (Standard/Express): ");
                    String type = scanner.nextLine().trim();

                    System.out.print("Enter tracking ID: ");
                    String trackingID = scanner.nextLine();

                    System.out.print("Enter destination: ");
                    String destination = scanner.nextLine();

                    System.out.print("Enter weight: ");
                    double weight = scanner.nextDouble();
                    scanner.nextLine(); // Consume newline

                    try {
                        Package pkg;
                        if (type.equalsIgnoreCase("Standard")) {
                            pkg = new StandardPackage(trackingID, destination, weight);
                        } else if (type.equalsIgnoreCase("Express")) {
                            pkg = new ExpressPackage(trackingID, destination, weight);
                        } else {
                            System.out.println("Invalid package type!");
                            break;
                        }
                        manager.addPackage(pkg);
                        System.out.println("Package added successfully!");
                    } catch (IllegalArgumentException e) {
                        System.out.println("Error: " + e.getMessage());
                    }
                    break;

                case 2:
                    System.out.println("Package List:");
                    manager.displayPackages();
                    break;

                case 3:
                    manager.sortPackagesByWeight();
                    System.out.println("Packages sorted by weight!");
                    System.out.println("Sorted Package List:");
                    manager.displayPackages();
                    break;

                case 4:
                    System.out.print("Enter Tracking ID: ");
                    String searchID = scanner.nextLine();
                    Package foundPackage = manager.searchPackageByTrackingID(searchID);
                    if (foundPackage != null) {
                        System.out.println("Package Found:");
                        System.out.println(foundPackage + " | Cost: $" + String.format("%.2f", foundPackage.calculateShippingCost()));
                    } else {
                        System.out.println("Package not found!");
                    }
                    break;

                case 5:
                    System.out.println("Thank you for using Delivery Dilemmas!");
                    scanner.close();
                    return;

                default:git
                    System.out.println("Invalid choice! Please try again.");
            }
        }
    }
}
