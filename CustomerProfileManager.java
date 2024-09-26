package customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfileManager {
    public static void main(String[] args) {
        // Create a new customer profile
        CustomerProfile customer = new CustomerProfile("John Doe", "john.doe@example.com", "Looking for home cleaning services");

        // Display customer profile
        customer.displayProfile();

        // Create a list of available services
        List<ServiceProvider> services = new ArrayList<>();
        services.add(new ServiceProvider("Home Cleaning", "CleanCo", "Professional home cleaning services"));
        services.add(new ServiceProvider("Tutoring", "TutorPro", "Expert tutoring in various subjects"));
        services.add(new ServiceProvider("Plumbing", "PlumbFix", "Reliable plumbing services"));

        // Display available services
        System.out.println("\nAvailable Services:");
        for (ServiceProvider service : services) {
            service.displayServiceInfo();
        }

        // Customer subscribes to services
        customer.subscribeToService(services.get(0)); // Subscribing to the first service (Home Cleaning)
        customer.subscribeToService(services.get(1)); // Subscribing to the second service (Tutoring)

        // Display subscribed services
        customer.displaySubscribedServices();

        // Customer writes a review for the first service
        customer.writeReview("Home Cleaning", "Excellent service, very professional!", 5);

        // Display all reviews
        customer.displayReviews();
    }
}