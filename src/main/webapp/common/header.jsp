<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    
 <head>
        <meta charset="utf-8" />
        <meta name="viewport" content="width=device-width, initial-scale=1">
  <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/css/bootstrap.min.css">
  <script src="https://cdn.jsdelivr.net/npm/jquery@3.7.1/dist/jquery.slim.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.1/dist/umd/popper.min.js"></script>
  <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.6.2/dist/js/bootstrap.bundle.min.js"></script>
     <!-- Bootstrap core JS-->
     <!--    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.2.3/dist/js/bootstrap.bundle.min.js"></script> -->
        <!-- Core theme JS-->
        <!-- <script src="js/scripts.js"></script> -->
        <title>homepage</title>
        <!-- Favicon-->
        <link rel="icon" type="image/x-icon" href="<%=request.getContextPath()%>/assets/favicon.ico" />
        <!-- Core theme CSS (includes Bootstrap)-->
        <link href="../css/styles.css" rel="stylesheet" />
         <link href="../css/style2.css" rel="stylesheet" />
         <link href="../css/board.css" rel="stylesheet" />
         <link href="../css/membership.css" rel="stylesheet" />
  
    
    </head>

    <body>
        <!-- Responsive navbar-->
        <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
            <div class="container">
                <a class="navbar-brand" href="homepage">신라호텔</a>
                <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation"><span class="navbar-toggler-icon"></span></button>
                <div class="collapse navbar-collapse" id="navbarSupportedContent">
       <ul class="navbar-nav ms-auto mb-2 mb-lg-0">

             
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/homepage">Home</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/board">게시판</a></li>
                       
  <c:if test = "${sessionScope.loginId == null}">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/loginForm">로그인</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberinput">회원가입</a></li>
                        <li class= "nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/loginForm" >객실예약</a></li>
               </c:if>
               <c:if test = "${sessionScope.loginId != null}">
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/logout">로그아웃</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/memberinfo">${loginId}&nbsp;&nbsp;회원정보</a></li>
                        <li class="nav-item"><a class="nav-link" href="${pageContext.request.contextPath}/member/reservationinput" >객실예약</a></li>
                  </c:if>
                    </ul>
                </div>
            </div>
        </nav>
        
        
        
       
        