package com.mayeye.board.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.SqlSessionTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mayeye.board.controller.BoardController;
import com.mayeye.board.dto.BoardDTO;
import com.mayeye.board.dto.Criteria;
import com.mayeye.board.dto.SearchCriteria;

@Repository
public class BoardDAOImpl implements BoardDAO {
	
	private static final Logger Logger = LoggerFactory.getLogger(BoardController.class);
	
	@Autowired
	private SqlSessionTemplate sqlSessionTemplate;
	
	public void setSqlMapClient(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
	}
	
	@Override
	public List<BoardDTO> list() {
		return sqlSessionTemplate.selectList("boardDAO.list");
	}
	
	@Override
	public void delete(BoardDTO boardDTO) {
		sqlSessionTemplate.delete("boardDAO.delete", boardDTO);
	}
	
	@Override
	public int update(BoardDTO boardDTO) {
		return sqlSessionTemplate.update("boardDAO.update", boardDTO);
	}
	
	@Override
	public void insert(BoardDTO boardDTO) {
		sqlSessionTemplate.insert("boardDAO.insert", boardDTO);
	}
	
	@Override
	public BoardDTO select(int num) {
		BoardDTO dto = (BoardDTO)sqlSessionTemplate.selectOne("boardDAO.select", num);
		return dto;
	}
	
	@Override
	public int updateReadCount(int num) {
		return sqlSessionTemplate.update("boardDAO.updateCount", num);
	}

	// Criteria 객체에 담아서 SQL 매핑에 보낼 파라미터
	// 특정 페이지 게시글의 행(pageStart)과 페이지당 보여줄 게시글의 갯수(perPageNum)
	@Override
	public List<Map<String, Object>> pageList(Criteria cri) {
		return sqlSessionTemplate.selectList("boardDAO.pageList", cri);
	}

	@Override
	public int countBoardList() {
		return sqlSessionTemplate.selectOne("boardDAO.countBoardList");
	}
	
	// 검색 페이지까지 적용
	@Override
	public List<BoardDTO> searchList(SearchCriteria cri) {
		// 자동 형변환
		return sqlSessionTemplate.selectList("boardDAO.searchList", cri);
	}

	@Override
	public int countArticle(SearchCriteria cri) {
		return sqlSessionTemplate.selectOne("boardDAO.countArticle", cri);
	}

	@Override
	public String boardGetKey(int num) {
		return sqlSessionTemplate.selectOne("boardDAO.boardGetKey", num);
	}

}
