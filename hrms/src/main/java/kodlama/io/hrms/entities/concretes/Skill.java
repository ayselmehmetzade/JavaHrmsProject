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

import com.fasterxml.jackson.annotation.JsonIgnore;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name="skills")

public class Skill {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="skill_name")
	private String skillName;
	
	@JsonIgnore
	@Column(name = "created_at", columnDefinition = "Date default CURRENT_DATE")
	private LocalDate createdAt = LocalDate.now();

	@JsonIgnore
	@Column(name = "is_active", columnDefinition = "boolean default true")
	private boolean isActive = true;

	@JsonIgnore
	@Column(name = "is_deleted", columnDefinition = "boolean default false")
	private boolean isDeleted = false;

	@ManyToOne()
	@JoinColumn(name = "jobseeker_id")
	private JobSeeker jobseeker;


}
