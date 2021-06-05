package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.CoverLetter;

public interface CoverLetterService {

	Result add(CoverLetter coverLetter);

	Result update(CoverLetter coverLetter);

	Result delete(int id);

	DataResult<CoverLetter> getById(int id);

	DataResult<List<CoverLetter>> getAll();

}
