<%@page import="dao.MemberDao"%>
<%@page import="model.MyBoard"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
 
     
        <!-- Section-->
      <div><br><br><br>
        <form action="boardUpdatePro" method="POST" class="joinForm" enctype="multipart/form-data">     
        <input type = "hidden" name = "num" value="${MyBoard.num}">
        <input type = "hidden" name = "originfile" value="${MyBoard.file1}">                                                                                
      <h2>게시판 수정</h2>
      <div class="textForm">
    
       <input type="text" class="form-control" placeholder="글쓴이" id="name" name="name" value="${Myboard.name}">
      
      </div>
      <div class="textForm">
      
        <input type="password" class="form-control" placeholder="비밀번호" id="pass" name="pass">
      </div>
       <div class="textForm">
  
       <input type="text" class="form-control" placeholder="제목" id="title" name="title">
      </div> 
      
      <div class="textForm">
    
       <textarea class="form-control" rows="5" id="content" name="content" placeholder="내용을 입력하세요" ></textarea>
      </div>
       <div class="textForm">
       <label for="file1">파일:</label>
       <input type="file" class="form-control" id="file" name="file1">
      </div>
      
      <input type="submit" class="btn" value="수정 완료"/>
    </form> 
    </div>
 <br><br><br><br><br><br><br><br><p>
        <!-- Footer-->
      <div>
       
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        <script src="js/scripts.js"></script></div>
     </body>
</html>