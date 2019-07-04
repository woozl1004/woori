package kr.co.woozl.hr.emp.applicationService;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import kr.co.woozl.hr.emp.dao.EmployeeDAO;
import kr.co.woozl.hr.emp.to.EmployeeTO;

@Component
public class EmpApplicationServiceImpl implements EmpApplicationService{

	@Autowired
	private EmployeeDAO employeeDAO;
	

	@Override
	public List<EmployeeTO> findEmployeeList() {
		// TODO Auto-generated method stub
		return employeeDAO.selectEmployeeList();
	}

	@Override
	public void batchEmployee(List<EmployeeTO> employeeList) {
		// TODO Auto-generated method stub
		
		for(EmployeeTO employeeTO : employeeList) {

			switch(employeeTO.getStatus()) {

			case "insert" : employeeDAO.insertEmployee(employeeTO); break;
			case "update" : employeeDAO.updateEmployee(employeeTO); break;
			case "delete" : employeeDAO.deleteEmployee(employeeTO); break;

			}
		}
	}
	
}
