package kodlama.io.hrms.dataAccess.abstracts;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Image;

public interface ImageDao extends JpaRepository<Image, Integer> {
	
	Image getById(int id);

	Image getByJobSeeker_id(int id);

}
