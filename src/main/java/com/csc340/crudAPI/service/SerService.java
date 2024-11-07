package com.csc340.crudAPI.service;
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
        return serviceRepository.findById(serviceId);
    }

    public Ser createService(Ser service) {
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
}
