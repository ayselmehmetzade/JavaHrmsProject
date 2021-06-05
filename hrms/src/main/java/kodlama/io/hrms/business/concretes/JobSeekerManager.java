package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ExperienceService;
import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.business.abstracts.ImageService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.abstracts.LinkService;
import kodlama.io.hrms.business.abstracts.SchoolService;
import kodlama.io.hrms.business.abstracts.SkillService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.JobSeekerDao;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.dtos.CVDto;

@Service
public class JobSeekerManager implements JobSeekerService {

	private JobSeekerDao jobSeekerDao;
	private ExperienceService experienceService;
	private ForeignLanguageService foreignLanguageService;
	private ImageService imageService;
	private LinkService linkService;
	private SkillService skillService;
	private SchoolService schoolService;

	public JobSeekerManager(JobSeekerDao jobSeekerDao, ExperienceService experienceService,
			ForeignLanguageService foreignLanguageService, ImageService imageService, LinkService linkService,
			SkillService skillService, SchoolService schoolService) {
		super();
		this.jobSeekerDao = jobSeekerDao;
		this.experienceService = experienceService;
		this.foreignLanguageService = foreignLanguageService;
		this.imageService = imageService;
		this.linkService = linkService;
		this.skillService = skillService;
		this.schoolService = schoolService;
	}

	@Override
	public DataResult<List<JobSeeker>> getAll() {
		return new SuccessDataResult<List<JobSeeker>>(this.jobSeekerDao.findAll(), "Data Listelendi");
	}

	@Override
	public Result add(JobSeeker jobseeker) {
		this.jobSeekerDao.save(jobseeker);
		return new SuccessResult("JobSeeker Added");
	}

	@Override
	public DataResult<JobSeeker> getByNationalId(String nationalId) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.findByNationalId(nationalId));
	}

	@Override
	public Result update(JobSeeker jobseeker) {
		this.jobSeekerDao.save(jobseeker);
		return new SuccessResult("JobSeeker updated");
	}

	@Override
	public Result delete(int id) {
		this.jobSeekerDao.deleteById(id);
		return new SuccessResult("Jobseeker has been deleted.");
	}

	@Override
	public DataResult<JobSeeker> getById(int id) {
		return new SuccessDataResult<JobSeeker>(this.jobSeekerDao.getById(id));

	}

	@Override
	public DataResult<CVDto> getJobseekerCVById(int id) {
		JobSeeker jobSeeker = this.jobSeekerDao.getById(id);
		CVDto cv = new CVDto();
		cv.experiences = jobSeeker.getExperiences();
		cv.languages = jobSeeker.getLanguages();
		cv.image = jobSeeker.getImage();
		cv.links = jobSeeker.getLinks();
		cv.skills = jobSeeker.getSkills();
		cv.schools = jobSeeker.getSchools();
		return new SuccessDataResult<CVDto>(cv);
	}

}
