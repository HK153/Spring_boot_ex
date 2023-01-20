<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<style>
	td {
		text-align : center;
	}
	
</style>

</head>
<body>
<!-- html form(파라미터이름) --MemberDTO(프로퍼티이름)--Member테이블(컬럼이름 )저장 -->
<form action="<%=request.getContextPath() %>/memberinsert" method="post" enctype="multipart/form-data">
<table >
<tr> <th colspan="2" text-align="center"><h2>회원가입 폼</h2></th> </tr>
<tr>

	<td>아이디 입력 : </td>
	<td><input type="text" name= "id" required></td>
</tr>
<tr>	
	<td>암호 입력 : </td> 
	<td><input type="password" name= "pw" required></td>
</tr>
<tr>
	<td>이름 입력 : </td>
	<td><input type="text" name= "name"></td>
</tr>
<tr>
	<td>전화번호 입력 :</td> 
	<td><input type="tel" name= "phone"></td>
</tr>
<tr>
	<td>이메일 입력 : </td>
	<td><input type="email" name= "email" required></td>
</tr>
<tr>
	<td>주소 입력 : </td>
	<td> <input type="text" name= "address"></td>
</tr>
<tr>
	<td>파일선택 : </td>
	<td> <input type="file" name="imagefile"></td>
</tr>
<tr>
	
	<td colspan="2"><input type="submit" value="회원가입"> 
	 <input type="reset" value="취소"></td>
<tr>
</table>
</form>



</body>
</html>