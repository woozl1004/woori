package kr.co.woozl.logistics.base.application;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.woozl.logistics.base.dao.CompanyDAO;
import kr.co.woozl.logistics.base.dao.DeptDAO;
import kr.co.woozl.logistics.base.dao.PositionDAO;
import kr.co.woozl.logistics.base.dao.WorkplaceDAO;
import kr.co.woozl.logistics.base.to.CompanyTO;
import kr.co.woozl.logistics.base.to.DeptTO;
import kr.co.woozl.logistics.base.to.PositionTO;
import kr.co.woozl.logistics.base.to.WorkplaceTO;

@Component
public class ManagementApplicationServiceImpl implements ManagementApplicationService{

	@Autowired
	private DeptDAO deptDAO;
	
	@Autowired
	private CompanyDAO companyDAO;
	
	@Autowired
	private WorkplaceDAO workplaceDAO;
	
	@Autowired
	private PositionDAO positionDAO;


	@Override
	public List<DeptTO> findDeptList() {
		// TODO Auto-generated method stub
		return deptDAO.selectDeptList();
	}



	@Override
	public List<CompanyTO> findCompanyList() {
		// TODO Auto-generated method stub
		return companyDAO.selectCompanyList();
	}



	@Override
	public List<WorkplaceTO> findWorkplaceList() {
		// TODO Auto-generated method stub
		return workplaceDAO.selectWorkplaceList();
	}



	@Override
	public List<PositionTO> findPositionList() {
		// TODO Auto-generated method stub
		return positionDAO.selectPositionList();
	}
	
	@Override
	public void batchDepartmentList(List<DeptTO> batchDeptList) {
		// TODO Auto-generated method stub
		for(DeptTO deptTo :batchDeptList) {

			switch(deptTo.getStatus()) {

			case "insert" : deptDAO.insertDepartment(deptTo); break;

			case "update" : deptDAO.updateDepartment(deptTo); break;

			case "delete" : deptDAO.deleteDepartment(deptTo); break;
			}
		}

	}
	
	@Override
	public void batchCompanyList(List<CompanyTO> batchCompanyList){
		// TODO Auto-generated method stub
		for(CompanyTO companyTO :batchCompanyList) {

			switch(companyTO.getStatus()) {

			case "insert" : companyDAO.insertCompany(companyTO); break;

			case "update" : companyDAO.updateCompany(companyTO); break;

			case "delete" : companyDAO.deleteCompany(companyTO); break;
			}
		}

	}
	
	@Override
	public void batchWorkplaceList(List<WorkplaceTO> batchWorkplaceList){
		// TODO Auto-generated method stub
		for(WorkplaceTO workplaceTO : batchWorkplaceList) {

			switch(workplaceTO.getStatus()) {

			case "insert" : workplaceDAO.insertWorkplaceList(workplaceTO); break;

			case "update" : workplaceDAO.updateWorkplaceList(workplaceTO); break;

			case "delete" : workplaceDAO.deleteWorkplaceList(workplaceTO); break;
			}
		}

	}


}
