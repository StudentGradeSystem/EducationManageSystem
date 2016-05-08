package edu.fzu.openfund.controller;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.service.FundService;
import edu.fzu.openfund.service.FundServiceImpl;
import edu.fzu.openfund.util.PageBean;

public class FundServlet extends HttpServlet {
	/**
	 * Constructor of the object.
	 */
	public FundServlet() {
		super();
	}
	/**
	 * Destruction of the servlet. <br>
	 */
	public void destroy() {
		super.destroy(); // Just puts "destroy" string in log
		// Put your code here
	}

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		FundService fundService = new FundServiceImpl();
		request.setCharacterEncoding("UTF-8");
		Fund fund;
		int type = Integer.parseInt(request.getParameter("type"));
		switch (type) {
		case 1:
			request.getRequestDispatcher("/fund/inputfund.jsp").forward(
					request, response);
			break;
		case 2:

			String fundName = request.getParameter("fundName");
			Double fundPrice = Double.parseDouble(request
					.getParameter("fundPrice"));
			String fundDes = request.getParameter("fundDes");
			String fundStatus = request.getParameter("fundStatus");
			Date fundDate = new Date();
			fund = new Fund();
			fund.setFundCreateDate(fundDate);
			fund.setFundDes(fundDes);
			fund.setFundName(fundName);
			fund.setFundPrice(fundPrice);
			fund.setFundStatus(fundStatus);
			fundService.createFund(fund);
			request.getRequestDispatcher("/fund/inputfund.jsp").forward(
					request, response);
			break;
		case 3:
			request.getRequestDispatcher("/fund/showfunds.jsp").forward(
					request, response);
			break;

		case 4:
			int fundNo = Integer.parseInt(request.getParameter("fundNo"));
			fundService.deleteFund(fundNo);
			request.getRequestDispatcher("/success.jsp").forward(request,
					response);
			break;

		case 5:
			fundNo = Integer.parseInt(request.getParameter("fundNo"));
			fund = fundService.getFund(fundNo);
			request.setAttribute("fund", fund);
			request.getRequestDispatcher("/fund/updatefund.jsp").forward(
					request, response);
			break;

		case 6:
			fundName = request.getParameter("fundName");
			fundPrice = Double.parseDouble(request.getParameter("fundPrice"));
			fundDes = request.getParameter("fundDes");
			fundStatus = request.getParameter("fundStatus");
			fundNo = Integer.parseInt(request.getParameter("fundNo"));
			fund = new Fund();
			fund.setFundNo(fundNo);
			fund.setFundDes(fundDes);
			fund.setFundName(fundName);
			fund.setFundPrice(fundPrice);
			fund.setFundStatus(fundStatus);
			fundService.updateFund(fund);
			request.getRequestDispatcher("/success.jsp").forward(request,
					response);
			break;

		case 8:
			int pageNo;
			if (request.getParameter("pageNo")==null)
				pageNo=1;
			else
				pageNo=Integer.parseInt(request.getParameter("pageNo"));
			fundName=request.getParameter("fundName");
			String lPrice=request.getParameter("fromPrice");
			String uPrice=request.getParameter("toPrice");
			fundStatus=request.getParameter("fundStatus");
			String fromDate=request.getParameter("fromDate");
			String toDate=request.getParameter("toDate");
			PageBean pageBean=new PageBean();
			if (fundName!= null && !fundName.equals("")){
				request.setAttribute("fundName", fundName);
			}
			Double fromPrice = null,toPrice=null;
			if (lPrice != null && !lPrice.equals("")){
				fromPrice = Double.valueOf(lPrice);
				request.setAttribute("fromPrice", lPrice);
			}
			if (uPrice != null && !uPrice.equals("")){
				toPrice = Double.valueOf(uPrice);
				request.setAttribute("toPrice", uPrice);
			}

			if (fundStatus != null && !fundStatus.equals("")){
				request.setAttribute("fundStatus", fundStatus);

			}
			if (fromDate != null && !fromDate.equals("")){
				request.setAttribute("fromDate", fromDate);

			}
			if (toDate != null  && !toDate.equals("")){
				request.setAttribute("toDate", toDate);
			}
			pageBean = fundService.getFunds(fundName, fromPrice, toPrice,
					fundStatus, fromDate, toDate, pageNo);
			request.setAttribute("pageBean", pageBean);
			
			request.getRequestDispatcher("/fund/showfunds.jsp").forward(
					request, response);
			break;
		default:
			break;
		}

	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request, response);
	}

	
	public void init() throws ServletException {
		// Put your code here
	}

}
