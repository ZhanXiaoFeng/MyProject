<%@page import="com.drivingCard.controller.QueryService"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%
	String src = request.getParameter("src");
	String filePath = request.getRealPath("/") + src;
	String result = QueryService.getIDInfo(filePath);
	out.print(result);
%>
