<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h2> 글 등록 </h2>
<form action="insertBoard" method=post>
<table border="2">

<tr>
	<td> 제목 </td> <td><input type="text" name="title"> </td>
</tr>
<tr>
	<td> 내용 </td> <td> <textarea cols=50 rows=5 name="contents"></textarea>  </td>
</tr>
<tr>
	<td> 작성자 </td> <td><input type="text" name="writer" value= " ${sessionScope.loginid}" readonly> </td>
</tr>

<tr>
	<td colspan="2"> <input type="submit" value="글 등록"> <input type="reset" value="취소"> </td> 
</tr>

</table>
</form>
</body>
</html>