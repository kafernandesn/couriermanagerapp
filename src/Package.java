import java.util.regex.*;

public abstract class Package {
    protected String trackingID;
    protected String destination;
    protected double weight;

    // Constructor
    public Package(String trackingID, String destination, double weight) {
        if (!validateTrackingID(trackingID)) {
            throw new IllegalArgumentException("Invalid tracking ID format.");
        }
        if (!validateDestination(destination)) {
            throw new IllegalArgumentException("Invalid destination format.");
        }
        if (weight <= 0) {
            throw new IllegalArgumentException("Weight must be a positive number.");
        }

        this.trackingID = trackingID;
        this.destination = destination;
        this.weight = weight;
    }

    // Abstract method to calculate shipping cost
    public abstract double calculateShippingCost();

    // Validate tracking ID using regex
    public static boolean validateTrackingID(String trackingID) {
        return trackingID.matches("PKG\\d{5}");
    }

    // Validate destination using regex
    public static boolean validateDestination(String destination) {
        return destination.matches("\\d+\\s+\\w+(\\s+\\w+)*\\s+(Street|Avenue|Boulevard)");
    }

    @Override
    public String toString() {
        return String.format("TrackingID: %s, Destination: %s, Weight: %.2f", trackingID, destination, weight);
    }
}
