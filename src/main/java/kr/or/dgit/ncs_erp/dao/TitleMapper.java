package kr.or.dgit.ncs_erp.dao;

import java.util.List;

import kr.or.dgit.ncs_erp.dto.Title;

public interface TitleMapper {
	int insertTitle(Title title);
	int deleteTitle(Title title);
	int updateTitle(Title title);
	
	int selectByAllCnt();
	
	Title selectTitleOne(Title title);
	List<Title> selectTitleAll(); 
}