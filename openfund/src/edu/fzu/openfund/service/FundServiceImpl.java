package edu.fzu.openfund.service;

import java.util.Date;
import java.util.List;
import edu.fzu.openfund.dao.FundDao;
import edu.fzu.openfund.dao.FundDaoHibImpl;
import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.util.PageBean;

public class FundServiceImpl implements FundService {
	private FundDao fundDao;

	@Override
	public void createFund(Fund fund) {
		// TODO Auto-generated method stub
		fundDao.save(fund);
	}

	@Override
	public Fund getFund(int fundNo) {
		// TODO Auto-generated method stub
		return (Fund) fundDao.get(Fund.class, fundNo);
	}

	@Override
	public void updateFund(Fund fund) {
		// TODO Auto-generated method stub
		Fund f=fundDao.get(Fund.class, fund.getFundNo());
		f.setFundDes(fund.getFundDes());
		f.setFundName(fund.getFundName());
		f.setFundPrice(fund.getFundPrice());
		f.setFundStatus(fund.getFundStatus());
	}

	@Override
	public void deleteFund(int fundNo) {
		// TODO Auto-generated method stub
		fundDao.delete(Fund.class, fundNo);
	}

	@Override
	public PageBean getFunds(String fundName, Double fromPrice, Double toPrice,
			String fundStatus, String fromDate, String toDate, int pageNo) {
		// TODO Auto-generated method stub
		PageBean pageBean = new PageBean();
		List fundList = fundDao.findFundsPage(fundName, fromPrice, toPrice,
				fundStatus, fromDate, toDate, pageNo, pageBean.rowsPerPage);
		pageBean.curPage = pageNo;
		pageBean.data = fundList;
		pageBean.maxRowCount = fundDao.getRowsCount();
		pageBean.countMaxPage();
		return pageBean;
	}

	public void setFundDao(FundDao fundDao) {
		this.fundDao = fundDao;
	}

	@Override
	public List getAllFunds() {
		// TODO Auto-generated method stub
		return fundDao.findAll(Fund.class);
	}
}
