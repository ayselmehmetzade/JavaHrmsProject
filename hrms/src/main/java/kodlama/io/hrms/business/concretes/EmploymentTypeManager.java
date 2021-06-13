package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.EmploymentTypeService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.dataAccess.abstracts.EmploymentTypeDao;
import kodlama.io.hrms.entities.concretes.EmploymentType;

@Service
public class EmploymentTypeManager implements EmploymentTypeService {
	
	@Autowired
	private EmploymentTypeDao employmentTypeDao;

	public EmploymentTypeManager(EmploymentTypeDao employmentTypeDao) {
		super();
		this.employmentTypeDao = employmentTypeDao;
	}

	@Override
	public DataResult<List<EmploymentType>> getAll() {
		return new SuccessDataResult<List<EmploymentType>>(this.employmentTypeDao.findAll());
	}

	

}
