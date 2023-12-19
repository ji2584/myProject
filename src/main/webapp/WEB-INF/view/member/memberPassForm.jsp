<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <script>

function passChk(form){
	
	
	if(form.loginPw.value==""){
		alert("loginPw")
		form.loginPw.focus() 
		return false
		
	} 
	if(form.chgpass.value==""){
		alert("chgpass")
		form.chgpass.focus()
		return false
		
	} 
	if(form.chgpass1.value==""){
		alert("비밀번호확인을 하세요")
		form.chgpass1.focus()
		return false
	}
	
	
	
	if(form.chgpass.value !==form.chgpass1.value){
		alert("변경 비밀번호와 재입력 번호가 다릅니다.")
		form.chgpass1.value="";
		form.chgpass1.focus()
		return false
		
	}
	return true;
	
}



</script>

        <!-- Page header with logo and tagline-->
        <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">신라호텔에 오신 걸 환영합니다!</h1>
                    <p class="lead mb-0">국내 최고 럭셔리 호텔인 호텔신라는 신라호텔과 신라스테이 브랜드를 보유하고 있습니다.</p>
                </div>
            </div>
        </header>
        	 <form class="validation-form" novalidate    action="memberPassPro" onsubmit="return passChk(this)" method="post">
       <div class="row">
                        
                          
                    <div class="main">
                 	
    <p class="sign" align="center">비밀번호 변경</p>
        <input class="pass "  type="password" align="center" name="loginPw"  placeholder="현재비밀번호">
        
             <input class="pass" type="password" align="center" name="chgpass" placeholder="변경비밀번호">
             
             <input class="pass" type="password" align="center" name="chgpass1" placeholder="변경비밀번호 확인">
      <input type="submit" class="submit"  align="center" value = "변경 완료"></a>
      <p class="forgot" align="center"><a href="#">비밀번호를 잊으셨나요?</p>
      </form>      
                
    </div>
                   
           </div>
        <!-- Footer-->
        <footer class="py-5 bg-dark">
            <div class="container"><p class="m-0 text-center text-white">Copyright &copy; Your Website 2023</p></div>
        </footer>
        <!-- Bootstrap core JS-->
        <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script>
        <!-- Core theme JS-->
        
    </body>
</html>
