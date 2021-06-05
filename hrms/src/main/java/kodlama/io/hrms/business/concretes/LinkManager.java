package kodlama.io.hrms.business.concretes;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kodlama.io.hrms.business.abstracts.LinkService;
import kodlama.io.hrms.core.utilities.results.DataResult;
import kodlama.io.hrms.core.utilities.results.Result;
import kodlama.io.hrms.core.utilities.results.SuccessDataResult;
import kodlama.io.hrms.core.utilities.results.SuccessResult;
import kodlama.io.hrms.dataAccess.abstracts.LinkDao;
import kodlama.io.hrms.entities.concretes.Link;

@Service
public class LinkManager implements LinkService{

	private LinkDao linkDao;
	
	@Autowired
	public LinkManager(LinkDao linkDao) {
		super();
		this.linkDao = linkDao;
	}

	@Override
	public Result add(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Ekleme işlemi başarılı");
	}

	@Override
	public Result update(Link link) {
		this.linkDao.save(link);
		return new SuccessResult("Güncelleme işlemi başarılı");
	}

	@Override
	public Result delete(int id) {
		this.linkDao.deleteById(id);
		return new SuccessResult("Silme işlemi başarılı");
	}

	@Override
	public DataResult<Link> getById(int id) {
		return new SuccessDataResult<Link>(this.linkDao.getById(id));

	}

	@Override
	public DataResult<List<Link>> getAll() {
		return new SuccessDataResult<List<Link>>(this.linkDao.findAll());

	}

	@Override
	public DataResult<List<Link>> getAllByJobseekerId(int id) {
		return new SuccessDataResult<List<Link>>(this.linkDao.getAllByJobseeker_id(id));

	}

}
