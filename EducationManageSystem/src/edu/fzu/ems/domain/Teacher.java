package edu.fzu.ems.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;


@Entity
@Table(name="teacher")
public class Teacher {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="teacher_id")
	private Integer teacherId;
	
	@Column(name="teacher_no")
	private String teacherNo;
	
	@Column(name="teacher_name")
	private String teacherName;
	
	@Column(name="teacher_sex")
	private String teacherSex;
	
	@Column(name="teacher_birth")
	@Temporal(TemporalType.DATE)
	private Date teacherBirth;
	
	@Column(name="teacher_title")
	private String teacherTitle;
	
	@Column(name="teacher_info")
	private String teacherInfo;
	
	@OneToMany(mappedBy="teacher",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Appraise> appraises= new HashSet<Appraise>();
	
	@OneToMany(mappedBy="teacher",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<Message> messages=new HashSet<Message>();
	
	@OneToMany(mappedBy="teacher",
			cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<TeacherCourse> teacherCourse=new HashSet<TeacherCourse>();

	@ManyToOne(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="institute_id",nullable=false)
	private Institute institute;

	public Integer getTeacherId() {
		return teacherId;
	}

	public void setTeacherId(Integer teacherId) {
		this.teacherId = teacherId;
	}

	public String getTeacherNo() {
		return teacherNo;
	}

	public void setTeacherNo(String teacherNo) {
		this.teacherNo = teacherNo;
	}

	public String getTeacherName() {
		return teacherName;
	}

	public void setTeacherName(String teacherName) {
		this.teacherName = teacherName;
	}

	public String getTeacherSex() {
		return teacherSex;
	}

	public void setTeacherSex(String teacherSex) {
		this.teacherSex = teacherSex;
	}

	public Date getTeacherBirth() {
		return teacherBirth;
	}

	public void setTeacherBirth(Date teacherBirth) {
		this.teacherBirth = teacherBirth;
	}

	public String getTeacherTitle() {
		return teacherTitle;
	}

	public void setTeacherTitle(String teacherTitle) {
		this.teacherTitle = teacherTitle;
	}

	public String getTeacherInfo() {
		return teacherInfo;
	}

	public void setTeacherInfo(String teacherInfo) {
		this.teacherInfo = teacherInfo;
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

	public Set<TeacherCourse> getTeacherCourse() {
		return teacherCourse;
	}

	public void setTeacherCourse(Set<TeacherCourse> teacherCourse) {
		this.teacherCourse = teacherCourse;
	}

	public Institute getInstitute() {
		return institute;
	}

	public void setInstitute(Institute institute) {
		this.institute = institute;
	}
	
	
}
