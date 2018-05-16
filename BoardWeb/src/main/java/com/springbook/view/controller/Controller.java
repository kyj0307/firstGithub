package com.springbook.view.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface Controller {
	String handleRequest(HttpServletRequest request, HttpServletResponse response);
}
/*
   클라이언트의 요청을 받은 DispatcherServlet 은 HandleMapping 을 통해
  Controller 객체를 검색하고 검색된 Controoer 를 실행한다 이때
   어떤 Controller 객체가 검색되더라도 같은 코드로 실행하려면 모든 Controller 의 최상위 인터페이스가 필요
 */
 