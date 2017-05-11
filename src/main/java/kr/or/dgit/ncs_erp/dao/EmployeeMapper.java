package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import kr.or.dgit.ncs_erp.dto.Employee;

public interface EmployeeMapper {
	int selectCountAll();
	List<Employee> selectByAll();
		
	int insertEmployee(Employee employee);
	int deleteEmployee(Employee employee);
	int updateEmployee(Employee employee);
}
