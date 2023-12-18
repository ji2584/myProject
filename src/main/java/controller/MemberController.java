package controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

import model.Member;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;

public class MemberController extends MskimRequestMapping {
	
			@RequestMapping("memberinput")
		      public String memberinput(HttpServletRequest request, HttpServletResponse response) throws Exception {
		      
		    	  	return "/WEB-INF/view/member/memberinput.jsp";
      
			} 
		
			
			@RequestMapping("memberinfo")
		      public String memberinfo(HttpServletRequest request, HttpServletResponse response) throws Exception {
				
				MemberDao md = new MemberDao();
				HttpSession session = request.getSession();
				String login = (String)session.getAttribute("loginId");
				Member mem = md.oneMember(login);
				request.setAttribute("mem", mem);

				

		    	  	return"/WEB-INF/view/member/memberinfo.jsp";
  
			} 
			
			
			
			
			
			
			
    		@RequestMapping("loginForm")
    					public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
	      
		    	  	return"/WEB-INF/view/member/loginForm.jsp";
		      	  	
    	  	
		    	  	
		    	  	
		    	  	
	}
    		

		    	  	

    		
    		
    		
    	@RequestMapping("loginPro")
		public String loginPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
  	      
    	 
      	  	
  	
    	String id = request.getParameter("loginId");
    	String pass = request.getParameter("loginPw");
    	MemberDao md = new MemberDao();
    	Member mem = md.oneMember(id);
    	HttpSession session = request.getSession();
    	String msg = "아이디를 확인하세요";
    	String url = "/member/loginForm";
    	if(mem !=null){
    		if(pass.equals(mem.getLoginPw())){
    			session.setAttribute("loginId",id);
    			
    			msg = mem.getName()+"님이 로그인하셧습니다";
    			url = "/member/homepage";
    		}else {
    			msg = "비밀번호를 확인하세요 ";
    		}
    	}
    		   request.setAttribute("msg", msg);
    		      request.setAttribute("url", url);
    		
    	 	return"/WEB-INF/view/alert.jsp";
    	}
    	
    	@RequestMapping("logout")
		public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
	HttpSession session = request.getSession();
	session.invalidate();
	
	
	   request.setAttribute("msg", "logout 했습니다");
	      request.setAttribute("url", "/member/loginForm");
	
 	return"/WEB-INF/view/alert.jsp";
 	
  

  	
  	
  	
}


    	
    	
    	
    	
    	
    	@RequestMapping("memberPro")
    	
  public String memberPro(HttpServletRequest request, HttpServletResponse response) throws Exception {
    		
    		Member kicmem = new Member();
    	
    		request.setCharacterEncoding("utf-8");
    		String LoginId = request.getParameter("loginId");
    		String LoginPw = request.getParameter("loginPw");
    		String name = request.getParameter("name");
    		String cellPhoneNo = request.getParameter("cellphoneNo");
    		String email = request.getParameter("email");
    		String Nickname = request.getParameter("nickname");
    		kicmem.setLoginId(LoginId);
    		kicmem.setLoginPw(LoginPw);
    		kicmem.setName(name);
    		kicmem.setCellphoneNo(cellPhoneNo); 
    		kicmem.setEmail(email);
    		kicmem.setNickname(Nickname);

    		 MemberDao md = new MemberDao();
	    	  int num = md.insertMember(kicmem);
	    	  String msg = "저장 하였습니다.";
	    	  String url = "/member/loginForm";
	    	  
	    	  request.setAttribute("msg", msg);
	    	  request.setAttribute("url", url);
    		
    		  
	    	  return "/WEB-INF/view/alert.jsp";    	  
	    	  	    	  	    	  	    	  	    	  	    	  	    	  
	    	
	      
}
    	
    	
    	
    	
    	@RequestMapping("homepage")
		public String homepage(HttpServletRequest request, HttpServletResponse response) throws Exception {

  	return"/WEB-INF/view/member/homepage.jsp";
	  	

  	
  	
  	
}
    	
		
		@RequestMapping("board")
					public String board(HttpServletRequest request, HttpServletResponse response) throws Exception {
      
	    	  	return"/WEB-INF/view/member/board.jsp";
	      	  	
	  	
	    	  	
	    	  	
	    	  	
}
		

    	
    	
    	
    	
    	
    	
    	}
    	
    	
    	
    		

