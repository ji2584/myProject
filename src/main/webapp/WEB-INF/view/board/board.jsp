<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
  
<!DOCTYPE html>
  
  <body>    <!-- Section-->
      <section> 
                <h2> ${boardName} </h2>
 
<hr class ="hr1" noshade> 

<form>
  <span class="right">
    <span class="grey" id="strong">SELECT</span>
    <select id="searchOption">
      <option value="title">제목</option>
      <option value="name">작성자</option>
    </select>
    <input type="text" id="searchText">
    <input type="button" name="검색" class="gradient" value="검색" onclick="performSearch()">
  </span>
</form>
<table height="40%">
   <thead>
      <tr>
        <th>번호</th>
        <th>작성자</th>
        <th>제목</th>
        <th>날짜</th>
        <th>조회수</th>
        <th>파일</th>
      </tr>
    </thead>
    <tbody>
    <c:forEach var="b" items="${li}">  
      <tr>
        <td>${b.num}</td>
        <td>${b.name}</td>
        <td><a href="boardinfo?num=${b.num}">${b.title}</a></td>
        <td>${b.regdate}</td>
        <td>${b.readcnt}</td>
        <td>${b.file1}</td>
      </tr>
      </c:forEach>  
    </tbody>
</table>
</br>

<ul class="pagination justify-content-center text-center">
  <li class="page-item <c:if test="${start<=bottomLine}"> disabled  </c:if> ">
    <a class="page-link" href="${pageContext.request.contextPath}/board/board?pageNum=${start-bottomLine}">Previous</a></li>
  
  <c:forEach var = "p" begin ="${start}" end="${end}">
 
  <li class="page-item <c:if test="${pageInt==p}"> active  </c:if>"><a class="page-link" 
       href="${pageContext.request.contextPath}/board/board?pageNum=${p}">${p}</a></li>
  </c:forEach>
 
  <li class="page-item <c:if test="${end>=maxPage}"> disabled  </c:if>"> <a class="page-link" href="${pageContext.request.contextPath}/board/boardt?pageNum=${start+bottomLine}">Next</a></li>
</ul>

<span class="right">
  <a href="write"><input type="button" value="글쓰기" class="gradient"></a>
</span>                
        </section>
    </body>
</html>