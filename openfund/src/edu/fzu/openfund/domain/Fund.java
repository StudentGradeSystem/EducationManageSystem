package edu.fzu.openfund.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import org.apache.struts2.json.annotations.JSON;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

@Entity 
@Table(name="fund")
public class Fund {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="fund_no")
	private Integer fundNo; // 基金编号
	
	@Column(name="fund_name",unique=true)
	private String fundName; // 基金名称
	
	@Column(name="fund_price")
	private Double fundPrice; // 基金价格
	
	@Column(name="fund_des")
	private String fundDes; // 基金描述
	
	@Column(name="fund_status")
	private String fundStatus; // 基金状态
	
	@Column(name="created_date")
	@Temporal(TemporalType.DATE)
	private Date fundCreateDate; // 基金创建时间
	
	@OneToMany(mappedBy="fund",
		cascade={CascadeType.PERSIST,CascadeType.MERGE})
	private Set<FundHolding> holdings=new HashSet<FundHolding>();
	
	@ManyToMany(cascade={CascadeType.PERSIST,CascadeType.MERGE})
	@JoinTable(name="fund_holding",
	joinColumns=@JoinColumn(name="fund_no1"),
	inverseJoinColumns=@JoinColumn(name="acc_no2"))
	private Set<FinAcc> finAccs=new HashSet<FinAcc>();
	
	public int getFundNo() {
		return fundNo;
	}
	public void setFundNo(int fundNo) {
		this.fundNo = fundNo;
	}
	public String getFundName() {
		return fundName;
	}
	public void setFundName(String fundName) {
		this.fundName = fundName;
	}
	public Double getFundPrice() {
		return fundPrice;
	}
	public void setFundPrice(Double fundPrice) {
		this.fundPrice = fundPrice;
	}
	public String getFundDes() {
		return fundDes;
	}
	public void setFundDes(String fundDes) {
		this.fundDes = fundDes;
	}
	public String getFundStatus() {
		return fundStatus;
	}
	public void setFundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}
	public Date getFundCreateDate() {
		return fundCreateDate;
	}
	public void setFundCreateDate(Date fundCreateDate) {
		this.fundCreateDate = fundCreateDate;
	}
	
	public Fund() {
		super();
	}
	public Fund(int fundNo, String fundName, Double fundPrice, String fundDes,
			String fundStatus, Date fundCreateDate) {
		super();
		this.fundNo = fundNo;
		this.fundName = fundName;
		this.fundPrice = fundPrice;
		this.fundDes = fundDes;
		this.fundStatus = fundStatus;
		this.fundCreateDate = fundCreateDate;
	}

	public void setFundNo(Integer fundNo) {
		this.fundNo = fundNo;
	}
	@JSON(serialize = false)
	public Set<FundHolding> getHoldings() {
		return holdings;
	}
	public void setHoldings(Set<FundHolding> holdings) {
		this.holdings = holdings;
	}
	
	@JSON(serialize = false)
	public Set<FinAcc> getFinAccs() {
		return finAccs;
	}
	public void setFinAccs(Set<FinAcc> finAccs) {
		this.finAccs = finAccs;
	}
	
	
}
