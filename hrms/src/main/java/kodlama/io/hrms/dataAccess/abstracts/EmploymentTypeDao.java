package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.EmploymentType;

public interface EmploymentTypeDao  extends JpaRepository<EmploymentType, Integer>{
	EmploymentType getById(int id);

}
