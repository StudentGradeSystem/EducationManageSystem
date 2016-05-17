package edu.fzu.ems.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

/**
 * @author Administrator
 *
 */

@Entity
@Table(name="specialty")
public class Specialty {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sepcialty_id")
	private Integer specialtyId;
	
	
	@Column(name="specialty_no")
	private String specialtyNo;
	
	@Column(name="specialty_name")
	private String specialtyName;
	
	@OneToMany(mappedBy="specialty",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Class> classes = new HashSet<Class>();
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="institute_id",nullable=false)
	private Institute institute;
	
	public Integer getSpecialtyId() {
		return specialtyId;
	}
	public void setSpecialtyId(Integer specialtyId) {
		this.specialtyId = specialtyId;
	}
	public String getSpecialtyName() {
		return specialtyName;
	}
	public void setSpecialtyName(String specialtyName) {
		this.specialtyName = specialtyName;
	}
	public String getSpecialtyNo() {
		return specialtyNo;
	}
	public void setSpecialtyNo(String specialtyNo) {
		this.specialtyNo = specialtyNo;
	}
	public Set<Class> getClasses() {
		return classes;
	}
	public void setClasses(Set<Class> classes) {
		this.classes = classes;
	}
	public Institute getInstitute() {
		return institute;
	}
	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
}
