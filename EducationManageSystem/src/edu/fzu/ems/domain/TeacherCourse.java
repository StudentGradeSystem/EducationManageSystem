package edu.fzu.ems.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="teach_course")
public class TeacherCourse {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="tc_id")
	private Integer tcId;
	
	@Column(name="student_count")
	private Integer studentCount;
	
	@Column(name="limit_count")
	private Integer limitCount;
	
	@OneToMany(mappedBy="teachCourse",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<StudentCourse> studentCourses=new HashSet<StudentCourse>();
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="teacher_id",nullable=false)
	private Teacher teacher;
	
	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="course_id",nullable=false)
	private Course course;
	
	
	public Integer getTcId() {
		return tcId;
	}
	public void setTcId(Integer tcId) {
		this.tcId = tcId;
	}
	public Integer getStudentCount() {
		return studentCount;
	}
	public void setStudentCount(Integer studentCount) {
		this.studentCount = studentCount;
	}
	public Integer getLimitCount() {
		return limitCount;
	}
	public void setLimitCount(Integer limitCount) {
		this.limitCount = limitCount;
	}
	public Set<StudentCourse> getStudentCourses() {
		return studentCourses;
	}
	public void setStudentCourses(Set<StudentCourse> studentCourses) {
		this.studentCourses = studentCourses;
	}
	public Teacher getTeacher() {
		return teacher;
	}
	public void setTeacher(Teacher teacher) {
		this.teacher = teacher;
	}
	public Course getCourse() {
		return course;
	}
	public void setCourse(Course course) {
		this.course = course;
	}
	
	
}
