package com.csc340.crudAPI.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private SerService serviceService;

    // Get all services
    @GetMapping("/all")
    public List<Ser> getAllServices() {
        return serviceService.getAllServices();
    }

    // Get service by ID
    @GetMapping("/{serviceId}")
    public Optional<Ser> getServiceById(@PathVariable int serviceId) {
        return serviceService.getServiceById(serviceId);
    }

    // Create new service
    @PostMapping
    public Ser createService(@RequestBody Ser service) {
        return serviceService.createService(service);
    }

    // Update service
    @PutMapping("/{serviceId}")
    public Ser updateService(@PathVariable int serviceId, @RequestBody Ser serviceDetails) {
        return serviceService.updateService(serviceId, serviceDetails);
    }

    // Delete service
    @DeleteMapping("/{serviceId}")
    public List<Ser> deleteService(@PathVariable int serviceId) {

        serviceService.deleteService(serviceId);
        return serviceService.getAllServices();
    }
}