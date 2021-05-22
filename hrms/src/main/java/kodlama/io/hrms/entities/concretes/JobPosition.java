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
@Table(name = "job_positions")
public class JobPosition {

	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "job_title")
	private String jobTitle;

	@Column(name = "is_active")
	private boolean isActive;

	@Column(name = "is_deleted")
	private boolean isDeleted;

	@Column(name = "created_at")
	private LocalDate createdAt;

	public JobPosition() {

	}

	public JobPosition(int id, String jobTitle, boolean isActive, boolean isDeleted, LocalDate createdAt) {
		super();
		this.id = id;
		this.jobTitle = jobTitle;
		this.isActive = isActive;
		this.isDeleted = isDeleted;
		this.createdAt = createdAt;
	}


}
