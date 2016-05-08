package edu.fzu.openfund.controller;

import java.util.Date;
import java.util.List;
import java.util.Map;
import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.service.FundService;
import edu.fzu.openfund.service.FundServiceImpl;
import edu.fzu.openfund.util.PageBean;

public class FundAction extends ActionSupport {
	private String fundName; // 查询条件参数
	private Double fromPrice; // 查询条件参数
	private Double toPrice; // 查询条件参数
	private String fundStatus; // 查询条件参数
	private String fromDate; // 查询条件参数
	private String toDate; // 查询条件参数
	private int pageNo = 1; // 页码查询参数
	private Fund fund; // 基金表单数据
	private int fundNo; // 基金编号参数
	private PageBean pageBean; // 封装显示数据
	FundService fundService;

	/**
	 * @return
	 */
	public String execute() {
		// TODO Auto-generated method stub
		return SUCCESS;
	}

	// 处理新增基金请求
	public String create() {
		Date fundDate = new Date();
		fund.setFundCreateDate(fundDate);
		try {
			fundService.createFund(fund);
		} catch (Exception e) {
			// e.printStackTrace();
		}
		/*
		 * Map session=ActionContext.getContext().getSession(); Map
		 * request=(Map)ActionContext.getContext().get("request");
		 * request.put("fund", fund); session.put("fund", fund);
		 */
		return "showFund";
	}

	// 处理删除基金请求
	public String delete() {
		fundService.deleteFund(fundNo);
		return "show";
	}

	// 处理分页显示基金请求
	public String show() {
		pageBean = fundService.getFunds(fundName, fromPrice, toPrice,
				fundStatus, fromDate, toDate, pageNo);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "showfunds";
	}

	// 处理分页显示基金请求
	public String getAllFunds() {
		pageBean = fundService.getFunds(fundName, fromPrice, toPrice,
				fundStatus, fromDate, toDate, pageNo);
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("pageBean", pageBean);
		return "showfunds";
	}

	// 处理按编号查找基金请求
	public String findFund() {
		fund = fundService.getFund(fundNo);
		/*
		 * Map session=ActionContext.getContext().getSession(); Map
		 * request=(Map)ActionContext.getContext().get("request");
		 * request.put("fund", fund); session.put("fund", fund);
		 */
		return SUCCESS;
	}

	// 查找所有的基金记录
	public String findAllFunds() {
		List funds = fundService.getAllFunds();
		Map request = (Map) ActionContext.getContext().get("request");
		request.put("funds", funds);
		return SUCCESS;
	}

	public String getFundName() {
		return fundName;
	}

	public void setFundName(String fundName) {
		this.fundName = fundName;
	}

	public Double getFromPrice() {
		return fromPrice;
	}

	public void setFromPrice(Double fromPrice) {
		this.fromPrice = fromPrice;
	}

	public Double getToPrice() {
		return toPrice;
	}

	public void setToPrice(Double toPrice) {
		this.toPrice = toPrice;
	}

	public String getFundStatus() {
		return fundStatus;
	}

	public void setFundStatus(String fundStatus) {
		this.fundStatus = fundStatus;
	}

	public String getFromDate() {
		return fromDate;
	}

	public void setFromDate(String fromDate) {
		this.fromDate = fromDate;
	}

	public String getToDate() {
		return toDate;
	}

	public void setToDate(String toDate) {
		this.toDate = toDate;
	}

	public Fund getFund() {
		return fund;
	}

	public void setFund(Fund fund) {
		this.fund = fund;
	}

	public int getFundNo() {
		return fundNo;
	}

	public void setFundNo(int fundNo) {
		this.fundNo = fundNo;
	}

	public PageBean getPageBean() {
		return pageBean;
	}

	public void setPageBean(PageBean pageBean) {
		this.pageBean = pageBean;
	}

	public int getPageNo() {
		return pageNo;
	}

	public void setPageNo(int pageNo) {
		this.pageNo = pageNo;
	}

	public void setFundService(FundService fundService) {
		this.fundService = fundService;
	}
}