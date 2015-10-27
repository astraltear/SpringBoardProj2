package com.youngjee.controller;

import javax.inject.Inject;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.youngjee.domain.BoardVO;
import com.youngjee.domain.Hangul;
import com.youngjee.domain.PageMaker;
import com.youngjee.domain.SearchCriteria;
import com.youngjee.service.BoardService;

@Controller
@RequestMapping("/sboard/*")
public class SearchBoardController {
	private static final Logger logger = LoggerFactory.getLogger(SearchBoardController.class);
	
	@Inject
	private BoardService service;
	
	@RequestMapping(value="/list", method=RequestMethod.GET)
	public void listPage(@ModelAttribute("cri") SearchCriteria cri, Model model  ) throws Exception {
		
		logger.info(cri.toString());
		
		model.addAttribute("list", service.listSearchCriteria(cri));
		
		PageMaker pageMaker = new PageMaker();
		pageMaker.setCri(cri);
		pageMaker.setTotalCount(service.listSearchCount(cri));
		
		model.addAttribute("pageMaker", pageMaker);
	}
	
	public void read(@RequestParam("bno") int bno, @ModelAttribute("cri") SearchCriteria cri, Model model ) throws Exception {
		model.addAttribute(service.read(bno));
	}
	
	
	@RequestMapping(value="/removePage", method=RequestMethod.POST)
	public String remove(@RequestParam("bno") int bno, SearchCriteria cri, RedirectAttributes rttr ) throws Exception {
		service.remove(bno);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
		
	}
	
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.GET)
	public void modifyPagingGET(int bno, @ModelAttribute("cri") SearchCriteria cri, Model model) throws Exception{
		model.addAttribute(service.read(bno));
	}
	
	
	@RequestMapping(value="/modifyPage", method=RequestMethod.POST)
	public String modifyPaingPOST(BoardVO board, SearchCriteria cri, RedirectAttributes rttr) throws Exception{
		
		logger.info(cri.toString());
		service.modify(board);
		
		rttr.addAttribute("page", cri.getPage());
		rttr.addAttribute("perPageNum", cri.getPerPageNum());
		rttr.addAttribute("searchType", cri.getSearchType());
		rttr.addAttribute("keyword", cri.getKeyword());
		
		rttr.addFlashAttribute("msg", "SUCCESS");
		
		logger.info(rttr.toString());
		
		return "redirect:/sboard/list";
		
	}
	
	@RequestMapping(value="/register", method=RequestMethod.GET)
	public void registerGET() throws Exception{
		logger.info("register get..........");
	}
	
	@RequestMapping(value="/register", method=RequestMethod.POST)
	public String registerPOST(BoardVO board, RedirectAttributes rttr) throws Exception {
		logger.info("register post............");
		logger.info(board.toString());
		
		service.regist(board);
		
		rttr.addAttribute("msg", "SUCCESS");
		
		return "redirect:/sboard/list";
		
		
	}
	
	
	@RequestMapping(value="/testhangul", method=RequestMethod.GET)
	public void testHangul(@ModelAttribute("t3") Hangul t4,  Model model,HttpServletRequest request) throws Exception{
		
		
		logger.info("getSearchText["+t4.getSearchText()+"]");
		model.addAttribute("han", t4);
		
		/*
han.searchText:테스트	
t3.searchText:테스트	
t4.searchText:	
		 */
	}
	
}
