package kr.co.woozl.hr.emp.applicationService;

import java.util.List;

import kr.co.woozl.hr.emp.to.EmployeeTO;

public interface EmpApplicationService {

	public List<EmployeeTO> findEmployeeList();
	
	public void batchEmployee(List<EmployeeTO> employeeList);
	
}
