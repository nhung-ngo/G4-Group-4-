package customer;

public class ServiceProvider {
    private String serviceName;
    private String providerName;
    private String description;

    public ServiceProvider(String serviceName, String providerName, String description) {
        this.serviceName = serviceName;
        this.providerName = providerName;
        this.description = description;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void displayServiceInfo() {
        System.out.println("Service: " + serviceName);
        System.out.println("Provider: " + providerName);
        System.out.println("Description: " + description);
    }
}