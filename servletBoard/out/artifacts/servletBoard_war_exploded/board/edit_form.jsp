<%@ page import="java.util.Map" %>
<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>
<%
    Map<String, String> board = (Map<String, String>)request.getAttribute("editBoard");
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
    <title>Title</title>
    <style type="text/css">
        .al_cen {
            text-align: center;
        }
    </style>
</head>
<body>
<form action="./edit_process" method="post">
    <table border="1">
        <tr>
            <td>글번호</td>
            <td><input type="text" name="index" value=<%=board.get("index")%> readonly /> </td>
        </tr>
        <tr>
            <td>제목</td>
            <td><input type="text" name="title" value=<%=board.get("title")%> readonly /> </td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" name="writer" value=<%=board.get("writer")%> readonly /> </td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea rows="10" cols="30" name="content" value=<%=board.get("content")%>></textarea> </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="수정">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
