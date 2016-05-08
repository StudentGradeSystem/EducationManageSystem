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
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import org.hibernate.annotations.Cascade;
@Entity
@Table(name="financial_account")
public class FinAcc{
	@Id 
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="acc_no")
	private int accNo; // 账户编号
	
	@Column(name="acc_pwd")
	private String accPwd; // 账户密码
	
	@Column(name="acc_amount")
	private Double accAmount; // 账号金额
	
	@Column(name="acc_status")
	private String accStatus; // 账户状态
	
	@Column(name="idcard_no")
	private String IDCardNo; // 客户ID
	
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate; // 账户创建时间
	
	@OneToMany(mappedBy="finAcc")  //一对多
	private Set<FundHolding> holdings=new HashSet();//持仓记录集合
	
	@OneToMany(mappedBy="finAcc")  //一对多
	private Set<FinAccTrans> finAccTrans=new HashSet(); //交易记录集合
	
	@OneToOne(targetEntity=Client.class)
	@JoinColumn(name="IDCARD_NO",unique=true)
	private Client client;   //客户信息
	
	@ManyToMany(mappedBy="finAccs")
	private Set<Fund> funds=new HashSet<Fund>();//持有的基金信息

	/**
	 * @return the accNo
	 */
	public int getAccNo() {
		return accNo;
	}

	/**
	 * @param accNo
	 *            the accNo to set
	 */
	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	/**
	 * @return the accPwd
	 */
	public String getAccPwd() {
		return accPwd;
	}

	/**
	 * @param accPwd
	 *            the accPwd to set
	 */
	public void setAccPwd(String accPwd) {
		this.accPwd = accPwd;
	}

	/**
	 * @return the accAmount
	 */
	public Double getAccAmount() {
		return accAmount;
	}

	/**
	 * @param accAmount
	 *            the accAmount to set
	 */
	public void setAccAmount(Double accAmount) {
		this.accAmount = accAmount;
	}

	/**
	 * @return the accStatus
	 */
	public String getAccStatus() {
		return accStatus;
	}

	/**
	 * @param accStatus
	 *            the accStatus to set
	 */
	public void setAccStatus(String accStatus) {
		this.accStatus = accStatus;
	}

	/**
	 * @return the IDCardNo
	 */
	public String getIDCardNo() {
		return IDCardNo;
	}

	/**
	 * @param IDCardNo
	 *            the IDCardNo to set
	 */
	public void setIDCardNo(String IDCardNo) {
		this.IDCardNo = IDCardNo;
	}

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public Set<FundHolding> getHoldings() {
		return holdings;
	}

	public void setHoldings(Set<FundHolding> holdings) {
		this.holdings = holdings;
	}

	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}

	public Set<Fund> getFunds() {
		return funds;
	}

	public void setFunds(Set<Fund> funds) {
		this.funds = funds;
	}

	public Set<FinAccTrans> getFinAccTrans() {
		return finAccTrans;
	}

	public void setFinAccTrans(Set<FinAccTrans> finAccTrans) {
		this.finAccTrans = finAccTrans;
	}
	
}
