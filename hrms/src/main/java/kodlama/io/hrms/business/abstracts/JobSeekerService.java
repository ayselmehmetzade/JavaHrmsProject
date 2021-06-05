package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.dtos.CVDto;

public interface JobSeekerService {

	DataResult<List<JobSeeker>> getAll();

	Result add(JobSeeker jobseeker);

	Result update(JobSeeker jobseeker);

	Result delete(int id);

	DataResult<JobSeeker> getByNationalId(String nationalId);

	DataResult<JobSeeker> getById(int id);

	DataResult<CVDto> getJobseekerCVById(int id);

}
