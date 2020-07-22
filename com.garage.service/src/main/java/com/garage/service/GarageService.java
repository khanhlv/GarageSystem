package com.garage.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garage.model.Garage;
import com.garage.service.repository.GarageRepository;

@Service
public class GarageService {

    @Autowired
    private GarageRepository garageRepository;

    public List<Garage> findAll() {
        return garageRepository.findAll();
    }
}
