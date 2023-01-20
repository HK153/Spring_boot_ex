<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 선택한 게시물 정보는 다음과 같습니다.</h2>

<form action="${submitUrl}">
<table border="2">
<tr>
	<td> 번호 </td> <td> ${board.seq} </td>
</tr>
<tr>
	<td> 제목 </td> <td><input type="text" value= "${board.title}"> </td>
</tr>
<tr>
	<td> 내용 </td> <td> <textarea cols=50 rows=5> ${board.contents}</textarea>  </td>
</tr>
<tr>
	<td> 작성자 </td> <td><input type="text" value= " ${board.writer}" readonly> </td>
</tr>
<tr>
	<td> 조회수 </td> <td> ${board.viewcount} </td>
</tr>
<%-- <tr>
	<td> 작성시간 </td> <td> ${board.writingtime} </td>
</tr> --%>
<tr>
	<td colspan="2"> <input type="submit" value="수정 버튼"> <input type="submit" value="삭제 버튼"> </td> 
</tr>

</table>
</form>

</body>
</html>