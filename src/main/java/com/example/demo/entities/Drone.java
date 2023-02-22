package com.example.demo.entities;

import java.util.List;
import com.example.demo.entities.values.Model;
import com.example.demo.entities.values.State;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Drone {
	@Id
	@NotEmpty
	@Size(max = 100, message = "SerialNo must not exceed 100 chars")
	private String serialNo;
	
	@NotNull(message = "Model is mandatory")
	private Model model;
	
	@Positive(message = "Not logical value for carriedLoad")
	@Max(value = 500, message = "CarriedLoad must not exceed 500 grms")
	private Double carriedLoad;
	
	@Positive(message = "Not logical value for BatteryCharging")
	@Max(value = 100, message = "Not logical value for BatteryCharging")
	private Double batteryCharging;
	
	@NotNull(message = "State is mandatory")
	private State state;
	
	@OneToMany
	private List<MedicalItem> load;
}
