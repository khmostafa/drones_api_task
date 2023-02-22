package com.example.demo.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.example.demo.entities.Drone;
import com.example.demo.entities.MedicalItem;
import com.example.demo.entities.values.State;
import com.example.demo.repositories.DroneRepository;

@Service
public class DroneService {
	
	@Autowired
	private DroneRepository droneRepository;
			
	public Drone addDrone(Drone drone){
		return droneRepository.save(drone);
	}
	
	public ResponseEntity<?> delete(String serialNo) {
		Drone drone = droneRepository.findBySerialNo(serialNo);
		droneRepository.delete(drone);
		return ResponseEntity.ok("Delete Success");
	}
	
	public List<Drone> allDrone(){
		return droneRepository.findAll();
	}
	
	public ResponseEntity<?> upLoad(String serialNo, List<MedicalItem> medics){
		Drone drone = droneRepository.findBySerialNo(serialNo);
		
		if (!drone.getState().equals(State.LOADING)) {
			return ResponseEntity.ok("Drone Not Ready");
		}else if(drone.getState().equals(State.LOADING) && drone.getBatteryCharging() < 25){
			drone.setLoad(null);
			drone.setState(State.IDLE);
			return ResponseEntity.ok(droneRepository.save(drone));	
		}
		
		Double sum = 0.0;
		for (MedicalItem medic : medics) {
			 sum += medic.getWeight();
		}
		
		if (sum > drone.getCarriedLoad()) {
			return ResponseEntity.ok("Load Exceed Drone Maximum Capacity");
		}else {
			drone.setLoad(medics);
			drone.setState(State.LOADED);
			return ResponseEntity.ok(droneRepository.save(drone));	
		}
		
	}
	
	public List<MedicalItem> getLoad(String serialNo){
		Drone drone = droneRepository.findBySerialNo(serialNo);
		return drone.getLoad();
	}
	
	public List<Drone> getAvailableDrones(){
		return droneRepository.findByState(State.LOADING);
	}
	
	public Double getBattery(String serialNo){
		Drone drone = droneRepository.findBySerialNo(serialNo);
		return drone.getBatteryCharging();
	}
}
