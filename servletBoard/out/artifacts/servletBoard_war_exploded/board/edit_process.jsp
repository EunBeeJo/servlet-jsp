<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
    String editNum = (String)request.getAttribute("editNum");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Title</title>
</head>
<body>
<%=editNum%>번 글이 수정되었습니다.
<br/>
<input type="button" value="리스트" onclick="location.href='./list'"/>
</body>
</html>