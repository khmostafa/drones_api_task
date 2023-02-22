package com.example.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entities.MedicalItem;

public interface MedicalRepository extends JpaRepository<MedicalItem, Integer>{
	MedicalItem findByName(String name);
}
