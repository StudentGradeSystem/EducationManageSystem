package edu.fzu.openfund.controller;

import java.util.Random;

import org.apache.struts2.json.annotations.JSON;

import com.opensymphony.xwork2.ActionSupport;

import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.service.FundService;
import edu.fzu.openfund.service.FundServiceImpl;

public class FundJsonAction extends ActionSupport {
	private int fundNo; // 基金编号
	private Fund fund; // json对象 fund={fundName:?, fundNo:?, ……}
	private String jsonResult;
	private FundService fundService;
	private Double price; //异步请求基金价格

	// 处理查找基金异步请求
	public String find() {
		fund = fundService.getFund(fundNo);
		return SUCCESS;
	}

	//异步获取基金价格
	public String findPrice() {
		Fund fund = fundService.getFund(fundNo);
		Random random = new Random();
		int i = random.nextInt(20) % 21 - 10;
		price = (1 + i * 1.0 / 100) * fund.getFundPrice();
		return SUCCESS;
	}

	// 处理更新异步请求
	public String update() {
		try {
			fundService.updateFund(fund);
			jsonResult = "更新成功";
		} catch (Exception e) {
			jsonResult = "更新失败";
		}
		return SUCCESS;
	}

	public int getFundNo() {
		return fundNo;
	}

	public void setFundNo(int fundNo) {
		this.fundNo = fundNo;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public String getJsonResult() {
		return jsonResult;
	}

	public void setJsonResult(String jResult) {
		this.jsonResult = jResult;
	}

	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}

	public Double getPrice() {
		return price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

}
