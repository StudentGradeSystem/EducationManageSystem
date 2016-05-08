package edu.fzu.openfund.controller;

import java.util.Map;

import javassist.bytecode.stackmap.BasicBlock.Catch;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;

import edu.fzu.openfund.service.FundTransService;
import edu.fzu.openfund.util.PageBean;

public class FundTransAction extends ActionSupport {
	private int fundNo;   //基金编号
	private int accNo = 0;   //账户编号
	private String accPwd;  //账户密码
	private int amount;      //基金购买数量
	private int pageNo = 1;  //页码
	private double price;    //基金价格
	private FundTransService fundTransService;

	public String buy() {
		//请补充完成代码		
		fundTransService.buyFund(fundNo, amount, price, accNo, accPwd);	
		return SUCCESS;
	}

	public String showHolding() {
		
		//显示持仓
		PageBean pageBean=fundTransService.getFundHolding(accNo, pageNo);	
		ActionContext.getContext().put("pageBean", pageBean);
		return SUCCESS;

	}

	public int getFundNo() {
		return fundNo;
	}

	public void setFundNo(int fundNo) {
		this.fundNo = fundNo;
	}

	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public String getAccPwd() {
		return accPwd;
	}

	public void setAccPwd(String accPwd) {
		this.accPwd = accPwd;
	}

	public int getAmount() {
		return amount;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public void setAmount(int amount) {
		this.amount = amount;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public FundTransService getFundTransService() {
		return fundTransService;
	}

	public void setFundTransService(FundTransService fundTransService) {
		this.fundTransService = fundTransService;
	}
}
