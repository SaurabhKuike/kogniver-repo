package com.spring.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.spring.entity.Vehicle;

/**
 * Vehicle Repository
 */
@Repository
public interface VehicleRepository extends JpaRepository<Vehicle, Integer> {

}
