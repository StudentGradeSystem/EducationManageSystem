package edu.fzu.openfund.domain;

import java.util.Date;

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
@Table(name="fund_transinfo")
public class FundTrans {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "trans_id")
	private int transID; // 交易流水号

	@Column(name = "trans_type")
	private String transType; // 交易类型

	@Column(name = "amount")
	private int transAmount; // 交易基金份数

	@Column(name = "price")
	private double transPrice; // 交易单价

	@Column(name = "create_date")
	@Temporal(TemporalType.TIMESTAMP)
	private Date createDate; // 交易时间

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "acc_no1")
	private FinAcc finAcc;   //账户信息

	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name = "fund_no")
	private Fund fund;     //基金信息

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
	 * @param string
	 *            the transType to set
	 */
	public void setTransType(String string) {
		this.transType = string;
	}

	/**
	 * @return the transAmount
	 */
	public int getTransAmount() {
		return transAmount;
	}

	/**
	 * @param transAmount
	 *            the transAmount to set
	 */
	public void setTransAmount(int transAmount) {
		this.transAmount = transAmount;
	}

	/**
	 * @return the transPrice
	 */
	public double getTransPrice() {
		return transPrice;
	}

	/**
	 * @param price
	 *            the transPrice to set
	 */
	public void setTransPrice(double price) {
		this.transPrice = price;
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

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

}
