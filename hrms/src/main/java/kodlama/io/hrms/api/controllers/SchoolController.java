package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.School;

@RestController
@RequestMapping("/api/schools")
@CrossOrigin
public class SchoolController {
	

	private SchoolService schoolService;

	@Autowired
	public SchoolController(SchoolService schoolService) {
		super();
		this.schoolService = schoolService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody School school){
		return this.schoolService.add(school);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody School school){
		return this.schoolService.update(school);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam int id){
		return this.schoolService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<School> getById(@RequestParam int id){
		return this.schoolService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<School>> getAll(){
		return this.schoolService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerIdOrderByEndAtDesc")
	public DataResult<List<School>> getAllByJobseekerIdOrderByEndAtDesc(@RequestParam int id){
		return this.schoolService.getAllByJobseekerIdOrderByEndAtDesc(id);
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<School>> getAllByJobseekerId(@RequestParam int id){
		return this.schoolService.getAllByJobseekerId(id);
	}

}
