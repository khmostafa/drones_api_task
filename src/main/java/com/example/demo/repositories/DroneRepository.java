package com.example.demo.repositories;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entities.Drone;
import com.example.demo.entities.values.State;

public interface DroneRepository extends JpaRepository<Drone, Integer>{
	List<Drone> findByState(State state);
	Drone findBySerialNo(String serialNo);
}
