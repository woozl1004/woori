package kr.co.woozl.logistics.base.dao;

import java.util.List;

import kr.co.woozl.logistics.base.to.WorkplaceTO;


public interface WorkplaceDAO {

	public List<WorkplaceTO> selectWorkplaceList();
	
	public void insertWorkplaceList(WorkplaceTO workplaceTO);
	
	public void updateWorkplaceList(WorkplaceTO workplaceTO);
	
	public void deleteWorkplaceList(WorkplaceTO workplaceTO);
	
}
