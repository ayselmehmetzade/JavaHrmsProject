package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.entities.concretes.Link;

public interface LinkService {

	Result add(Link link);

	Result update(Link link);

	Result delete(int id);

	DataResult<Link> getById(int id);

	DataResult<List<Link>> getAll();

	DataResult<List<Link>> getAllByJobseekerId(int id);

}
