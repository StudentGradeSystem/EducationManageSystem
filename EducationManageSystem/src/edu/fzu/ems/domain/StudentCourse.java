package edu.fzu.ems.domain;

import javax.persistence.*;


@Entity
@Table(name="stu_course")
public class StudentCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="sc_id")
	private Integer scId;
	
	@Column(name="usual_grade")
	private Integer scusualGrade;
	
	@Column(name="term_grade")
	private Integer sctermGrade;
	
	@Column(name="experiment_grade")
	private Integer scexperimentGrade;
	
	@Column(name="comprehansive_grade")
	private Integer sccomprehansiveGrade;
	
	@Column(name="makeup_grade")
	private Integer scmakeupGrade;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="student_id",nullable=false)
	private Student student;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="course_id",nullable=false)
	private TeacherCourse teacherCourse;
	
	public Integer getScId() {
		return scId;
	}
	public void setScId(Integer scId) {
		this.scId = scId;
	}
	public Integer getScusualGrade() {
		return scusualGrade;
	}
	public void setScusualGrade(Integer scusualGrade) {
		this.scusualGrade = scusualGrade;
	}
	public Integer getSctermGrade() {
		return sctermGrade;
	}
	public void setSctermGrade(Integer sctermGrade) {
		this.sctermGrade = sctermGrade;
	}
	public Integer getScexperimentGrade() {
		return scexperimentGrade;
	}
	public void setScexperimentGrade(Integer scexperimentGrade) {
		this.scexperimentGrade = scexperimentGrade;
	}
	public Integer getSccomprehansiveGrade() {
		return sccomprehansiveGrade;
	}
	public void setSccomprehansiveGrade(Integer sccomprehansiveGrade) {
		this.sccomprehansiveGrade = sccomprehansiveGrade;
	}
	public Integer getScmakeupGrade() {
		return scmakeupGrade;
	}
	public void setScmakeupGrade(Integer scmakeupGrade) {
		this.scmakeupGrade = scmakeupGrade;
	}
	public Student getStudent() {
		return student;
	}
	public void setStudent(Student student) {
		this.student = student;
	}
	public TeacherCourse getTeacherCourse() {
		return teacherCourse;
	}
	public void setTeacherCourse(TeacherCourse teacherCourse) {
		this.teacherCourse = teacherCourse;
	}
}
