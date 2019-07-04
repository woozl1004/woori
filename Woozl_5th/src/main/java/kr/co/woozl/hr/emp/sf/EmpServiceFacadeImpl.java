package kr.co.woozl.hr.emp.sf;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.co.woozl.hr.emp.applicationService.EmpApplicationService;
import kr.co.woozl.hr.emp.to.EmployeeTO;

@Service
public class EmpServiceFacadeImpl implements EmpServiceFacade{

	@Autowired
	private EmpApplicationService empApplicationService; 
	

	@Override
	public List<EmployeeTO> findEmployeeList() {
		// TODO Auto-generated method stub
		
		return empApplicationService.findEmployeeList();
		
	}
	
	@Override
	public void batchEmployee(List<EmployeeTO> employeeList) {
		// TODO Auto-generated method stub
		
		empApplicationService.batchEmployee(employeeList);
		
	}
	
}
