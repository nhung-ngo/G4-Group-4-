package com.csc340.crudAPI.service;
import com.csc340.crudAPI.user.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SerService {
    @Autowired
    private ServiceRepository serviceRepository;

    public List<Ser> getAllServices() {
        return serviceRepository.findAll();
    }

    public Optional<Ser> getServiceById(int serviceId) {
        return serviceRepository.findById((long) serviceId);
    }

    public Ser createService(Ser service) {
        return serviceRepository.save(service);
    }

    public Ser updateService(int serviceId, Ser serviceDetails) {
        return serviceRepository.findById((long) serviceId).map(service -> {
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
    public void save(Ser service) {
        serviceRepository.save(service);
    }


    public void deleteService(Long serviceId) {
        Ser service = serviceRepository.findById((long) serviceId).orElseThrow();
        service.setStatus("deleted");
        serviceRepository.save(service);
    }

    public void undeleteService(Long serviceId) {
        Ser service = serviceRepository.findById((long) serviceId).orElseThrow();
        service.setStatus("available");
        serviceRepository.save(service);
    }
}
