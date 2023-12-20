package controller;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.MemberDao;

import model.Member;

import kic.mskim.MskimRequestMapping;
import kic.mskim.RequestMapping;
@WebServlet("/member/*")
public class MemberController extends MskimRequestMapping {

	@RequestMapping("memberinput")
	public String memberinput(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/view/member/memberinput.jsp";

	}

	@RequestMapping("memberinfo")
	public String memberinfo(HttpServletRequest request, HttpServletResponse response) throws Exception {

		MemberDao md = new MemberDao();
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("loginId");
		Member mem = md.oneMember(login);
		request.setAttribute("mem", mem);

		return "/WEB-INF/view/member/memberinfo.jsp";

	}

	@RequestMapping("loginForm")
	public String loginForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/view/member/loginForm.jsp";

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
		if (mem != null) {
			if (pass.equals(mem.getLoginPw())) {
				session.setAttribute("loginId", id);

				msg = mem.getName() + "님이 로그인하셧습니다";
				url = "/member/homepage";
			} else {
				msg = "비밀번호를 확인하세요 ";
			}
		}
		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/WEB-INF/view/alert.jsp";
	}

	@RequestMapping("logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		session.invalidate();

		request.setAttribute("msg", "logout 했습니다");
		request.setAttribute("url", "/member/loginForm");

		return "/WEB-INF/view/alert.jsp";

	}

	@RequestMapping("memberPro")

	public String memberPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		Member kicmem = new Member();

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

		return "/WEB-INF/view/member/homepage.jsp";

	}

	@RequestMapping("board")
	public String board(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/view/member/board.jsp";

	}

	@RequestMapping("memberUpdateForm")
	public String memberUpdateForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("loginId");
		MemberDao md = new MemberDao();
		Member mem = md.oneMember(login);

		request.setAttribute("mem", mem);

		return "/WEB-INF/view/member/memberUpdateForm.jsp";

	}

	@RequestMapping("memberUpdatePro")
	public String memberUpdatePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("loginId");

		Member mem = new Member();// client에서 넘어온 자료

		mem.setLoginId(login);// session 저장 logout이면 에러남
		mem.setLoginPw(request.getParameter(("loginPw")));
		mem.setName(request.getParameter(("name")));
		mem.setCellphoneNo(request.getParameter(("cellphoneNo")));
		mem.setNickname(request.getParameter(("nickname")));
		mem.setEmail(request.getParameter(("email")));
		MemberDao md = new MemberDao();
		Member memdb = md.oneMember(login);// db에서 넘어온 자료
		String msg = "수정 되지 않았습니다";
		String url = "/member/memberUpdateForm";
		if (memdb != null) {
			if (memdb.getLoginPw().equals(mem.getLoginPw())) {// 수정 ok

				msg = "수정되었습니다";

				md.UpdateMember(mem);
				url = "/member/memberinfo";
			} else {
				msg = "비밀번호가 틀렸습니다.";
			}

		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/WEB-INF/view/alert.jsp";

	}

	@RequestMapping("memberDeleteForm")
	public String memberDeleteForm(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("loginId");
		MemberDao md = new MemberDao();
		Member mem = md.oneMember(login);

		request.setAttribute("mem", mem);

		return "/WEB-INF/view/member/memberDeleteForm.jsp";

	}

	@RequestMapping("memberDeletePro")
	public String memberDeletePro(HttpServletRequest request, HttpServletResponse response) throws Exception {
		HttpSession session = request.getSession();
		String login = (String) session.getAttribute("loginId");
		String pass = request.getParameter("loginPw");
		MemberDao md = new MemberDao();
		Member memdb = md.oneMember(login);
		String msg = "탈퇴되지 않았습니다.";
		String url = "/member/memberDeleteForm";
		if (memdb != null) {
			if (pass.equals(memdb.getLoginPw())) { // 비밀번호확인
				msg = "탈퇴 됐습니다";

				md.DeleteMember(login);
				session.invalidate();
				url = "/member/homepage";

			} else {
				msg = "비밀번호가 틀렸습니다.";
			}

		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/WEB-INF/view/alert.jsp";

	}

	@RequestMapping("memberPassForm")
	public String memberPassForm(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/view/member/memberPassForm.jsp";

	}

	@RequestMapping("memberPassPro")
	public String memberPassPro(HttpServletRequest request, HttpServletResponse response) throws Exception {

		HttpSession session = request.getSession();

		String login = (String) session.getAttribute("loginId");

		String pass = request.getParameter("loginPw");
		String chgpass = request.getParameter("chgpass");

		MemberDao md = new MemberDao();
		Member memdb = md.oneMember(login);

		String msg = "비밀번호 수정을 실패 했습니다.";
		String url = "/member/memberPassForm";

		if (memdb != null) {
			if (memdb.getLoginPw().equals(pass)) {// 수정 ok
				md.PassMember(login, chgpass);
				msg = login + "님이 비밀번호가 수정 되었습니다. ";
				url = "/member/homepage";
			} else {
				msg = "비밀번호가 틀렸습니다.";
			}

		}

		request.setAttribute("msg", msg);
		request.setAttribute("url", url);

		return "/WEB-INF/view/alert.jsp";

	}

	@RequestMapping("reservationinput")
	public String reservationinput(HttpServletRequest request, HttpServletResponse response) throws Exception {

		return "/WEB-INF/view/member/reservationinput.jsp";

	}

}
