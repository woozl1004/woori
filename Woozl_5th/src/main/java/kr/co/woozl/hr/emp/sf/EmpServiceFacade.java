package kr.co.woozl.hr.emp.sf;

import java.util.List;

import kr.co.woozl.hr.emp.to.EmployeeTO;

public interface EmpServiceFacade {

	public List<EmployeeTO> findEmployeeList();
	
	public void batchEmployee(List<EmployeeTO> employeeList);
	
}
