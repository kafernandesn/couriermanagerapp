import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        CourierManager manager = new CourierManager();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to Delivery Dilemmas!");

        // Add sample packages
        manager.addPackage(new StandardPackage("PKG12345", "123 Elm Street", 10.5));
        manager.addPackage(new ExpressPackage("PKG67890", "456 Oak Avenue", 7.2));

        System.out.println("\nDisplaying all packages:");
        manager.displayPackages();

        System.out.println("\nSorting packages by weight...");
        manager.sortPackagesByWeight();
        System.out.println("Packages after sorting:");
        manager.displayPackages();

        System.out.println("\nEnter tracking ID to search: ");
        String searchID = scanner.nextLine();

        Package foundPackage = manager.searchPackageByTrackingID(searchID);
        if (foundPackage != null) {
            System.out.println("Package found: " + foundPackage);
        } else {
            System.out.println("Package not found!");
        }

        scanner.close();
    }
}
