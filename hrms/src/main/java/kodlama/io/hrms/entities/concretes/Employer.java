package kodlama.io.hrms.entities.concretes;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="employers")
public class Employer {

	@Id
	@GeneratedValue
	@Column(name="user_id")
	private int userId;
	
	@Column(name="website")
	private String webSite;
	
	@Column(name="phone_number")
	private String phoneNumber;
	
	@Column(name="is_verified")
	private boolean isVerified;
	
	@Column(name="company_name")
	private String companyName;

	public Employer() {

	}

	public Employer(int userId, String webSite, String phoneNumber, boolean isVerified, String companyName) {
		super();
		this.userId = userId;
		this.webSite = webSite;
		this.phoneNumber = phoneNumber;
		this.isVerified = isVerified;
		this.companyName = companyName;
	}

}
