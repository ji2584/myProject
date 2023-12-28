package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.Date;
import javax.servlet.http.HttpServletRequest;


import model.Comment;
import model.MyBoard;


public class MyBoardDao {
   public Connection getConnection() {
         Connection conn = null;
         PreparedStatement pstmt = null;

         try {
            Class.forName("oracle.jdbc.OracleDriver");
            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kic", "1111");
            return conn;
         } catch (ClassNotFoundException e) {

            e.printStackTrace();
         } catch (SQLException e) {

            e.printStackTrace();
         }

         return null;
      }
   
   public int insertBoard(MyBoard board) throws UnsupportedEncodingException, SQLException {
       
	      Connection conn = getConnection();
	      
	         PreparedStatement pstmt = conn.prepareStatement("insert into MyBoard "
	        		  + "values (boardseq.nextval,?,?,?,?,?,sysdate,0,?)");
	         //mapping
	         pstmt.setString(1,board.getName());
	         pstmt.setString(2,board.getPass());
	         pstmt.setString(3,board.getTitle());
	         pstmt.setString(4,board.getContent());
	         pstmt.setString(5,board.getFile1());
	         pstmt.setString(6,board.getBoardid());
	         //4)excute
	         int num = pstmt.executeUpdate();
	         return num;
	                  
	   }
   
   public int boardCount(String boardid) throws UnsupportedEncodingException, SQLException {
		 
		 Connection conn = getConnection();       
       PreparedStatement pstmt = conn.prepareStatement("select nvl (count(*),0) from Myboard where boardid = ?");
       pstmt.setString(1, boardid);
		 ResultSet rs = pstmt.executeQuery();
		 if(rs.next()) {
			 return rs.getInt(1);
		 }
         return 0;
}
   
   public List<MyBoard> board(int pageInt, int limit, String boardid) throws UnsupportedEncodingException, SQLException {
		 
		 Connection conn = getConnection();
       String sql = " select * from( "
       		+ " select rownum rnum, a.* from ( "
       		+ " select * from Myboard where boardid = ? "
       		+ " order by num desc) a) "
       		+ " where rnum between ? and ? ";
       PreparedStatement pstmt = conn.prepareStatement(sql);
       pstmt.setString(1, boardid);// 분류
       pstmt.setInt(2, (pageInt-1)*limit+1);// start  
       pstmt.setInt(3, (pageInt*limit));// end    
       
		ResultSet rs = pstmt.executeQuery();
		List<MyBoard> li = new ArrayList<>();
		while(rs.next()) {
			MyBoard m = new MyBoard();
			m.setNum(rs.getInt("num"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setTitle(rs.getString("title"));
			m.setContent(rs.getString("content"));
			m.setFile1(rs.getString("file1"));
			m.setRegdate(rs.getDate("regdate"));
			m.setReadcnt(rs.getInt("readcnt"));
			m.setBoardid(rs.getString("boardid"));
			
			li.add(m);
		}
		return li;
	 }
   
   public MyBoard oneBoard(int num) throws UnsupportedEncodingException, SQLException {
		 
       Connection conn = getConnection();         
       PreparedStatement pstmt = conn.prepareStatement("select * from Myboard where num = ?");				
		pstmt.setInt(1, num);
		ResultSet rs = pstmt.executeQuery();
		MyBoard m = new MyBoard();
		
		if(rs.next()) {			
			m.setNum(rs.getInt("num"));
			m.setPass(rs.getString("pass"));
			m.setName(rs.getString("name"));
			m.setTitle(rs.getString("title"));
			m.setContent(rs.getString("content"));
			m.setFile1(rs.getString("file1"));
			m.setRegdate(rs.getDate("regdate"));
			m.setReadcnt(rs.getInt("readcnt"));
			m.setBoardid(rs.getString("boardid"));
	 }
		return m;
}
   public int updateBoard(MyBoard board) throws UnsupportedEncodingException, SQLException {
     	
	      Connection conn = getConnection();        
	         String sql = 
	         "update MyBoard set name=?,title=?,content=?,file1=?" + "where num =?";
	          PreparedStatement pstmt = conn.prepareStatement(sql);
	         //mapping
          pstmt.setString(1,board.getName());
          pstmt.setString(2,board.getTitle());
          pstmt.setString(3,board.getContent());
          pstmt.setString(4,board.getFile1());             
          pstmt.setInt(5,board.getNum());
          //4)excute
          int num = pstmt.executeUpdate();
          return num;
	                  
	   }
	  
	  public int boardDelete(int num) throws UnsupportedEncodingException, SQLException {
     	
       Connection con = getConnection();
       PreparedStatement pstmt = null;
       String sql = "delete from MyBoard where num =?";    
       pstmt = con.prepareStatement( sql );
       pstmt.setInt(1,num);
       return pstmt.executeUpdate();
                   
    }
	  public List<Comment> commentList(int num) throws SQLException {
			 Connection con = getConnection();
	         PreparedStatement pstmt =
	        		 con.prepareStatement("select * from myboardcomment where num=? order by regdate desc");
	         pstmt.setInt(1, num);
	         ResultSet rs = pstmt.executeQuery();
	         List<Comment> i = new ArrayList<Comment>();
	         while(rs.next()) {
	        	 Comment c = new Comment();
	        	 c.setNum(rs.getInt("num"));
	        	 c.setContent(rs.getString("content"));
	        	 i.add(c);
	        	 
	         }
	         return i;
		}

	 public int insertComment(String comment, int num) throws UnsupportedEncodingException, SQLException {
        	
          Connection con = getConnection();
          PreparedStatement pstmt = null;
          String sql = "insert into myboardcomment values (myboardcomseq.nextval,?,?,sysdate)";    
          pstmt = con.prepareStatement( sql );
          pstmt.setInt(1,num);
          pstmt.setString(2,comment);
          return pstmt.executeUpdate();
                      
       }

	public static List<BoardItem> searchBoard(String searchOption, String searchText) {
		
		        List<BoardItem> boardItems = new ArrayList<>();

		        Connection conn = null;
		        PreparedStatement pstmt = null;
		        ResultSet rs = null;

		        try {
		            // JDBC 드라이버 로드
		            Class.forName("oracle.jdbc.OracleDriver");
		            conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "kic", "1111");

		            // 쿼리 작성 (간단한 예시 - 검색 조건에 따라 쿼리를 조정해야 함)
		            String query = "SELECT * FROM Myboard WHERE title=? ";
		            if (searchOption.equals("title")) {
		                query += "title LIKE ?";
		            } else if (searchOption.equals("name")) {
		                query += "name LIKE ?";
		            }

		            pstmt = conn.prepareStatement(query);
		            pstmt.setString(1, "%" + searchText + "%");

		            rs = pstmt.executeQuery();

		            // 결과 처리
		            while (rs.next()) {
		                BoardItem item = new BoardItem();
		                item.setNum(rs.getInt("num"));
		                item.setName(rs.getString("name"));
		                item.setTitle(rs.getString("title"));
		                item.setRegDate(rs.getString("regDate"));
		                item.setReadCount(rs.getInt("regCount"));
		                item.setFile1(rs.getString("file1"));
		                // ... 나머지 필드 설정
		               
		                boardItems.add(item);
		            }
		        } catch (ClassNotFoundException | SQLException e) {
		            e.printStackTrace();
		            // 예외 처리
		        } finally {
		            // 자원 해제
		            try {
		                if (rs != null) rs.close();
		                if (pstmt != null) pstmt.close();
		                if (conn != null) conn.close();
		            } catch (SQLException e) {
		                e.printStackTrace();
		            }
		        }

		        return boardItems;
		    }

	  
}
