package customer;

public class Review {
    private String serviceName;
    private String feedback;
    private int rating;

    public Review(String serviceName, String feedback, int rating) {
        this.serviceName = serviceName;
        this.feedback = feedback;
        this.rating = rating;
    }

    public String getServiceName() {
        return serviceName;
    }

    public String getFeedback() {
        return feedback;
    }

    public int getRating() {
        return rating;
    }
}