<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="<%=request.getContextPath() %>/resources/js/jquery-3.6.1.min.js"></script>
<script>
$(document).ready(function(){
	$("#form").on("submit",function(e){
	if ($("#pw").val() != $("[name=pw2]").val()){
		$("#result").html("<h4>암호가 일치하지 않습니다.</h4>");
		e.preventDefault();
		}
	})
});

</script>
</head>
<body>


<form action="<%=request.getContextPath()%>/memberupdate" method="post" id="form"> 
<table >
<tr> <th colspan="2" text-align="center"><h2> 내 정보 </h2></th> </tr>
<tr>

	<td>아이디 : </td>
	<td><input type="text" name= "id" value="${ dto.id }" readonly></td>
</tr>
<tr>	
	<td>암호 : </td> 
	<td><input type="password" name= "pw" id="pw" required></td>
</tr>
<tr>	
	<td>암호 확인 : </td> 
	<td><input type="password" name= "pw2" id="pw2" required></td>
</tr>
<tr>
	<td>이름 : </td>
	<td><input type="text" name= "name" value="${ dto.name}"></td>
</tr>
<tr>
	<td>전화번호 :</td> 
	<td><input type="tel" name= "phone" value="${ dto.phone}" patten="010[0-9]{8}"></td>
</tr>
<tr>
	<td>이메일 : </td>
	<td><input type="email" name= "email" value="${ dto.email}" required></td>
</tr>
<tr>
	<td>주소 : </td>
	<td> <input type="text" name= "address" value="${dto.address}"></td>
<tr>
<tr>
	
	<td colspan="2"><input type="submit" value="내 정보 수정">
	 <input type="reset" value="취소"></td>
<tr>
</table>

</form>

<div id ="result"></div>
</body>
</html>