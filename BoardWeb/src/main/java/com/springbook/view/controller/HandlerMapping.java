package com.springbook.view.controller;

import java.util.HashMap;
import java.util.Map;

import com.springbook.view.board.DeleteBoardController;
import com.springbook.view.board.GetBoardController;
import com.springbook.view.board.GetBoardListController;
import com.springbook.view.board.InsertBoardController;
import com.springbook.view.board.LogoutController;
import com.springbook.view.board.UpdateBoardController;
import com.springbook.view.user.LoginController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
	
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/login.do", new LoginController());
		
		// getBoardList Mapping()
		mappings.put("/getBoardList.do", new GetBoardListController());
		
		// getBoard Mapping()
		mappings.put("/getBoard.do", new GetBoardController());
		
		// InsertBoard Mapping()
		mappings.put("/insertBoard.do", new InsertBoardController());
		
		// UpdateBoard Mapping()
		mappings.put("/updateBoard.do", new UpdateBoardController());
		
		// DeleteBoard Mapping()
		mappings.put("/deleteBoard.do", new DeleteBoardController());
		
		// Logout Mapping()
		mappings.put("/logout.do", new LogoutController());
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
