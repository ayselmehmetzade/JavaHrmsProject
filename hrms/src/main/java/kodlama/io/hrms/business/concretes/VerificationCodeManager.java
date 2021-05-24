package kodlama.io.hrms.business.concretes;

import kodlama.io.hrms.business.abstracts.VerificationCodeService;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.VerificationCodeDao;
import kodlama.io.hrms.entities.concretes.VerificationCode;

public class VerificationCodeManager implements VerificationCodeService{
	
	private VerificationCodeDao verificationCodeDao;

	public VerificationCodeManager(VerificationCodeDao verificationCodeDao) {
		super();
		this.verificationCodeDao = verificationCodeDao;
	}

	@Override
	public Result add(VerificationCode verificationCode) {
		this.verificationCodeDao.save(verificationCode);		
		return new SuccessResult("İşlem başarılı bir şekilde kaydedildi");
	}

}
