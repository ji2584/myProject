<%@page import="dao.MemberDao"%>
<%@page import="model.Member"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
   
  <%MemberDao md = new MemberDao();
Member mem = md.oneMember(login);

%>
  
     
        <!-- Section-->
      <div><br><br><br>
        <form action="memberUpdatePro" method="POST" class="joinForm" onsubmit="DoJoinForm__submit(this); return false;">                                                                                     
      <h2>회원정보 수정</h2>
      <div class="textForm">
        <input name="loginId" value="${mem.loginId }" readonly type="text" class="id" placeholder="아이디"/>
      
      </div>
      <div class="textForm">
        <input name="loginPw"  type="password" class="pw" placeholder="비밀번호">
      </div>
       <div class="textForm">
        <input name="loginPwConfirm" type="password" class="pw" placeholder="비밀번호 확인">
      </div> 
      
      <div class="textForm">
        <input name="name" value="${mem.name}" type="text" class="name" placeholder="이름">
      </div>
       <div class="textForm">
        <input name="email" value="${mem.email }"type="text" class="email" placeholder="이메일">
      </div>
      <div class="textForm">
        <input name="nickname" value="${mem.nickname }" type="text" class="nickname" placeholder="닉네임">
      </div>
      <div class="textForm">
        <input name="cellphoneNo" value="${mem.cellphoneNo}" type="number" class="cellphoneNo" placeholder="전화번호">
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