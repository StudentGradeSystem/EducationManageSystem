package edu.fzu.ems.domain;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="course")
public class Course {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="course_id")
	private Integer courseId;
	
	@Column(name="course_no")
	private String courseNo;
	
	@Column(name="course_name")
	private String courseName;
	
	@Column(name="course_type")
	private String courseType;
	
	@Column(name="course_credit")
	private Float courseCredit;
	
	@Column(name="course_time")
	private Integer courseTime;
	
	@Column(name="course_des")
	private String courseDes;
	
	@OneToMany(mappedBy="course",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<TeacherCourse> teacherCourses=new HashSet<TeacherCourse>();
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseType() {
		return courseType;
	}
	public void setCourseType(String courseType) {
		this.courseType = courseType;
	}
	public Float getCourseCredit() {
		return courseCredit;
	}
	public void setCourseCredit(Float courseCredit) {
		this.courseCredit = courseCredit;
	}
	public Integer getCourseTime() {
		return courseTime;
	}
	public void setCourseTime(Integer courseTime) {
		this.courseTime = courseTime;
	}
	public String getCourseDes() {
		return courseDes;
	}
	public void setCourseDes(String courseDes) {
		this.courseDes = courseDes;
	}
	public String getCourseNo() {
		return courseNo;
	}
	public void setCourseNo(String courseNo) {
		this.courseNo = courseNo;
	}
	public Set<TeacherCourse> getTeacherCourses() {
		return teacherCourses;
	}
	public void setTeacherCourses(Set<TeacherCourse> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}
	
}
