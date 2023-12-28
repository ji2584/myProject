<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%><!DOCTYPE html>
<head>
<style>
/* 전체 폼 스타일 */
.reservationForm {
  width: 400px;
  margin: 0 auto;
  padding: 20px;
  border: 1px solid #ccc;
  border-radius: 8px;
  background-color: #f9f9f9;
}

/* 입력 필드 스타일 */
.reservationForm input[type="text"],
.reservationForm input[type="date"]
.reservationForm input[type="time"],
.reservationForm select {
  width: calc(100% - 20px);
  padding: 10px;
  margin-bottom: 15px;
  border: 1px solid #ddd;
  border-radius: 4px;
}

/* 버튼 스타일 */
.reservationForm button {
  width: 100%;
  padding: 10px;
  border: none;
  border-radius: 4px;
  background-color: #007bff;
  color: #fff;
  cursor: pointer;
}

/* 버튼 호버 효과 */
.reservationForm button:hover {
  background-color: #0056b3;
}
</style>
    <meta charset="UTF-8">
    <title>예약 프로그램</title>
  </head>
<body>
    <h1 align="center">예약 프로그램</h1>
    
    <form id="reservationForm" class="reservationForm">
        <label for="name">이름:</label>
        <input type="text" id="name" name="name"><br><br>
        
        <label for="date">날짜:</label>
        <input type="date" id="date" name="regdate"><br><br>
        
        <label for="time">시간:</label>
        <input type="time" id="time" name="regtime"><br><br>
        
        
        <button type="submit">예약하기</button>
    </form>

    <div id="reservationStatus"></div>

    <script>
        document.getElementById('reservationForm').addEventListener('submit', function(event) {
            event.preventDefault();
            
            // 여기에 예약 정보를 처리하는 JavaScript 코드를 추가하세요
            // 예를 들어, 서버로 데이터를 전송하여 예약을 저장하는 등의 작업을 수행합니다
            
            // 이 부분에는 백엔드 코드가 필요하며, 예약을 처리하고 상태를 반환합니다
            // 그 결과를 아래와 같이 표시합니다
            document.getElementById('reservationStatus').innerText = '예약이 완료되었습니다!';
        });
    </script>
</body>
</html>