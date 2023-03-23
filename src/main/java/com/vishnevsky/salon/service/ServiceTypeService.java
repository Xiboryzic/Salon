package com.vishnevsky.salon.service;

import com.vishnevsky.salon.model.ServiceType;
import com.vishnevsky.salon.repository.ServiceTypeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeService {
    @Autowired
    private ServiceTypeRepo serviceTypeRepo;

    public List<ServiceType> findAllServiceTypes(Integer rang){
        List<ServiceType> serviceTypes;

        if(rang != 1) {
            return serviceTypeRepo.findByRang(rang);
        } else return serviceTypeRepo.findAll();
    }

    public void saveServiceType(ServiceType serviceType){
        serviceTypeRepo.save(serviceType);
    }

    public void deleteServiceTypeById(ServiceType serviceType){
        serviceTypeRepo.deleteById(serviceType.getId());
    }


}
