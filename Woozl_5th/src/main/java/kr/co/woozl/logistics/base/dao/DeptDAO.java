package kr.co.woozl.logistics.base.dao;

import java.util.List;

import kr.co.woozl.logistics.base.to.DeptTO;

public interface DeptDAO {

	public List<DeptTO> selectDeptList();

	public void insertDepartment(DeptTO registDeptList) ;
	public void updateDepartment(DeptTO registDeptList) ;
	public void deleteDepartment(DeptTO registDeptList) ;

}
