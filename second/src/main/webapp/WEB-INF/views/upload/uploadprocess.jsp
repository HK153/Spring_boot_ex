<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>파일 업로드 결과</h3>
<h5>작성자 : ${dto.name }</h5> 
<h5>설명 : ${dto.description }</h5> 
<h5>업로드 파일명 1 : ${dto.file1.originalFilename }</h5> 
<h5>업로드 파일명 2 : ${dto.file2.originalFilename }</h5> 
<h5> c: /upload 폴더에 저장했습니다. </h5>
</body>
</html>