package edu.fzu.openfund.domain;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
@Table(name="financial_account_transinfo")
public class FinAccTrans {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="trans_id")
	private int transID; // 交易号
	
	@Column(name="trans_type")
	private String transType; // 交易类型
	
	@Column(name="trans_amount")
	private double transAmount; // 交易金额
	
	@Column(name="create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate; // 交易时间
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="acc_no")
	private FinAcc finAcc;    //关联的资金账户

	/**
	 * @return the transID
	 */
	public int getTransID() {
		return transID;
	}

	/**
	 * @param transID
	 *            the transID to set
	 */
	public void setTransID(int transID) {
		this.transID = transID;
	}

	/**
	 * @return the transType
	 */
	public String getTransType() {
		return transType;
	}

	/**
	 * @param transType
	 *            the transType to set
	 */
	public void setTransType(String transType) {
		this.transType = transType;
	}

	/**
	 * @return the transAmount
	 */
	public double getTransAmount() {
		return transAmount;
	}

	/**
	 * @param double1
	 *            the transAmount to set
	 */
	public void setTransAmount(double double1) {
		this.transAmount = double1;
	}

	

	public Date getCreateDate() {
		return createDate;
	}

	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}

	public FinAcc getFinAcc() {
		return finAcc;
	}

	public void setFinAcc(FinAcc finAcc) {
		this.finAcc = finAcc;
	}

}
