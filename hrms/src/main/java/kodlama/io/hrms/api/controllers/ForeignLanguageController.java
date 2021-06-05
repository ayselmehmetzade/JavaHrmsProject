package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;

@RestController
@RequestMapping("/api/foreignlanguages")
public class ForeignLanguageController {
	private ForeignLanguageService foreignLanguageService;

	@Autowired
	public ForeignLanguageController(ForeignLanguageService foreignLanguageService) {
		super();
		this.foreignLanguageService = foreignLanguageService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody ForeignLanguage foreignLanguage){
		return this.foreignLanguageService.add(foreignLanguage);
	}
	
	@PostMapping("/update")
	public Result update(@RequestBody ForeignLanguage foreignLanguage){
		return this.foreignLanguageService.update(foreignLanguage);
	}
	
	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id){
		return this.foreignLanguageService.delete(id);
	}
	
	@GetMapping("/getbyid")
	public DataResult<ForeignLanguage> getById(@RequestParam("id") int id){
		return this.foreignLanguageService.getById(id);
	}
	
	@GetMapping("/getall")
	public DataResult<List<ForeignLanguage>> getAll(){
		return this.foreignLanguageService.getAll();
	}
	
	@GetMapping("/getAllByJobseekerId")
	public DataResult<List<ForeignLanguage>> getAllByJobseekerId(@RequestParam int id){
		return this.foreignLanguageService.getAllByJobseekerId(id);
	}

}
