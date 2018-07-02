package ein.mono.member.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ein.mono.member.model.service.MemberService;
import ein.mono.member.model.vo.MemberVo;


@WebServlet("/memberLogin.do")
public class MemberLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public MemberLoginServlet() {
        super();

    }


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String id = request.getParameter("memberId");
		String password = request.getParameter("memberPwd");
		
		MemberVo member = new MemberService().loginMember(id);
		RequestDispatcher view = null;
		
		
		
		
		
		 if(null == member) {
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
			request.setAttribute("msg", "로그인정보(아이디)를 확인하세요!!");
			view.forward(request, response);
		}else {
			
			if(member.getDelflag().equals("Y")) {
				view = request.getRequestDispatcher("views/common/errorPage.jsp");
				request.setAttribute("msg", "탈퇴한 회원입니다 ㅎㅎ!!");
				view.forward(request, response);
			}else {
				
				if() 
				
				if(password.equals(member.getMemberPwd())) {
					HttpSession session = request.getSession();
					session.setAttribute("LoginMember", member);
					response.sendRedirect("index.jsp");
				}else {
					view = request.getRequestDispatcher("views/common/errorPage.jsp");
					request.setAttribute("msg", "로그인정보(비밀번호)를 확인하세요!!");
					view.forward(request, response);
			}
				
			}
		}
		
	}

}
