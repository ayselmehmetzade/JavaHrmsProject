package kodlama.io.hrms.dataAccess.abstracts;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import kodlama.io.hrms.entities.concretes.Skill;

public interface SkillDao extends JpaRepository<Skill, Integer> {

	Skill getById(int id);

	List<Skill> getAllByJobseeker_id(int id);
}
