package kodlama.io.hrms.entities.concretes;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="employment_types")
@JsonIgnoreProperties({ "hibernateLazyInitializer", "handler", "jobPostings" })
public class EmploymentType {
	
	@Id
	@GeneratedValue
	@Column(name = "id")
	private int id;

	@Column(name = "name")
	private String name;

	@OneToMany(mappedBy = "employmentType")
	private List<JobPosting> jobPostings;
	
	public EmploymentType(String name, List<JobPosting> jobPostings) {
		super();
		this.name = name;
		this.jobPostings = jobPostings;		
	}

}
