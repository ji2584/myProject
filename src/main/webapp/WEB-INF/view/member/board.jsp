<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

                  <header class="py-5 bg-light border-bottom mb-4">
            <div class="container">
                <div class="text-center my-5">
                    <h1 class="fw-bolder">신라호텔에 오신 걸 환영합니다!</h1>
                    <p class="lead mb-0">국내 최고 럭셔리 호텔인 호텔신라는 신라호텔과 신라스테이 브랜드를 보유하고 있습니다.</p>
                </div>
            </div>
        </header>
    <h2> 게시판 </h2>

<hr class ="hr1" noshade> 

<form>
<span> ▷ 총 3개의 게시물이 있습니다. </span>
<span class="right";> 
            <span class="grey"; id="strong";>SELECT</span>
    <select>
    <option value="제목"; name="제목"; >제목</option>
    <option value="글쓴이";name="글쓴이";>글쓴이</option>
    </select>
<input type="text";> <input type="button" name="검색" class="gradient" value="검색" >
</span>
</form>

<br>
<table>
    <tr>
        <th>번호</th>
        <th>제목</th>
        <th>글쓴이</th>
        <th>일시</th>
        <th>조회수</th>
    </tr>
    <tr>
        <td class="center">1</td>
        <td class="left">게시글 1 입니다.</td>
        <td class="center">김준석</td>
        <td class="center">2022-05-18</td>
        <td class="center">15</td>   
    </tr>
    <tr>
        <td class="center">2</td>
        <td class="left">게시글 2 입니다.</td>
        <td class="center">김준석</td>
        <td class="center">2022-05-18</td>
        <td class="center">15</td>   
    </tr>
    <tr>
        <td class="center">3</td>
        <td class="left">게시글 3 입니다.</td>
        <td class="center">김준석</td>
        <td class="center">2022-05-18</td>
        <td class="center">15</td>   
    </tr>
</table>
</br>

<div class="center" >
    <a href  = "https://www.naver.com/">◀ 이전</a> 
    <a href  = "https://www.naver.com/">1</a>  
    <a href  = "https://www.naver.com/">다음 ▶</a>
</div>

<span class="right";>
<input type="button" value="목록" class="greylist";>
<input type="button" value="글쓰기"  class="gradient";>
</span>



              
                            
                    <!-- Search widget--> <!-- 회원가입 대체 탭 -->
                  
                   
           
       
        <script src="js/scripts.js"></script>
    </body>
</html>