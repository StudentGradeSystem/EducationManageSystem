package edu.fzu.ems.domain;

import javax.persistence.*;

import org.hibernate.annotations.GeneratorType;

@Entity
@Table(name="appraise")
public class Appraise {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="appraise_id")
	private Integer appraiseId;
	
	@Column(name="appraise_content")
	private Integer appraiseContent;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="student_id",nullable=false)
	private Student student;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="teacher_id",nullable=false)
	private Teacher teacher;
	
	public Integer getAppraiseId() {
		return appraiseId;
	}
	public void setAppraiseId(Integer appraiseId) {
		this.appraiseId = appraiseId;
	}
	public Integer getAppraiseContent() {
		return appraiseContent;
	}
	public void setAppraiseContent(Integer appraiseContent) {
		this.appraiseContent = appraiseContent;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	
	
}
