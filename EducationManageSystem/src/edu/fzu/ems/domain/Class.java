package edu.fzu.ems.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="class")
public class Class {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="class_id")
	private Integer classId;
	
	
	@Column(name="class_no")
	private Integer classNo;
	
	@Column(name="year")
	private Integer year;
	
	@OneToMany(mappedBy="clazz",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Student> students = new HashSet<Student>();
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="specialty_id",nullable=false)
	private Specialty specialty;
	
	public Integer getYear() {
		return year;
	}
	public void setYear(Integer year) {
		this.year = year;
	}
	public Integer getClassId() {
		return classId;
	}
	public void setClassId(Integer classId) {
		this.classId = classId;
	}
	public Integer getClassNo() {
		return classNo;
	}
	public void setClassNo(Integer classNo) {
		this.classNo = classNo;
	}
	
	public Set<Student> getStudents() {
		return students;
	}
	public void setStudents(Set<Student> students) {
		this.students = students;
	}
	public Specialty getSpecialty() {
		return specialty;
	}
	public void setSpecialty(Specialty specialty) {
		this.specialty = specialty;
	}
	
}
