package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.JobPosition;


public interface JobPositionService {
	
	List<JobPosition> getAll();

	JobPosition getById(int id);

	void add(JobPosition jobposition);

	void delete(JobPosition jobposition);

	void update(JobPosition jobposition);
}
