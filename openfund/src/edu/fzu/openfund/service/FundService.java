package edu.fzu.openfund.service;
import java.util.Date;
import java.util.List;

import edu.fzu.openfund.domain.Fund;
import edu.fzu.openfund.util.PageBean;

public interface FundService {

	void createFund(Fund fund);

	Fund getFund(int fundNo);

	void updateFund(Fund fund);

	void deleteFund(int fundNo);

	PageBean getFunds(String fundName, Double fromPrice, Double toPrice,
			String fundStatus, String fromDate, String toDate, int pageNo);
	
	List getAllFunds();

}
