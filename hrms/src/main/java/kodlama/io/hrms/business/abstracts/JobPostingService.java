package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosting;

public interface JobPostingService {
	Result add(JobPosting jobPosting);
	Result update(JobPosting jobPosting);
	Result delete(int id);
	DataResult<List<JobPosting>> getAll();
	DataResult<JobPosting> getById(int id);
	DataResult<List<JobPosting>> getAllOpenJobPosting();
	DataResult<List<JobPosting>> getAllOrderByPublishedDateDesc();
	DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id);
	Result toggleVisibility(int id);

}
