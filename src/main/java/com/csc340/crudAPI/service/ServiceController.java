package com.csc340.crudAPI.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/services")
public class ServiceController {
    @Autowired
    private SerService serviceService;

     //Get all services
    @GetMapping("/all")
    public String getAllServices(Model model) {
        model.addAttribute("serviceList", serviceService.getAllServices());
        return "admin-management";
    }

    @PostMapping("/delete/{serviceId}")
    public String deleteService(@PathVariable Long serviceId) {
        serviceService.deleteService((long) serviceId);
        return "redirect:/users/all";
    }
    @PostMapping("/undelete/{serviceId}")
    public String undeleteService(@PathVariable Long serviceId) {
        serviceService.undeleteService((long) serviceId);
        return "redirect:/users/all";
    }


    // Get service by ID
    @GetMapping("/{serviceId}")
    public String getServiceById(@PathVariable int serviceId, Model model) {
        serviceService.getServiceById(serviceId).ifPresent(service -> model.addAttribute("service", service));
        return "service-detail";
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



}