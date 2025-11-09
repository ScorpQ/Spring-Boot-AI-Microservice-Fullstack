package userservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.validation.Valid;
import userservice.dto.RegisterRequest;
import userservice.dto.UserResponse;
import userservice.servies.UserService;

@RestController
@RequestMapping("/api/users")
public class UserController {
	 

	// Bu service tamamen bitmedi,
	// Yapılacak işlemler: Error handling(Hata varsa postman'de gözükmeli),
	// Postman Collection oluşturulmalı,
	// Redis ile cacheleme yapılmalı,

	@Autowired
	private UserService userService;

	@GetMapping("/{userId}")
	public ResponseEntity<UserResponse> getUserProfileById(@Valid @PathVariable String userId) {
		return ResponseEntity.ok(userService.getUserProfileById(userId));
	}

	@PostMapping("/register")
	public ResponseEntity<UserResponse> registerUser(@Valid @RequestBody RegisterRequest user) {
		return ResponseEntity.ok(userService.register(user));
	}

}