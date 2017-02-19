<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
    String deleteNum = (String)request.getAttribute("deleteNum");
%>


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Title</title>
</head>
<body>
<%=deleteNum%>번 글이 삭제되었습니다.
<input type="button" value="리스트" onClick="location.href='./list'">
<br/>
</body>
</html>
