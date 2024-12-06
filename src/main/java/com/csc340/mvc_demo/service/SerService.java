package com.csc340.mvc_demo.service;
import com.csc340.mvc_demo.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class SerService {


    @Autowired
    private ServiceRepository serviceRepository;

    public List<Ser> getAllServices() {
        return serviceRepository.findAll();
    }

    public List<Ser> getServicesByUserId(int userId) {
       return serviceRepository.findByUserId(userId);
    }

    public Ser getServiceById(int serviceId) {
        return serviceRepository.findById(serviceId).orElse(null);
    }

    public Ser createService(Ser service, User user) {
        service = new Ser(user, service.getTitle(), service.getImagePath(), service.getPrice(),
                service.getDescription(), service.getLocation(), service.getCategory(), service.getStatus());
        return serviceRepository.save(service);
    }

    public Ser updateService(int serviceId, Ser serviceDetails) {
        return serviceRepository.findById(serviceId).map(service -> {
            service.setUser(serviceDetails.getUser());
            service.setTitle(serviceDetails.getTitle());
            service.setImagePath(serviceDetails.getImagePath());
            service.setPrice(serviceDetails.getPrice());
            service.setDescription(serviceDetails.getDescription());
            service.setLocation(serviceDetails.getLocation());
            service.setCategory(serviceDetails.getCategory());
            service.setStatus(serviceDetails.getStatus());
            return serviceRepository.save(service);
        }).orElseThrow(() -> new RuntimeException("Service not found with id " + serviceId));
    }

    public void deleteService(int serviceId) {

        serviceRepository.deleteById(serviceId);
    }

    public void deleteServiceForAdmin(int serviceId) {
        Ser service = serviceRepository.findById( serviceId).orElseThrow();
        service.setStatus("deleted");
        serviceRepository.save(service);
    }

    public void undeleteServiceForAdmin(int serviceId) {
        Ser service = serviceRepository.findById( serviceId).orElseThrow();
        service.setStatus("available");
        serviceRepository.save(service);
    }
}
