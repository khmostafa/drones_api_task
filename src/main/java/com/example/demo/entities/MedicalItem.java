package com.example.demo.entities;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class MedicalItem {
	@Id
	@NotEmpty
    @Pattern(regexp = "^[a-zA-Z0-9_-]*$")
	private String name;
	
	@Positive
	private Double weight;
	
	@NotEmpty
    @Pattern(regexp = "^[A-Z0-9_]*$")
	private String code;
	
	@NotNull
	@NotEmpty
	private String image;
}
