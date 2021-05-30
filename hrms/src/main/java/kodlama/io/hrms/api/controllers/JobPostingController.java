package kodlama.io.hrms.api.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import kodlama.io.hrms.business.abstracts.JobPostingService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosting;

@RestController
@RequestMapping("/api/jobposting")
public class JobPostingController {

	private JobPostingService jobPostingService;

	@Autowired
	public JobPostingController(JobPostingService jobPostingService) {
		super();
		this.jobPostingService = jobPostingService;
	}

	@GetMapping("/getall")
	public DataResult<List<JobPosting>> getAll() {
		return this.jobPostingService.getAll();
	}

	@PostMapping("/add")
	public Result add(@RequestBody JobPosting jobPosting) {
		return this.jobPostingService.add(jobPosting);
	}

	@GetMapping("/getallopenjobpostingbyemployer")
	public DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id) {
		return this.jobPostingService.getAllOpenJobPostingByEmployer(id);
	}

	@GetMapping("/getallorderbypublisheddate")
	public DataResult<List<JobPosting>> getAllOrderByPublishedDateDesc() {
		return this.jobPostingService.getAllOrderByPublishedDateDesc();
	}

	@GetMapping("/getallopenjobposting")
	public DataResult<List<JobPosting>> getAllOpenJobPosting() {
		return this.jobPostingService.getAllOpenJobPosting();
	}

	@PostMapping("/togglevisibility")
	public Result toggleVisibility(int id) {
		return this.jobPostingService.toggleVisibility(id);
		
	}
}
