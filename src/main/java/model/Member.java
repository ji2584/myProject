package model;

public class Member {
/*
 * create table kicmember (
id varchar(20) primary key,
pass varchar(20),
name varchar(20),
gender number(1),
tel varchar(20),
email varchar(50),
picture varchar(200));
 * 
 */
   
   public String loginId;
   public String loginPw;
   public String name;
   public String cellphoneNo;
   public String email;
   public String nickname;
   public String getLoginId() {
	return loginId;
}

public void setLoginId(String loginId) {
	this.loginId = loginId;
}

public String getLoginPw() {
	return loginPw;
}

public void setLoginPw(String loginPw) {
	this.loginPw = loginPw;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}

public String getCellphoneNo() {
	return cellphoneNo;
}

public void setCellphoneNo(String cellphoneNo) {
	this.cellphoneNo = cellphoneNo;
}

public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}

public String getNickname() {
	return nickname;
}

public void setNickname(String nickname) {
	this.nickname = nickname;
}

@Override
public String toString() {
	return "KicMember [loginId=" + loginId + ", loginPw=" + loginPw + ", name=" + name + ", cellphoneNo=" + cellphoneNo
			+ ", email=" + email + ", nickname=" + nickname + "]";
}
}
