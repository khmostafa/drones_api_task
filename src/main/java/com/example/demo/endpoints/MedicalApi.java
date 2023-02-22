package com.example.demo.endpoints;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.demo.entities.MedicalItem;
import com.example.demo.services.MedicalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/medical")
public class MedicalApi {
	
	@Autowired
	private MedicalService medicalService;
	
	@PostMapping("/add")
	public MedicalItem add(@Valid @RequestBody MedicalItem medic) {
		return medicalService.add(medic);
	}
	
	@GetMapping("/all")
	public List<MedicalItem> allDrone() {  
		return medicalService.all();
	}
	
	@DeleteMapping("/delete/{name}")
	public ResponseEntity<?> delete(String name) {  
		return medicalService.delete(name);
	}
}
