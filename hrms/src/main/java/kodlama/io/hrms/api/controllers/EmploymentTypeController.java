package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.EmploymentTypeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.City;
import kodlama.io.hrms.entities.concretes.EmploymentType;

@RestController
@RequestMapping("/api/employmenttype")
@CrossOrigin
public class EmploymentTypeController {
	

	private EmploymentTypeService employmentTypeService;

	@Autowired
	public EmploymentTypeController(EmploymentTypeService employmentTypeService) {
		super();
		this.employmentTypeService = employmentTypeService;
	}
	
	@GetMapping("/getall")
	public DataResult<List<EmploymentType>> getAll() {
		return this.employmentTypeService.getAll();
	}

}
