package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface JobSeekerService {

	List<JobSeeker> getAll();

	JobSeeker getById(int id);

	void add(JobSeeker jobseeker);

	void delete(JobSeeker jobseeker);

	void update(JobSeeker jobseeker);
}
