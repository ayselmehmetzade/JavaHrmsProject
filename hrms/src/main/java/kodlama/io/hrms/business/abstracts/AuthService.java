package kodlama.io.hrms.business.abstracts;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;

public interface AuthService {
	Result registerJobSeeker(JobSeeker jobSeeker, String comfirmPassword);
	Result registerEmployer(Employer employer, String comfirmPassword);
	
}
