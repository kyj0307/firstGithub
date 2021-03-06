package com.springbook.view.board;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.Controller;

import com.springbook.biz.board.BoardVO;
import com.springbook.biz.board.impl.BoardDAO;

public class GetBoardListController implements Controller {

	@Override
	public ModelAndView handleRequest(HttpServletRequest request, HttpServletResponse response) {
		System.out.println("글 목록 검색 처리");
		
		// 1. 사용자 입력 정보 추출(검색기능 은 나중에 구현)
		// 2. DB연동처리
		BoardVO vo = new BoardVO();
		BoardDAO boardDAO = new BoardDAO();
		List<BoardVO> boardList = boardDAO.getBoardList(vo);
		
		// 3. 검색 결과와 화면 정보를 ModelAndView 에 저장하여 리턴
		ModelAndView mav = new ModelAndView();
		mav.addObject("boardList", boardList); // model 정보 저장
		mav.setViewName("getBoardList"); // view 정보 저장
		
		return mav;
	}

}
