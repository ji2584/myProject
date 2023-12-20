package controller;

import java.util.Map;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;

import dao.MyBoardDao;
import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
import model.MyBoard;

@WebServlet("/board/*")
public class BoardController extends MskimRequestMapping {
	
	
	
	@RequestMapping("index")////*****//board//index
    public String index(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
  	  	return"/WEB-INF/view/board/index.jsp";

	} 
	
	@RequestMapping("write")////*****//board//index
    public String write(HttpServletRequest request, HttpServletResponse response) throws Exception {
    
  	  	return"/WEB-INF/view/board/write.jsp";

	} 
	
	@RequestMapping("writePro")////*****//board//index
    public String writePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		String path = request.getServletContext().getRealPath("/")+ "image/board/";
		String filename = null;
		String msg = "게시물 등록실패";
		String url = "/board/write";
	
		MultipartRequest multi = new MultipartRequest(request,path,10*1024*1024,"UTF-8");
		
		MyBoard board = new MyBoard();
		board.setBoardid("1");
		board.setName(multi.getParameter("name"));
		board.setPass(multi.getParameter("pass"));
		board.setTitle(multi.getParameter("title"));
		board.setContent(multi.getParameter("content"));
		board.setName(multi.getFilesystemName("file1"));
		System.out.println(board);
		MyBoardDao bd = new MyBoardDao();
		int num = bd.insertBoard(board);
		if(num>0 ) {
			msg="게시물 등록 성공";
			url="/board/boardList";
			
		}
		request.setAttribute("msg", msg);		
		request.setAttribute("url", url);
		
		return "/WEB-INF/view/alert.jsp";   
		

	} 
	 
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
