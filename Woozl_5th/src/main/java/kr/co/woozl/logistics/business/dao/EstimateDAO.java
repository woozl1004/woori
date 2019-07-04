package kr.co.woozl.logistics.business.dao;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.business.to.EstimateTO;

public interface EstimateDAO {

	public List<EstimateTO> selectEstimateList(Map<String,Object> map);

	public List<EstimateTO> selectEstimateDialog();
	
	public void insertEstimate(EstimateTO estimateTO);
	
	public void updateEstimate(EstimateTO estimateTO);
	
	public void updateEstimateStatus(EstimateTO estimateList);
	
	public void deleteEstimate(EstimateTO estimateTO);
	

}
