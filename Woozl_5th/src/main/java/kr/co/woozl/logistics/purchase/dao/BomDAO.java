package kr.co.woozl.logistics.purchase.dao;

import java.util.List;
import java.util.Map;

import kr.co.woozl.logistics.purchase.to.BomDeployTO;
import kr.co.woozl.logistics.purchase.to.BomTO;



public interface BomDAO {

	public List<BomTO> selectBomList();
	
	public void insertBom(BomTO bomTO);
	
	public void updateBom(BomTO bomTO);
	
	public void deleteBom(BomTO bomTO);

	public List<BomDeployTO> selectBomDeployList(Map<String,Object> map);
	
	public List<BomDeployTO> selectBomDeployList2(Map<String,Object> map);
	
	

}
