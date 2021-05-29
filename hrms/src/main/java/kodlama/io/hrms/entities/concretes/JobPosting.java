package kodlama.io.hrms.entities.concretes;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="job_postings")
public class JobPosting {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
//	@Column(name="job_position_id")
//	private int jobPositionId;
//	
//	@Column(name="city_id")
//	private int cityId;
//	
//	@Column(name="employer_id")
//	private int employerId;
	
	@Column(name="description")
	private String description;
	
	@Column(name="open_position_quota")
	private int openPositionQuota;
	
	@Column(name="application_deadline")
	private LocalDate applicationDeadline;
	
	@Column(name="is_active")
	private boolean isActive;
	
	@Column(name="is_open")
	private boolean isOpen;
	
	@Column(name="is_deleted")
	private boolean isDeleted;
	
	@Column(name= "created_at")
	private LocalDate createdDate = LocalDate.now();
	
	@Column(name="published_date")
	private LocalDate publishedDate;
	
	@Column(name="max_salary")
	private int maxSalary;
	
	@Column(name="min_salary")
	private int minSalary;
	
	@ManyToOne
	@JoinColumn(name="job_position_id")
	private JobPosition jobPosition;

	@ManyToOne
	@JoinColumn(name="city_id")
	private City city;
	
	@ManyToOne
	@JoinColumn(name="employer_id")
	private Employer employer;
}
