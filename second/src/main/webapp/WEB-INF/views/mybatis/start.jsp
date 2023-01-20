<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2> 나의 회원관리 프로그램입니다.</h2>
<h4>
<ul>

<li> <a href="<%=request.getContextPath() %>/login"> 로그인 하러가기</a></li>
<li> <a href="<%=request.getContextPath() %>/logout"> 로그아웃 하러가기</a></li>
<li> <a href="<%=request.getContextPath() %>/mybatismemberlist"> 회원리스트 보러가기(로그인x)</a></li>
<li> <a href="<%=request.getContextPath() %>/memberinsert"> 회원가입 하러가기(로그인x)</a></li>
<li> <a href="<%=request.getContextPath() %>/memberinform"> 내정보 보러가기</a></li>
<li> <a href="<%=request.getContextPath() %>/memberdelete"> 회원탈퇴하기</a></li>
<li> <a href="<%=request.getContextPath() %>/boardlist"> 게시판(로그인x))</a></li>

</ul>
</h4>
<%if (session.getAttribute("loginid") !=null){
	out.println("<h3> "+ session.getAttribute("loginid") + " 회원님 환영합니다. </h3>"); 
	} 
	else{
	out.println("<h3> 로그인해주세요. </h3>"); 
	}%>
	
<h5>${!empty result? result : ""}</h5> 
</body>
</html>