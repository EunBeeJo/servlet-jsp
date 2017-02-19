<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="EUC-KR" %>
<%@ page import="java.util.Map" %>
<%
    Map<String, Map<String, String>> returnBoardList = (Map<String, Map<String, String>>) request.getAttribute("returnBoardList");
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
<table
<tr align="center" >
    <td width="50px">글번호</td>
    <td width="400px">제목</td>
    <td width="100px">작성자</td>
    <td width="50px">조회수</td>
</tr>
<tr>
    <td colspan="4"><hr></hr></td>
</tr>
<%if(returnBoardList.size() < 1){ %>
<tr>
    <td colspan="4">리스트 없음</td>
</tr>
<%}%>

<%for(int indexI=1; indexI <= returnBoardList.size(); indexI++) {
    Map<String, String> board = returnBoardList.get(Integer.toString(returnBoardList.size()-indexI));
%>
<tr align="center">
    <td><%=board.get("index")%></td>
    <td><a href="./read?index=<%=board.get("index")%>"><%=board.get("title")%></a></td>
    <td><%=board.get("writer")%></td>
    <td><%=board.get("hits")%></td>
</tr>
<tr>
    <td colspan="4"><hr></hr></td>
</tr>
<%}%>

<tr>
    <td colspan="4" align="right">
        <input type="button" value="등록" onclick="location.href='./write_form.jsp'">
    </td>
</tr>
</table>
</body>
</html>