package kodlama.io.hrms.business.concretes;

import java.time.LocalDate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.AuthService;
import kodlama.io.hrms.business.abstracts.EmployerService;
import kodlama.io.hrms.business.abstracts.JobSeekerService;
import kodlama.io.hrms.business.abstracts.UserService;
import kodlama.io.hrms.business.abstracts.VerificationCodeService;
import kodlama.io.hrms.core.utilities.adapters.ValidationService;
import kodlama.io.hrms.core.utilities.results.ErrorResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.core.utilities.verification.VerificationService;
import kodlama.io.hrms.entities.concretes.Employer;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.VerificationCode;


@Service
public class AuthManager implements AuthService {

	private UserService userService;
	private EmployerService employerService;
	private JobSeekerService jobSeekerService;
	private VerificationCodeService verificationCodeService;
	private VerificationService verificationService;
	private ValidationService validationService;

	@Autowired
	public AuthManager(UserService userService, EmployerService employerService, JobSeekerService jobSeekerService,
			VerificationCodeService verificationCodeService, VerificationService verificationService,
			ValidationService validationService) {
		super();
		this.userService = userService;
		this.employerService = employerService;
		this.jobSeekerService = jobSeekerService;
		this.verificationCodeService = verificationCodeService;
		this.verificationService = verificationService;
		this.validationService = validationService;
	}

	@Override
	public Result registerJobSeeker(JobSeeker jobSeeker, String comfirmPassword) {
		if (checkIfPerson(Long.parseLong(jobSeeker.getNationalId()), jobSeeker.getFirstName(), jobSeeker.getLastName(),
				jobSeeker.getDateOfBirth().getYear()) == false) {
			return new ErrorResult("TCKN Doğrulanamadı");
		}
		if (!checkIfNullInfoForJobseeker(jobSeeker, comfirmPassword)) {
			return new ErrorResult("Yanlış bilgi girdiniz. Lütfen bilgilerinizi kontrol ederek tekrar deneyiniz");
		}
		if (!checkIfTcNo(jobSeeker.getNationalId())) {
			return new ErrorResult("Kullanıcı mavcut : " + jobSeeker.getNationalId());
		}
		if (!checkIfEmail(jobSeeker.getEmail())) {
			return new ErrorResult("Email mevcut : " + jobSeeker.getEmail());
		}

		jobSeekerService.add(jobSeeker);
		String code = verificationService.sendCode();
		verificationCode(code, jobSeeker.getEmail(), jobSeeker.getId());
		return new SuccessResult("Kayıt Başarıyla Gerçekleşti");

	}

	@Override
	public Result registerEmployer(Employer employer, String comfirmPassword) {
		if (!checkIfNullInfoForEmployer(employer)) {
			return new ErrorResult("Yanlış bilgi girdiniz. Lütfen bilgilerinizi kontrol ederek tekrar deneyiniz");
		}
		if(!checkIfEmailAndDomain(employer.getEmail(), employer.getWebSite())) {
			return new ErrorResult("Email adresi geçersiz!");			
		}
		if(!checkIfEmail(employer.getEmail())) {
			return new ErrorResult("Email mevcut : " + employer.getEmail());
		}
		if(!checkIfPassword(employer.getPassword(), comfirmPassword)) {
			return new ErrorResult("Parola hatası. Lütfen tekrar deneyin.");		
		}
		
		employerService.add(employer);
		String code = verificationService.sendCode();
		verificationCode(code, employer.getEmail(), employer.getId());
		return new SuccessResult("Kayıt Başarıyla Gerçekleşti");
	}

	private boolean checkIfNullInfoForEmployer(Employer employer) {
		if (employer.getCompanyName() != null && employer.getWebSite() != null && employer.getEmail() != null
				&& employer.getPhoneNumber() != null && employer.getPassword() != null) {

			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfEmailAndDomain(String email, String webSite) {
		String[] emaiStrings = email.split("@", 2);
		String domain = webSite.substring(4, webSite.length());

		if (emaiStrings[1].equals(domain)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfNullInfoForJobseeker(JobSeeker jobSeeker, String confirmPassword) {
		if (jobSeeker.getFirstName() != null && jobSeeker.getLastName() != null && jobSeeker.getNationalId() != null
				&& jobSeeker.getDateOfBirth() != null && jobSeeker.getPassword() != null && jobSeeker.getEmail() != null
				&& confirmPassword != null) {

			return true;

		}

		return false;
	}

	private boolean checkIfTcNo(String nationalId) {
		if (jobSeekerService.getByNationalId(nationalId).getData() == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfPerson(long nationalId, String firstName, String lastName, int birthDate) {
		if (validationService.userValidate(nationalId, firstName, lastName, birthDate)) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfEmail(String email) {
		if (this.userService.getByEmail(email).getData() == null) {
			return true;
		} else {
			return false;
		}
	}

	private boolean checkIfPassword(String password, String confirmPassword) {
		if (!password.equals(confirmPassword)) {
			return false;
		} else {
			return true;
		}
	}

	private void verificationCode(String code, String email, int id) {
		VerificationCode verificationCode = new VerificationCode(id, code, false, LocalDate.now());
		this.verificationCodeService.add(verificationCode);
		System.out.println("Doğrulama kodu gönderildi: " + email);
	}

}
