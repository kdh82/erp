package kr.or.dgit.ncs_erp.dao;

import java.util.List;


import kr.or.dgit.ncs_erp.dto.Department;

public interface DepartmentMapper {
	int insertDepartment(Department department);
	int deleteDepartment(Department department);
	int updateDepartment(Department department);
	
	List<Department> selectDepartmentAll();
	List<Department> selectOne(); 
}
