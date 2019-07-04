package kr.co.woozl.logistics.base.sf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.woozl.logistics.base.application.ManagementApplicationService;
import kr.co.woozl.logistics.base.to.CompanyTO;
import kr.co.woozl.logistics.base.to.DeptTO;
import kr.co.woozl.logistics.base.to.PositionTO;
import kr.co.woozl.logistics.base.to.WorkplaceTO;

@Service
public class ManagementServiceFacadeImpl implements ManagementServiceFacade{

	@Autowired
	private ManagementApplicationService managementApplicationService;

	@Override
	public List<DeptTO> findDeptList() {
		// TODO Auto-generated method stub
		return managementApplicationService.findDeptList();
	}

	@Override
	public List<CompanyTO> findCompanyList() {
		// TODO Auto-generated method stub
		return managementApplicationService.findCompanyList();
	}

	@Override
	public List<WorkplaceTO> findWorkplaceList() {
		// TODO Auto-generated method stub
		return managementApplicationService.findWorkplaceList();
	}

	@Override
	public List<PositionTO> findPositionList() {
		// TODO Auto-generated method stub
		return managementApplicationService.findPositionList();
	}

	@Override
	public void batchDepartmentList(List<DeptTO> batchDeptList){
		// TODO Auto-generated method stub
		managementApplicationService.batchDepartmentList(batchDeptList);

	}
	
	@Override
	public void batchCompanyList(List<CompanyTO> batchCompanyList){
		// TODO Auto-generated method stub
		managementApplicationService.batchCompanyList(batchCompanyList);

	}
	
	@Override
	public void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList){
		// TODO Auto-generated method stub
		managementApplicationService.batchWorkplaceList(batchWorkplaceList);

	}

	

}
