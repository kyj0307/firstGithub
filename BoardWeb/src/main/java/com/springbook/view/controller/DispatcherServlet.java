package com.springbook.view.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



public class DispatcherServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private HandlerMapping handlerMapping;
	private ViewResolver viewResolver;
	
	// init()메소드 재정의 서블릿객체가 생성된후 멤버변수를 초기화하기위해
	// 자동으로 실행된다.
	public void init() throws ServletException{
		handlerMapping = new HandlerMapping();
		viewResolver = new ViewResolver();
		viewResolver.setPrefix("./");
		viewResolver.setSuffix(".jsp");
	}
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request,response);
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		process(request,response);
	}
	private void process(HttpServletRequest request, HttpServletResponse response)throws IOException{
		// 1. 클라이언트의 요청 path 에 따라 적절히 분기 처리한다.
		String uri = request.getRequestURI();
		String path = uri.substring(uri.lastIndexOf("/"));
		System.out.println(path);
		
		// 2. HandlerMapping통해 path 에 해당하하는 Controller 를 검색
		Controller ctrl = handlerMapping.getController(path);
		
		// 3. 검색된 controller 를 실행한다.
		String viewName = ctrl.handleRequest(request, response);
		
		// 4. viewResolver 를 통행 viewName 에 해당 하는 화면을 검색 한다
		String view = null;
		if(!viewName.contains(".do")) {
			view = viewResolver.getView(viewName);
		}else {
			view = viewName;
		}
		// 검색된 화면으로 이동
		response.sendRedirect(view);
			
		}
	}