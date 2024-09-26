package customer;

import java.util.ArrayList;
import java.util.List;

public class CustomerProfile {
    private String name;
    private String email;
    private String preferences;
    private List<ServiceProvider> subscribedServices;
    private List<Review> reviews;

    public CustomerProfile(String name, String email, String preferences) {
        this.name = name;
        this.email = email;
        this.preferences = preferences;
        this.subscribedServices = new ArrayList<>();
        this.reviews = new ArrayList<>();
    }

    public void displayProfile() {
        System.out.println("Customer Name: " + name);
        System.out.println("Email: " + email);
        System.out.println("Preferences: " + preferences);
    }

    public void subscribeToService(ServiceProvider service) {
        subscribedServices.add(service);
        System.out.println("Subscribed to: " + service.getServiceName());
    }

    public void displaySubscribedServices() {
        System.out.println("\nSubscribed Services:");
        for (ServiceProvider service : subscribedServices) {
            System.out.println(service.getServiceName());
        }
    }

    public void writeReview(String serviceName, String feedback, int rating) {
        Review review = new Review(serviceName, feedback, rating);
        reviews.add(review);
        System.out.println("Review written for " + serviceName);
    }

    public void displayReviews() {
        System.out.println("\nCustomer Reviews:");
        for (Review review : reviews) {
            System.out.println(review.getServiceName() + " - " + review.getFeedback() + " (Rating: " + review.getRating() + ")");
        }
    }
}