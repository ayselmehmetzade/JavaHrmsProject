package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.JobPosition;

public interface JobPositionService {

	DataResult<List<JobPosition>> getAll();
	Result add(JobPosition jobposition);
	DataResult<JobPosition> getJobByName(String title);

//	DataResult<JobPosition> getById(int id);
//
//	Result delete(JobPosition jobposition);
//
//	Result update(JobPosition jobposition);
}
