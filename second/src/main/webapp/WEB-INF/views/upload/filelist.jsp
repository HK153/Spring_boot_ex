<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h2>다운로드 목록을 보여드립니다.</h2>
<%
String [] filelist =(String[]) request.getAttribute("filelist");
for (String filename: filelist){
	out.println("<h4> <a href= 'filedownload?onefile="+filename+"'>" + filename + "</a></h4>");
}
%>

</body>
</html>