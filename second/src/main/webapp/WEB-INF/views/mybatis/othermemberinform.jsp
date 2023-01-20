<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<h3> ${otherinform.name }님의 정보입니다. (관리자만 허용)</h3>
<h5>아이디 : ${otherinform.id } <br> </h5>
<h5>이메일 : ${otherinform.email } <br> </h5>
<h5>폰번호 : ${otherinform.phone } <br> </h5>
<h5>주소 : ${otherinform.address } <br> </h5>
<h5>사진 : <img src="/upload/${otherinform.image }"> <br> </h5>

<script>
alert('${result}');
</script>

</body>
</html>