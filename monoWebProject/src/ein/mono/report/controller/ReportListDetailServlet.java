package ein.mono.report.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import ein.mono.report.model.service.ReportService;
import ein.mono.report.model.vo.ReportVo;

/**
 * Servlet implementation class ReportListDetailServlet
 */
@WebServlet("/reportListDetail.do")
public class ReportListDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReportListDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String reportNo = request.getParameter("reportNo"); 
		int currentPage = Integer.parseInt(request.getParameter("currentPage"));
		
		ReportVo report = new ReportService().detailReport(reportNo);
		
		String url = "";
		
		if(null != report) {
			url = "views/report/reportListDetail.jsp";
			request.setAttribute("report", report);
			request.setAttribute("currentPage", currentPage);
		}else {
			url = "views/common/errorPage.jsp";
			request.setAttribute("msg", "신고상세조회에 실패");
		}
		RequestDispatcher view = request.getRequestDispatcher(url);
		view.forward(request, response);
	}


}
