package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Skill;

public interface SkillService {

	Result add(Skill skill);

	Result update(Skill skill);

	Result delete(int id);

	DataResult<Skill> getById(int id);

	DataResult<List<Skill>> getAll();

	DataResult<List<Skill>> getAllByJobseekerId(int id);
}
