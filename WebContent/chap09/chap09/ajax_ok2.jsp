<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page contentType="text/html; charset=UTF-8"%>
<%
	//클라이언트로부터 요청값 확인
	request.setCharacterEncoding("UTF-8"); 
	String userId = request.getParameter("userId");
	String userPwd = request.getParameter("userPwd");
	
	StringBuilder sb = new StringBuilder("{");
	sb.append(String.format("\"userId\":\"%s\"", userId));
	sb.append(",");
	sb.append(String.format("\"userPwd\":\"%s\"", userPwd));
	sb.append("}");
	
	//클라이언트에 응답
	out.print(sb.toString());
	System.out.println(sb);
%>