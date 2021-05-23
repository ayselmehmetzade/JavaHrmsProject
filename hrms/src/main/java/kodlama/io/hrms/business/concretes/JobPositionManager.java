package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPositionService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPositionDao;
import kodlama.io.hrms.entities.concretes.JobPosition;

@Service
public class JobPositionManager implements JobPositionService {

	private JobPositionDao jobPositionDao;

	@Autowired
	public JobPositionManager(JobPositionDao jobPositionDao) {
		this.jobPositionDao = jobPositionDao;
	}

	@Override
	public DataResult<List<JobPosition>> getAll() {
		return new SuccessDataResult<List<JobPosition>>(this.jobPositionDao.findAll(), "Data Listelendi");
	}

	@Override
	public DataResult<JobPosition> getById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result add(JobPosition jobposition) {
		this.jobPositionDao.save(jobposition);
		return new SuccessResult("Ürün eklendi");
	}

	@Override
	public Result delete(JobPosition jobposition) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Result update(JobPosition jobposition) {
		// TODO Auto-generated method stub
		return null;
	}

	

}
