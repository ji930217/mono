package ein.mono.member.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.member.model.service.MemberService;
import ein.mono.member.model.vo.MemberVo;


@WebServlet("/memberJoin.do")
public class MemberJoinServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public MemberJoinServlet() {
        super();
       
    }

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		//객체저장    
		
		String mRank = request.getParameter("memberType");
		
		String mId	= request.getParameter("memberId");
		String mPwd = request.getParameter("memberPwd");
		String mName = request.getParameter("memberName");
		String mEmail = request.getParameter("email");
		String mAddress = "("+request.getParameter("addressNum")+")"+", "+request.getParameter("address1")+", "+request.getParameter("address2");
		String mTel = request.getParameter("tel1")+"-"+request.getParameter("tel2")+"-"+request.getParameter("tel3");
		String mNickname = request.getParameter("memberNickname");
		
		MemberVo member = new MemberVo(mId, mPwd, mName, mEmail, mAddress, mTel, mNickname);
		
		
		int result = new MemberService().joinMember(member, mRank);
		RequestDispatcher view = null;
		
		if(0<result) {
			request.setAttribute("msg", "회원가입을 축하합니다!");
			view = request.getRequestDispatcher("views/common/successPage.jsp");
		}else {
			request.setAttribute("msg", "회원가입실패!");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
		
		
		
		
		
		
		
		
	}

}
