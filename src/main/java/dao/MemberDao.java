package dao;

import java.io.UnsupportedEncodingException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Member;

public class MemberDao {
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
public int insertMember(Member kicmem) throws UnsupportedEncodingException, SQLException {
         
      Connection conn = getConnection();
          
         PreparedStatement pstmt = conn.prepareStatement("insert into member "
                + "values (?,?,?,?,?,?)");
         //mapping
         pstmt.setString(1,kicmem.getLoginId());
         pstmt.setString(2,kicmem.getLoginPw());
         pstmt.setString(3,kicmem.getName());
         pstmt.setString(4,kicmem.getCellphoneNo());
         pstmt.setString(5,kicmem.getEmail());
         pstmt.setString(6,kicmem.getNickname());
         //4)excute
         int num = pstmt.executeUpdate();
         return num;
                  
   }

public Member oneMember(String loginId) throws SQLException {
	 Connection conn = getConnection();
     
     PreparedStatement pstmt = conn.prepareStatement("select * from member where loginId= ?");
	pstmt.setString(1, loginId);
	ResultSet rs = pstmt.executeQuery();
	if(rs.next()) {
		Member m = new Member();
		m.setLoginId(rs.getString("loginId"));
		m.setLoginPw(rs.getString("loginPw"));
		m.setName(rs.getString("name"));
		m.setCellphoneNo(rs.getString("cellphoneNo"));
		m.setNickname(rs.getString("nickname"));
		m.setEmail(rs.getString("email"));
		return m;
	}
	return null;
}
public  int UpdateMember(Member kicmem) throws SQLException {
	 Connection conn = getConnection();
	 String sql = "Update member set name=?,cellphoneNo=?,email=?,nickname=? where loginId=?";
    PreparedStatement pstmt = conn.prepareStatement(sql);
	;
	
	pstmt.setString(1,kicmem.getName());
    pstmt.setString(2,kicmem.getCellphoneNo());
    pstmt.setString(3,kicmem.getEmail());
    pstmt.setString(4, kicmem.getNickname());
    pstmt.setString(5,kicmem.getLoginId());
		  int num = pstmt.executeUpdate();
		return num;
	
}

public int DeleteMember(String loginId) throws UnsupportedEncodingException, SQLException {
    
    Connection conn = getConnection();
        String sql = "delete member where loginid = ?";
       PreparedStatement pstmt = conn.prepareStatement(sql);
       //mapping
       pstmt.setString(1,loginId);
       
       //4)excute
       int num = pstmt.executeUpdate();
       return num;
                
 }
public int PassMember(String loginId,String chgpass) throws UnsupportedEncodingException, SQLException {
    
    Connection conn = getConnection();
        String sql = "update member set loginPw=? where loginId=?" ;
       PreparedStatement pstmt = conn.prepareStatement(sql);
       //mapping
       pstmt.setString(1,chgpass);
       pstmt.setString(2, loginId);
       
       //4)excute
       int num = pstmt.executeUpdate();
       return num;
                
 }


}// class end