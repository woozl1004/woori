package kr.co.woozl.logistics.business.dao;

import java.util.List;

import kr.co.woozl.logistics.business.to.EstimateDetailTO;


public interface EstimateDetailDAO {

	public List<EstimateDetailTO> selectEstimateDetailList();
	
	public void insertEstimateDetail(EstimateDetailTO estimateDetailTO);
	
	public void updateEstimateDetail(EstimateDetailTO estimateDetailTO);
	
	public void deleteEstimateDetail(EstimateDetailTO estimateDetailTO);
}
