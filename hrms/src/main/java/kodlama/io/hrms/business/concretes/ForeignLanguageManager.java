package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.ForeignLanguageService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.ForeignLanguageDao;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;

@Service
public class ForeignLanguageManager implements ForeignLanguageService{
	
	private ForeignLanguageDao foreignLanguageDao;

	@Autowired
	public ForeignLanguageManager(ForeignLanguageDao foreignLanguageDao) {
		super();
		this.foreignLanguageDao = foreignLanguageDao;
	}


	@Override
	public Result add(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(ForeignLanguage foreignLanguage) {
		this.foreignLanguageDao.save(foreignLanguage);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(int id) {
		this.foreignLanguageDao.deleteById(id);;
		return new SuccessResult("Silme işlemi başarılı.");
	}

	@Override
	public DataResult<ForeignLanguage> getById(int id) {
		return new SuccessDataResult<ForeignLanguage>(this.foreignLanguageDao.getById(id));
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAll() {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.findAll());
	}

	@Override
	public DataResult<List<ForeignLanguage>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<ForeignLanguage>>(this.foreignLanguageDao.getAllByJobseeker_id(id));
	}


}
