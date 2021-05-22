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
@Table(name="jobseekers")

public class JobSeeker {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="first_name")
	private String firstName;
	
	@Column(name="last_name")
	private String lastName;
	
	@Column(name="national_id")
	private String nationalId;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="date_of_birth")
	private LocalDate dateOfBirth;

	public JobSeeker() {

	}

	public JobSeeker(int userId, String firstName, String lastName, String nationalId, boolean isVerified,
			LocalDate dateOfBirth) {
		super();
		this.userId = userId;
		this.firstName = firstName;
		this.lastName = lastName;
		this.nationalId = nationalId;
		this.isVerified = isVerified;
		this.dateOfBirth = dateOfBirth;
	}

}
