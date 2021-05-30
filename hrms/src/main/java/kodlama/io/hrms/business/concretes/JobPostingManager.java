package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.JobPostingService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobPostingDao;
import kodlama.io.hrms.entities.concretes.JobPosting;

@Service
public class JobPostingManager implements JobPostingService {

	@Autowired
	private JobPostingDao jobPostingDao;

	public JobPostingManager(JobPostingDao jobPostingDao) {
		super();
		this.jobPostingDao = jobPostingDao;
	}

	@Override
	public Result add(JobPosting jobPosting) {
		if (!CheckIfNull(jobPosting)) {
			return new ErrorResult("Eksik bilgi girdiniz.");
		}
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("iş ilanı eklendi");
	}

	@Override
	public Result delete(int id) {
		this.jobPostingDao.deleteById(id);
		return new SuccessResult("İş ilanı silindi");
	}

	@Override
	public Result update(JobPosting jobPosting) {
		this.jobPostingDao.save(jobPosting);
		return new SuccessResult("iş ilanı güncellendi");
	}

	@Override
	public DataResult<List<JobPosting>> getAll() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.findAll());
	}

	@Override
	public DataResult<JobPosting> getById(int id) {
		return new SuccessDataResult<JobPosting>(this.jobPostingDao.findById(id).orElse(null)); //fatihe sor
	}

	@Override
	public DataResult<List<JobPosting>> getAllOpenJobPosting() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobPosting());
	}

	@Override
	public DataResult<List<JobPosting>> getAllOrderByPublishedDateDesc() {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOrderByPublishedDateDesc());
	}

	@Override
	public DataResult<List<JobPosting>> getAllOpenJobPostingByEmployer(int id) {
		return new SuccessDataResult<List<JobPosting>>(this.jobPostingDao.getAllOpenJobPostingByEmployer(id));
	}

	private boolean CheckIfNull(JobPosting jobPosting) {
		if (jobPosting.getJobPosition() != null && jobPosting.getDescription() != null && jobPosting.getCity() != null
				&& jobPosting.getOpenPositionQuota() != 0) {
			return true;
		} else {
			return false;
		}
	}

	@Override
	public Result toggleVisibility(int id) {
		
		JobPosting jobPosting = getById(id).getData();
		
		if (jobPosting == null) {
			return new ErrorResult("Böyle bir iş ilanı bulunmamaktadır");
		}
		if (jobPosting.isOpen() == false) {
			return new ErrorResult("İş ilanı zaten kapalı");
		}		
		jobPosting.setOpen(false);
		update(jobPosting);
		return new SuccessResult("İş ilanı kapatılmıştır");
	}

}
