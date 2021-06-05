package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.EmployerVerificationEmployee;

public interface EmployerVerificationEmployeeDao extends JpaRepository<EmployerVerificationEmployee, Integer> {

	EmployerVerificationEmployee getById(int id);
}
