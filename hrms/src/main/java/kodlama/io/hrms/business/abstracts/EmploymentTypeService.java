package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.entities.concretes.EmploymentType;

public interface EmploymentTypeService {

	DataResult<List<EmploymentType>> getAll();
}
