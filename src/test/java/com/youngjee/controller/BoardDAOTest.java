package com.youngjee.controller;

import java.util.List;

import javax.inject.Inject;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.web.util.UriComponents;
import org.springframework.web.util.UriComponentsBuilder;

import com.youngjee.domain.BoardVO;
import com.youngjee.domain.Criteria;
import com.youngjee.domain.SearchCriteria;
import com.youngjee.persistence.BoardDAO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/webapp/WEB-INF/spring/**/*.xml"})
public class BoardDAOTest {
	
	@Inject
	private BoardDAO dao;
	
	private static Logger logger = LoggerFactory.getLogger(BoardDAOTest.class);
	
	@Test
	public void  testCreate() throws Exception {
		BoardVO  boardVO = new BoardVO();
		boardVO.setTitle("���ο� ���� �ֽ��ϴ�.");
		boardVO.setContent("���ο� ������ �ֽ��ϴ�.");
		boardVO.setWriter("user00");
		
		dao.create(boardVO);
	}
	
	@Test
	public void testRead() throws Exception {
		logger.info(dao.read(5).toString());
	}
	
	@Test
	public void testDelete() throws Exception {
		dao.delete(4);
	}
	
/*	@Test
	public void testListAll() throws Exception {
		logger.info(dao.listAll().toString());
	}*/
	
	@Test
	public void testListPage() throws Exception {
		int page=3;
		
		List<BoardVO> list = dao.listPage(page);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+"!");
		}
	}
	
	@Test
	public void testListCriteria() throws Exception {
		Criteria cri = new Criteria();
		cri.setPage(2);
		cri.setPerPageNum(40);
		
		List<BoardVO> list = dao.listCriteria(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.toString());
		}
	}
	
	@Test
	public void testURI() throws Exception {
		UriComponents  uriComponents = UriComponentsBuilder.newInstance()
				.path("board/read")
				.queryParam("bno", 10)
				.queryParam("perPageNum", 20)
				.build();
		
		logger.info(uriComponents.toString());
	}
	
	@Test
	public void testURI2()  throws Exception {
		UriComponents uriComponents = UriComponentsBuilder.newInstance()
				.path("/{module}/{page}")
				.queryParam("bno", 10)
				.queryParam("perPageNum", 30)
				.build()
				.expand("board","read")
				.encode();
		
		logger.info(uriComponents.toString());
	}
	
	@Test
	public void testDynamic() throws Exception {
		SearchCriteria cri = new SearchCriteria();
		cri.setPage(1);
		cri.setKeyword("글");
		cri.setSearchType("t");
		
		List<BoardVO> list = dao.listSearch(cri);
		
		for (BoardVO boardVO : list) {
			logger.info(boardVO.getBno()+":"+boardVO.getTitle());
		}
		
		logger.info("COUNT:"+dao.listSeachCount(cri));
	}
	

	
	
}
