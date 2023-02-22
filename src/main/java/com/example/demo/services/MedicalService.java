package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.demo.entities.MedicalItem;
import com.example.demo.repositories.MedicalRepository;

@Service
public class MedicalService {
	
	@Autowired
	private MedicalRepository medicalRepository;
	
	public MedicalItem add(MedicalItem medic) {
		return medicalRepository.save(medic);
	}
	
	public ResponseEntity<?> delete(String name) {
		MedicalItem medic = medicalRepository.findByName(name);
		medicalRepository.delete(medic);
		return ResponseEntity.ok("Delete Success");
	}
	
	public List<MedicalItem> all(){
		return medicalRepository.findAll();
	}
}
