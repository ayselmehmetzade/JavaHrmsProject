package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Experience;

public interface ExperienceService {
	Result add(Experience experience);

	Result update(Experience experience);

	Result delete(int id);

	DataResult<Experience> getById(int id);

	DataResult<List<Experience>> getAll();

	DataResult<List<Experience>> getAllByJobseekerIdOrderByEndAtDesc(int id);

	DataResult<List<Experience>> getAllByJobseekerId(int id);

}
