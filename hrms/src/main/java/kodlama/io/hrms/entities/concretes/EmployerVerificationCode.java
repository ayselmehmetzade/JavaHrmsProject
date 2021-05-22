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
@Table(name="employers_verification_codes")
public class EmployerVerificationCode {
	
	@Id
	@GeneratedValue
	@Column(name="id")
	private int id;
	
	@Column(name="employer_id")
	private int employerId;
	
	@Column(name="verification_code")
	private String verificationCode;
	
	@Column(name="is_confirmed")
	private boolean isConfirmed;
	
	@Column(name="created_at")
	private LocalDate createdAt;
	
	public EmployerVerificationCode() {
		
	}

	public EmployerVerificationCode(int id, int employerId, String verificationCode, boolean isConfirmed,
			LocalDate createdAt) {
		super();
		this.id = id;
		this.employerId = employerId;
		this.verificationCode = verificationCode;
		this.isConfirmed = isConfirmed;
		this.createdAt = createdAt;
	}

}
