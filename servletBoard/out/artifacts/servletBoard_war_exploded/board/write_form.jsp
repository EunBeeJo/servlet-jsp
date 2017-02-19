<%@ page language="java" contentType="text/html; charset=EUC-KR" pageEncoding="EUC-KR"%>

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
<form action="./write_process" method="post">
    <table border="1">
        <tr>
            <td>제목</td>
            <td><input type="text" id="title" name="title" value="" size="" maxlength=""/> </td>
        </tr>
        <tr>
            <td>작성자</td>
            <td><input type="text" id="writer" name="writer" value="" size="" maxlength="10"/> </td>
        </tr>
        <tr>
            <td>내용</td>
            <td><textarea rows="10" cols="30" name="content"></textarea> </td>
        </tr>
        <tr>
            <td colspan="2" align="right">
                <input type="submit" value="등록">
            </td>
        </tr>
    </table>
</form>

</body>
</html>
