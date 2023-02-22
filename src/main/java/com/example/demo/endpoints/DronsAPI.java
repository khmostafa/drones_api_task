package com.example.demo.endpoints;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.Drone;
import com.example.demo.entities.MedicalItem;
import com.example.demo.services.DroneService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/drones")
public class DronsAPI {
	
	@Autowired
	private DroneService droneService;
	
	@PostMapping("/add")
	public Drone addDrone(@Valid @RequestBody Drone drone) {
		return droneService.addDrone(drone);
	}
	
	@GetMapping("/all")
	public List<Drone> allDrone() {  
		return droneService.allDrone();
	}
	
	@DeleteMapping("/delete/{serialNo}")
	public ResponseEntity<?> delete(String serialNo) {  
		return droneService.delete(serialNo);
	}
	
	@GetMapping("/all-available")
	public List<Drone> allAvailable() {
		return droneService.getAvailableDrones();
	}
	
	@PostMapping("/upload-medic/{serialNo}")
	public ResponseEntity<?> upload(@PathVariable String serialNo, @RequestBody List<MedicalItem> medics) {
		return droneService.upLoad(serialNo, medics);
	}
	
	@GetMapping("/check-load/{serialNo}")
	public List<MedicalItem> getload(@PathVariable String serialNo) {
		return droneService.getLoad(serialNo);
	}
	
	@GetMapping("/check-battery/{serialNo}")
	public Double getBattery(@PathVariable String serialNo) {
		return droneService.getBattery(serialNo);
	}
}
