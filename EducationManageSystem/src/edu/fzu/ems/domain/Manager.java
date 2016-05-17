package edu.fzu.ems.domain;

import java.util.Date;

import javax.persistence.*;


@Entity
@Table(name="manager")
public class Manager {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="manager_id")
	private Integer managerId;
	
	@Column(name="manager_no")
	private String managerNo;
	
	@Column(name="manager_name")
	private String managerName;
	
	@Column(name="manager_sex")
	private String managerSex;
	
	@Column(name="manager_birth")
	@Temporal(TemporalType.DATE)
	private Date managerBirth;
	
	@Column(name="manager_info")
	private String managerInfo;
	
	
	public Integer getManagerId() {
		return managerId;
	}
	public void setManagerId(Integer managerId) {
		this.managerId = managerId;
	}
	public String getManagerName() {
		return managerName;
	}
	public void setManagerName(String managerName) {
		this.managerName = managerName;
	}
	public String getManagerSex() {
		return managerSex;
	}
	public void setManagerSex(String managerSex) {
		this.managerSex = managerSex;
	}
	public Date getManagerBirth() {
		return managerBirth;
	}
	public void setManagerBirth(Date managerBirth) {
		this.managerBirth = managerBirth;
	}
	public String getManagerInfo() {
		return managerInfo;
	}
	public void setManagerInfo(String managerInfo) {
		this.managerInfo = managerInfo;
	}
	public String getManagerNo() {
		return managerNo;
	}
	public void setManagerNo(String managerNo) {
		this.managerNo = managerNo;
	}
}
