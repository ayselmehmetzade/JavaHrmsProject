package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data

@Entity
@Table(name="employers_verification_employees")

public class EmployerVerificationEmployee {

	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="employee_id")
	private int employeeId;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="created_at")
	private LocalDate createdAt;

	public EmployerVerificationEmployee() {

	}

	public EmployerVerificationEmployee(int id, int employeeId, int employerId, LocalDate createdAt) {
		super();
		this.id = id;
		this.employeeId = employeeId;
		this.employerId = employerId;
		this.createdAt = createdAt;
	}

}
