package edu.fzu.openfund.service;

import java.util.Date;
import java.util.List;

import javax.enterprise.inject.New;

import edu.fzu.openfund.dao.FinAccDao;
import edu.fzu.openfund.dao.FinAccTransDao;
import edu.fzu.openfund.dao.FundDao;
import edu.fzu.openfund.dao.FundHoldingDao;
import edu.fzu.openfund.dao.FundTransDao;
import edu.fzu.openfund.domain.FinAcc;
import edu.fzu.openfund.domain.FinAccTrans;
import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.domain.FundHolding;
import edu.fzu.openfund.domain.FundTrans;
import edu.fzu.openfund.util.PageBean;

public class FundTransServiceImpl implements FundTransService {
	private FundTransDao fundTransDao;
	private FundHoldingDao fundHoldingDao;
	private FundDao fundDao;
	private FinAccDao finAccDao;
	private FinAccTransDao finAccTransDao;

	@Override
	// 涉及持仓表，账户表，基金交易明细表, 账户交易明细表
	public int buyFund(int fundNo, int amount, double price, int accNo,
			String accPwd) {
		// 请补充编写代码
		FinAcc user = finAccDao.find(accPwd, accNo);
		Fund fund = fundDao.get(Fund.class, fundNo);
		if (user != null) {
			double totleMoney = amount * price * 1.01;
			if (user.getAccAmount() >= totleMoney) {
				// 扣钱
				double money = user.getAccAmount() - totleMoney;
				user.setAccAmount(money);
				// 增加持仓纪录
				FundHolding fundHolding = fundHoldingDao.findFundHolding(accNo,
						fundNo);
				if (fundHolding != null) {
					int holdAmount = fundHolding.getHoldAmount() + amount;
					fundHolding.setHoldAmount(holdAmount);
				} else {
					fundHolding = new FundHolding();
					fundHolding.setHoldAmount(amount);
					fundHolding.setFinAcc(user);
					fundHolding.setFund(fund);
					fundHoldingDao.save(fundHolding);
				}
				// 增加基金交易记录
				FundTrans fundTrans = new FundTrans();
				fundTrans.setTransAmount(amount);
				fundTrans.setCreateDate(new Date());
				fundTrans.setFinAcc(user);
				fundTrans.setFund(fund);
				fundTrans.setTransType("B");
				fundTrans.setTransPrice(price);
				fundTransDao.save(fundTrans);
				
				//增加资金交易记录
				FinAccTrans finAccTrans=new FinAccTrans();
				finAccTrans.setCreateDate(new Date());
				finAccTrans.setFinAcc(user);
				finAccTrans.setTransAmount(amount * price * 1.01);
				finAccTrans.setTransType("B");
				finAccTransDao.save(finAccTrans);
  
			}
		}
		return 0;
	}

	@Override
	public PageBean getFundHolding(int accNo, int pageNo) {
		// 请补充编写代码
		
		PageBean pb=new PageBean();
		List<FundHolding> list=null;
		int count = (int)fundHoldingDao.getSize(accNo);
		if(accNo==0)
			list=fundHoldingDao.findHoldingsByPage(pageNo, pb.getRowsPerPage());	
		else
		    list=fundHoldingDao.findHoldingsByAccPage(accNo, pageNo, pb.getRowsPerPage());
		pb.setMaxRowCount(count);
		System.out.println(list.get(0).getHoldAmount());
		pb.setData(list);
		pb.setCurPage(pageNo);
	    pb.countMaxPage();
		return pb;
	}

	public void setFundTransDao(FundTransDao fundTransDao) {
		this.fundTransDao = fundTransDao;
	}

	public void setFundHoldingDao(FundHoldingDao fundHoldingDao) {
		this.fundHoldingDao = fundHoldingDao;
	}

	public void setFundDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}

	public void setFinAccDao(FinAccDao finAccDao) {
		this.finAccDao = finAccDao;
	}

	public void setFinAccTransDao(FinAccTransDao finAccTransDao) {
		this.finAccTransDao = finAccTransDao;
	}
}
