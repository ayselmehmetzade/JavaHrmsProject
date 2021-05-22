package kodlama.io.hrms.business.abstracts;

import java.util.List;

import kodlama.io.hrms.entities.concretes.User;

public interface UserService {
	
	List<User> getAll();

	User getById(int id);

	void add(User user);

	void delete(User user);

	void update(User user);

}
