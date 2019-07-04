package kr.co.woozl.logistics.production.dao;

import java.util.List;

import kr.co.woozl.logistics.production.to.PrmTO;

public interface PrmDAO {

	public List<PrmTO> selectPrmList();

	public void insertPrm(PrmTO prmTO);

}
