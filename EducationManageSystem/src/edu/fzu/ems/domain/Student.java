package edu.fzu.ems.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;




@Entity
@Table(name="student")
public class Student {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="student_id")
	private Integer studentId;
	
	@Column(name="student_no")
	private String studentNo;
	
	@Column(name="student_name")
	private String studentName;
	
	@Column(name="student_sex")
	private String studentSex;
	
	@Column(name="student_birth")
	@Temporal(TemporalType.DATE)
	private Date studentBirth;
	
	@Column(name="student_dept")
	private Integer studentDept;
	
	@Column(name="student_gpa")
	private Float studentGpa;
	
	@Column(name="student_grade")
	private Float studentGrade;

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="class_id",nullable=false)
	private Class clazz;
	
	@OneToMany(mappedBy="student",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Appraise> appraises=new HashSet<Appraise>();
	
	@OneToMany(mappedBy="student",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Message> messages=new HashSet<Message>();
	
	@OneToMany(mappedBy="student",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<StudentCourse> selectedCourses=new HashSet<StudentCourse>();
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="stu_course",
	joinColumns=@JoinColumn(name="student_id"),
	inverseJoinColumns=@JoinColumn(name="course_id"))
	private Set<TeacherCourse> teacherCourses=new HashSet<TeacherCourse>();
	
	
	public Integer getStudentId() {
		return studentId;
	}
	public void setStudentId(Integer studentId) {
		this.studentId = studentId;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentSex() {
		return studentSex;
	}
	public void setStudentSex(String studentSex) {
		this.studentSex = studentSex;
	}
	public Date getStudentBirth() {
		return studentBirth;
	}
	public void setStudentBirth(Date studentBirth) {
		this.studentBirth = studentBirth;
	}
	public Integer getStudentDept() {
		return studentDept;
	}
	public void setStudentDept(Integer studentDept) {
		this.studentDept = studentDept;
	}
	public Float getStudentGpa() {
		return studentGpa;
	}
	public void setStudentGpa(Float studentGpa) {
		this.studentGpa = studentGpa;
	}
	public Float getStudentGrade() {
		return studentGrade;
	}
	public void setStudentGrade(Float studentGrade) {
		this.studentGrade = studentGrade;
	}
	public Class getClazz() {
		return clazz;
	}
	public void setClazz(Class clazz) {
		this.clazz = clazz;
	}
	public String getStudentNo() {
		return studentNo;
	}
	public void setStudentNo(String studentNo) {
		this.studentNo = studentNo;
	}
	public Set<Appraise> getAppraises() {
		return appraises;
	}
	public void setAppraises(Set<Appraise> appraises) {
		this.appraises = appraises;
	}
	public Set<Message> getMessages() {
		return messages;
	}
	public void setMessages(Set<Message> messages) {
		this.messages = messages;
	}
	public Set<StudentCourse> getSelectedCourses() {
		return selectedCourses;
	}
	public void setSelectedCourses(Set<StudentCourse> selectedCourses) {
		this.selectedCourses = selectedCourses;
	}
	public Set<TeacherCourse> getTeacherCourses() {
		return teacherCourses;
	}
	public void setTeacherCourses(Set<TeacherCourse> teacherCourses) {
		this.teacherCourses = teacherCourses;
	}
}
