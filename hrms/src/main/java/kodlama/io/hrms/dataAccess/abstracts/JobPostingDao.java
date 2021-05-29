package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import kodlama.io.hrms.entities.concretes.JobPosting;

public interface JobPostingDao extends JpaRepository<JobPosting, Integer> {
	
	@Query("From JobPosting where isOpen=true")
	List<JobPosting> getAllOpenJobPosting();
	
	@Query("From JobPosting where isOpen=true Order By publishedDate Desc")
	List<JobPosting> getAllOrderByPublishedDateDesc();
	
	@Query("From JobPosting where isOpen = true and employer_id =:id")
	List<JobPosting> getAllOpenJobPostingByEmployer(int id);

}
