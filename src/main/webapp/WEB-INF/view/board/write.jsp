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
<h4 class ="center">게시판 입력</h4>
<form class="container"  action="writePro" method="post" enctype="multipart/Form-data">

  <div class="form-group">
    <label for="name">작성자:</label>
    <input type="text" class="form-control" placeholder="Enter name" id="name" name="name">
  </div>
  
  
  <div class="form-group">
    <label for="pwd">비밀번호:</label>
    <input type="password" class="form-control" placeholder="Enter password" id="pwd" name="pass" >
  </div>
  
  
  <div class="form-group">
    <label for="title">제목:</label>
    <input type="text" class="form-control" placeholder="Enter title" id="title" name="title">
  </div>
  
  <div class="form-group">
  <label for="comment">내용:</label>
  <textarea class="form-control" rows="5" id="comment" name="content"></textarea>
</div>

<div class="form-group">
    <label for="file">파일:</label>
    <input type="file" class="form-control" placeholder="Enter file" id="file" name="file1">
  </div>
  
  <button type="submit" class="btn btn-primary">Submit</button>
</form>
</div>
</body>
</html>