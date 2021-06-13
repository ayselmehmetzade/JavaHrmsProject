package kodlama.io.hrms.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin
public class AuthController {

	private AuthService authService;

	@Autowired
	public AuthController(AuthService authService) {

		this.authService = authService;
	};

	@PostMapping("/registerjobseeker")
	private Result registerJobseeker(@RequestBody JobSeeker jobSeeker, String confirmPassword) {
		return this.authService.registerJobSeeker(jobSeeker, confirmPassword);
	}

	@PostMapping("/registeremployer")
	private Result registerEmployer(@RequestBody Employer employer, String confirmpassword) {
		return this.authService.registerEmployer(employer, confirmpassword);
	}

}
