
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

<div class="container">
      <div class="input-form-backgroud row">
         <div class="input-form col-md-12 mx-auto">
            <h4 class="mb-3">회원정보</h4>
            <table class="table">
            <tr>   <th>정보</th><th>내용</th> </tr>
            <tr><td>id</td><td>${loginId}</td><tr>
            <tr><td>name</td><td>${loginPw}</td><tr>
            <tr><td>cellPhoneNo</td><td>${cellphoneNo}</td><tr>
            <tr><td>email</td><td>${email}</td><tr>
            <tr><td>nickname</td><td>${nickname}</td><tr>
        	
        	<tr>
        	<td colspan="2" class = "w3-center">
        	<a class = "btn btn-primary"
        	href = "${pageContext.request.contextPath}/member/memberUpdateForm">회원정보수정</a>
           <a class = "btn btn-primary"
        	href = "${pageContext.request.contextPath}/member/memberDeleteForm">회원탈퇴</a>
        	<a class = "btn btn-primary"
        	href = "${pageContext.request.contextPath}/member/memberPassForm">비밀번호수정</a>
           </td>
           </tr>
           
           
            
            </table>
         </div>
      </div>
   
   </div>
</body>
</html>