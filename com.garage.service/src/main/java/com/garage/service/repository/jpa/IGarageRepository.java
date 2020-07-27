package com.garage.service.repository.jpa;

import org.springframework.data.repository.CrudRepository;

import com.garage.model.Garage;

public interface IGarageRepository extends CrudRepository<Garage, Long> {

}
