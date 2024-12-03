import java.util.ArrayList;
import java.util.Collections;

public class CourierManager {
    private ArrayList<Package> packages;

    public CourierManager() {
        packages = new ArrayList<>();
    }

    // Add a package to the collection
    public void addPackage(Package pkg) {
        packages.add(pkg);
    }

    // Display all packages
    public void displayPackages() {
        for (Package pkg : packages) {
            System.out.println(pkg + ", Shipping Cost: " + pkg.calculateShippingCost());
        }
    }

    // Bubble Sort packages by weight
    public void sortPackagesByWeight() {
        int n = packages.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (packages.get(j).weight > packages.get(j + 1).weight) {
                    Collections.swap(packages, j, j + 1);
                }
            }
        }
    }

    // Binary Search for a package by tracking ID
    public Package searchPackageByTrackingID(String trackingID) {
        int low = 0;
        int high = packages.size() - 1;

        while (low <= high) {
            int mid = (low + high) / 2;
            Package midPackage = packages.get(mid);

            int comparison = midPackage.trackingID.compareTo(trackingID);
            if (comparison == 0) {
                return midPackage;
            } else if (comparison < 0) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }
        return null;
    }
}
