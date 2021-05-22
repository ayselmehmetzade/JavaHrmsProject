package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Employer;


public interface EmployerService {

	List<Employer> getAll();

	Employer getById(int id);

	void add(Employer employer);

	void delete(Employer employer);

	void update(Employer employer);
}
