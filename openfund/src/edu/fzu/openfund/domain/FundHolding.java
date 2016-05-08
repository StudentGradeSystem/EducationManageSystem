package edu.fzu.openfund.domain;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;


@Entity  //实体类
@Table(name="fund_holding")  //对应的表
public class FundHolding {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hid")
	private int hID; // 持仓ID
	
	@Column(name="amount")  //amount--字段名
	private int holdAmount; // 持有基金数
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE}) //多对一关系
	@JoinColumn(name="fund_no1", nullable=false)
	private Fund fund;
	
	@ManyToOne(cascade = {CascadeType.PERSIST,CascadeType.MERGE})
	@JoinColumn(name="acc_no2",nullable=false)
	private FinAcc finAcc;

	/**
	 * @return the hID
	 */
	public int getHID() {
		return hID;
	}

	/**
	 * @param hid
	 *            the hID to set
	 */
	public void setHID(int hid) {
		hID = hid;
	}

	/**
	 * @return the holdAmount
	 */
	public int getHoldAmount() {
		return holdAmount;
	}

	/**
	 * @param holdAmount
	 *            the holdAmount to set
	 */
	public void setHoldAmount(int holdAmount) {
		this.holdAmount = holdAmount;
	}

	public int gethID() {
		return hID;
	}

	public void sethID(int hID) {
		this.hID = hID;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public FinAcc getFinAcc() {
		return finAcc;
	}

	public void setFinAcc(FinAcc finAcc) {
		this.finAcc = finAcc;
	}
	
}
