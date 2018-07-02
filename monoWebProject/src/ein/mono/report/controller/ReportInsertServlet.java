package ein.mono.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import ein.mono.member.model.vo.MemberVo;
import ein.mono.report.model.service.ReportService;
import ein.mono.report.model.vo.ReportVo;

/**
 * Servlet implementation class reportInsertServlet
 */
@WebServlet("/reportInsert.do")
public class ReportInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		/*ReportVo report = new ReportVo();//회원이 신고하기(일반회원)/ delflag바꾸기 신고당한횟수증가(쿼리)
		
		int result = new ReportService().reportInsert(report);*/
		
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");
		
		HttpSession session = request.getSession();
		MemberVo report = (MemberVo)session.getAttribute("LoginMember"); //로그인한사람 뽑아올수있음
		
		//신고한사람 코드
		String reporterCode= report.getMemberCode();
		//신고대상의사람 코드
		String reportedCode="";
		//게시글코드
		String postCode="";
		//덧글코드  파라미터로 받음
		String replyCode="";
		
		/*((Long)request.getParameter("reportReason1"))*/
		String rReason = request.getParameter("reportReason1")+", "+request.getParameter("reportReason2"); //신고구분 + 신고내용
		
		ReportVo reportvo = new ReportVo(reporterCode, reportedCode, postCode, replyCode, rReason);
		
		int result = new ReportService().reportInsert(reportvo);
		
		RequestDispatcher view = null;
		
		if(0<result) {
			request.setAttribute("msg", "신고가 완료되었습니다");
			view = request.getRequestDispatcher("views/common/successPage.jsp");
		}else {
			request.setAttribute("msg", "신고하기가 정상적으로 이루어지지않음");
			view = request.getRequestDispatcher("views/common/errorPage.jsp");
		}
		view.forward(request, response);
	}

}
