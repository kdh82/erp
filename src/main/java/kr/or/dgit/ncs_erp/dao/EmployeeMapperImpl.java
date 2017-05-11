package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import org.apache.ibatis.logging.Log;
import org.apache.ibatis.logging.LogFactory;
import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.dto.Employee;

public class EmployeeMapperImpl implements EmployeeMapper {
	protected String namespace = "kr.or.dgit.ncs_erp.dao.EmployeeMapper.";
	private static final Log log = LogFactory.getLog(EmployeeMapper.class);
	private SqlSession sqlSession;

	public EmployeeMapperImpl(SqlSession sqlSession) {
		this.sqlSession = sqlSession;
	}

	@Override
	public int selectCountAll() {
		log.debug("selectCountAll()");
		return sqlSession.selectOne(namespace + "selectCountAll");
	}

	@Override
	public List<Employee> selectByAll() {
		log.debug("selectByAll()");
		return sqlSession.selectList(namespace + "selectByAll");
	}

	@Override
	public int insertEmployee(Employee employee) {
		log.debug("insertAllEmployee()");
		return sqlSession.insert(namespace + "insertAllEmployee", employee);
	}

	@Override
	public int deleteEmployee(Employee employee) {
		log.debug("deleteEmployee()");
		return sqlSession.delete(namespace + "deleteEmployee", employee);
	}

	@Override
	public int updateEmployee(Employee employee) {
		log.debug("updateEmployee()");
		return sqlSession.update(namespace + "updateEmployee", employee);
	}

}
