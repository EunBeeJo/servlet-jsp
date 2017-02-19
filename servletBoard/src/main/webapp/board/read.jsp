<%@ page import="java.util.Map" %>
<%@ page contentType="text/html;charset=EUC-KR" language="java" pageEncoding="EUC-KR"%>
<%
    Map<String, String> returnBoard = (Map<String, String>) request.getAttribute("returnBoard");
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
<p>글번호  <%=returnBoard.get("index")%></p>
<h2><%=returnBoard.get("title")%></h2>
<p>작성자  <%=returnBoard.get("writer")%></p>
<p>조회수  <%=returnBoard.get("hits")%></p>
<p>내용</p>
<p><%=returnBoard.get("content")%></p>

<table>
    <tr>
        <td colspan="6" align="right">

            <input type="button" value="수정" onclick="location.href='./edit_form?index=<%=returnBoard.get("index") %>'"/>
            &nbsp;
            <input type="button" value="삭제" onclick="location.href='./delete?index=<%=returnBoard.get("index") %>'"/>
            &nbsp;
            <input type="button" value="리스트" onclick="location.href='./list'"/>
        </td>

    </tr>
</table>
</body>
</html>
