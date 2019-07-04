package kr.co.woozl.logistics.base.dao;

import java.util.List;

import kr.co.woozl.logistics.base.to.PositionTO;


public interface PositionDAO {

	List<PositionTO> selectPositionList();
	
}
