package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.CoverLetterService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CoverLetter;

@RestController
@RequestMapping("/api/coverletters")
public class CoverLetteController {

	private CoverLetterService coverLetterService;

	@Autowired
	public CoverLetteController(CoverLetterService coverLetterService) {
		super();
		this.coverLetterService = coverLetterService;
	}

	@PostMapping("/add")
	public Result add(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.add(coverLetter);
	}

	@PostMapping("/update")
	public Result update(@RequestBody CoverLetter coverLetter) {
		return this.coverLetterService.update(coverLetter);
	}

	@PostMapping("/delete")
	public Result delete(@RequestParam("id") int id) {
		return this.coverLetterService.delete(id);
	}

	@GetMapping("/getbyid")
	public DataResult<CoverLetter> getById(@RequestParam("id") int id) {
		return this.coverLetterService.getById(id);
	}

	@GetMapping("/getall")
	public DataResult<List<CoverLetter>> getAll() {
		return this.coverLetterService.getAll();
	}
}
