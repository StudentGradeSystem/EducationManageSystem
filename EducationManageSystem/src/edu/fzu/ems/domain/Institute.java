package edu.fzu.ems.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="institute")
public class Institute {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="institute_id")
	private Integer instituteId;
	
	@Column(name="institute_no")
	private String instituteNo;
	
	@Column(name="institute_name")
	private String instituteName;
	
	@OneToMany(mappedBy="institute",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Specialty> specialties=new HashSet<Specialty>();
	
	@OneToMany(mappedBy="institute",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Teacher> teachers=new HashSet<Teacher>();
	
	public Integer getInstituteId() {
		return instituteId;
	}
	public void setInstituteId(Integer instituteId) {
		this.instituteId = instituteId;
	}
	public String getInstituteName() {
		return instituteName;
	}
	public void setInstituteName(String instituteName) {
		this.instituteName = instituteName;
	}
	public String getInstituteNo() {
		return instituteNo;
	}
	public void setInstituteNo(String instituteNo) {
		this.instituteNo = instituteNo;
	}
	public Set<Specialty> getSpecialties() {
		return specialties;
	}
	public void setSpecialties(Set<Specialty> specialties) {
		this.specialties = specialties;
	}
	public Set<Teacher> getTeachers() {
		return teachers;
	}
	public void setTeachers(Set<Teacher> teachers) {
	}
	
}
