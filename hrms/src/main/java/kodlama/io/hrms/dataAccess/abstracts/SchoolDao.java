package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.School;

public interface SchoolDao extends JpaRepository<School, Integer> {

	School getById(int id);

	List<School> getAllByJobSeeker_idOrderByEndDateDesc(int id);

	List<School> getAllByJobSeeker_id(int id);

}
