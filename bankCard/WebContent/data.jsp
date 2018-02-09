<%@page import="com.bankCard.action.bankQueryAtion"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String src = request.getParameter("src");
	String filePath = request.getRealPath("/") + src;
	String result = bankQueryAtion.getIDInfo(filePath);
	out.print(result);//显示在结果界面
%>
