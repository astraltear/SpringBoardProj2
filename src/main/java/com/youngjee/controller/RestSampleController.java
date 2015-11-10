package com.youngjee.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.youngjee.domain.SampleVO;

@RestController
@RequestMapping("/restsample/")
public class RestSampleController {

	@RequestMapping("/hello")
	public String sayHello() {
		return "Hello World";
	}

	@RequestMapping("/sendVO")
	public SampleVO sendVO() {
		SampleVO vo = new SampleVO();
		vo.setFirstName("홍");
		vo.setLastName("길동");
		vo.setMno(123);
		
		return vo;
	}
	
	@RequestMapping("/sendList")
	public List<SampleVO> sendList(){
		List<SampleVO> list = new ArrayList<>();
		
		for (int i = 0; i < 10; i++) {
			SampleVO sampleVO = new SampleVO();
			sampleVO.setFirstName("John");
			sampleVO.setLastName("Smith");
			sampleVO.setMno(i);
			
			list.add(sampleVO);
		}
		
		return list;
	}
	
	@RequestMapping("/sendMap")
	public Map<Integer, SampleVO> sendMap(){
		
		Map<Integer, SampleVO> map = new HashMap<>();
		
		for (int i = 0; i < 10; i++) {
			SampleVO vo = new SampleVO();
			vo.setFirstName("Choi");
			vo.setLastName("YoungJee");
			vo.setMno(i);
			
			map.put(i, vo);
		}
		
		return map;
 	}
	
	@RequestMapping("/sendErrorAuth")
	public ResponseEntity<Void> sendListAuth(){
		return new ResponseEntity<>(HttpStatus.BAD_REQUEST)	;
	}
	
	@RequestMapping("/sendErrorNot")
	public ResponseEntity<List<SampleVO>> sendListNot(){
		
		List<SampleVO> list = new ArrayList<>();
		for (int i = 0; i < 10; i++) {
			SampleVO sampleVO = new SampleVO();
			sampleVO.setFirstName("kil dong");
			sampleVO.setLastName("HOng");
			sampleVO.setMno(i);
			
			list.add(sampleVO);
		}
		
		return new ResponseEntity<>(list,HttpStatus.NOT_FOUND);
	}
	
}
