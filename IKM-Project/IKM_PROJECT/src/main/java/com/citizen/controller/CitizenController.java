package com.citizen.controller;

import java.util.Date;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.citizen.model.CitizenDTO;

@RestController
public class CitizenController {

	@PostMapping("/citizens")
	public ResponseEntity<String> createCitizen(@RequestBody CitizenDTO citizen) {

		if (citizen.getName() == null || citizen.getName().isEmpty()) {
			return ResponseEntity.badRequest().body("Name cannot be empty");
		}
		if (citizen.getAddress() == null || citizen.getAddress().isEmpty()) {
			return ResponseEntity.badRequest().body("Address cannot be empty");
		}
		if (citizen.getDateOfBirth() != null && citizen.getDateOfBirth().after(new Date())) {
			return ResponseEntity.badRequest().body("Date of birth should be a past date");
		}

		return ResponseEntity.status(HttpStatus.CREATED)
				.body("Citizen is saved as the product id : " + citizen.getId());

	}

}
