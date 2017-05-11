package kr.or.dgit.ncs_erp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.MybatisSqlSessionFactory;
import kr.or.dgit.ncs_erp.dao.DepartmentMapper;
import kr.or.dgit.ncs_erp.dao.DepartmentMapperImpl;
import kr.or.dgit.ncs_erp.dto.Department;

public class TitleService {
	private static final TitleService instance = new TitleService();

	private TitleService() {
	}

	public static TitleService getInstance() {
		return instance;
	}

	public int insertDepartment(Department department) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.insertDepartment(department);
			sqlSession.commit();
			return res;
		}
	}

	public int deleteDepartment(Department department) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.deleteDepartment(department);
			sqlSession.commit();
			return res;
		}
	}

	public int updateDepartment(Department department) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			int res = departmentMapper.updateDepartment(department);
			sqlSession.commit();
			return res;
		}
	}

	public List<Department> selectDepartmentAll() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			return departmentMapper.selectDepartmentAll();

		}
	}

	public List<Department> selectOne() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			DepartmentMapper departmentMapper = new DepartmentMapperImpl(sqlSession);
			return departmentMapper.selectOne();

		}
	}
}
