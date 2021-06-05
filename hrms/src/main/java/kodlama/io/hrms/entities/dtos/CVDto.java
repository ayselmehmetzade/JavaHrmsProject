package kodlama.io.hrms.entities.dtos;

import java.util.List;

import kodlama.io.hrms.entities.concretes.Experience;
import kodlama.io.hrms.entities.concretes.ForeignLanguage;
import kodlama.io.hrms.entities.concretes.Image;
import kodlama.io.hrms.entities.concretes.JobSeeker;
import kodlama.io.hrms.entities.concretes.Link;
import kodlama.io.hrms.entities.concretes.School;
import kodlama.io.hrms.entities.concretes.Skill;

public class CVDto {

	public JobSeeker jobSeeker;
	public Image image;
	public List<School> schools;
	public List<Link> links;
	public List<Skill> skills;
	public List<ForeignLanguage> languages;
	public List<Experience> experiences;

}
