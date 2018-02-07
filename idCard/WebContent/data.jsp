<%@page import="com.idCard.action.IDQueryAction"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>

<%
	String src = request.getParameter("src");
	String filePath = request.getRealPath("/") + src;
	String result = IDQueryAction.getIDInfo(filePath);
	out.print(result);//显示在结果界面
%>
