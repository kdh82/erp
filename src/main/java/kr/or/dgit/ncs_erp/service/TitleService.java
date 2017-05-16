package kr.or.dgit.ncs_erp.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.ncs_erp.MybatisSqlSessionFactory;
import kr.or.dgit.ncs_erp.dao.DepartmentMapper;
import kr.or.dgit.ncs_erp.dao.DepartmentMapperImpl;
import kr.or.dgit.ncs_erp.dao.TitleMapper;
import kr.or.dgit.ncs_erp.dao.TitleMapperImpl;
import kr.or.dgit.ncs_erp.dto.Department;
import kr.or.dgit.ncs_erp.dto.Title;

public class TitleService {
	private static final TitleService instance = new TitleService();

	private TitleService() {
	}

	public static TitleService getInstance() {
		return instance;
	}

	public int insertTitle(Title title) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.insertTitle(title);
			sqlSession.commit();
			return res;
		}
	}

	public int deleteTitle(Title title) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.deleteTitle(title);
			sqlSession.commit();
			return res;
		}
	}

	public int updateTitle(Title title) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			int res = titleMapper.updateTitle(title);
			sqlSession.commit();
			return res;
		}
	}

	public static Title selectTitleOne(Title title) {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectTitleOne(title);

		}
	}
	public List<Title> selectTitleAll() {
		try (SqlSession sqlSession = MybatisSqlSessionFactory.openSession()) {
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectTitleAll();

		}
	}
	public int selectByAllCnt(){
		try(SqlSession sqlSession = MybatisSqlSessionFactory.openSession()){
			TitleMapper titleMapper = new TitleMapperImpl(sqlSession);
			return titleMapper.selectByAllCnt();
		}
	}
}
