package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.School;

public interface SchoolService {

	Result add(School school);

	Result update(School school);

	Result delete(int id);

	DataResult<School> getById(int id);

	DataResult<List<School>> getAll();

	DataResult<List<School>> getAllByJobseekerIdOrderByEndAtDesc(int id);

	DataResult<List<School>> getAllByJobseekerId(int id);
}
