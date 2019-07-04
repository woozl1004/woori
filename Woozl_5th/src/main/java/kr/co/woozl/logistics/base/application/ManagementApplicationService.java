package kr.co.woozl.logistics.base.application;

import java.util.List;

import kr.co.woozl.logistics.base.to.CompanyTO;
import kr.co.woozl.logistics.base.to.DeptTO;
import kr.co.woozl.logistics.base.to.PositionTO;
import kr.co.woozl.logistics.base.to.WorkplaceTO;

public interface ManagementApplicationService {

	public List<DeptTO> findDeptList();

	public List<CompanyTO> findCompanyList();

	public List<WorkplaceTO> findWorkplaceList();

	public List<PositionTO> findPositionList();

	public void batchDepartmentList(List<DeptTO> batchDeptList);
	
	public void batchCompanyList(List<CompanyTO> batchCompanyList);
	
	public void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList);

}
