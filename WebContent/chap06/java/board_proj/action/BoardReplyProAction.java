package board_proj.action;

import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;
import board_proj.dto.BoardDTO;
import board_proj.service.BoardReplyProService;

public class BoardReplyProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		
		int page = Integer.parseInt(request.getParameter("page"));
		BoardDTO article = getArticle(request);
		System.out.println("article > " + article);
		
		BoardReplyProService service = new BoardReplyProService();
		boolean res = service.replyArticle(article);
		
		ActionForward forward = null;
		if(res) {
			forward = new ActionForward("boardList.do?page="+page, true);
		}else {
			response.setContentType("text/html;charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>");
			out.println("alert('답변 등록 실패')");
			out.println("history");
			out.println("<script>");
		}
		
		return forward;
	}

	private BoardDTO getArticle(HttpServletRequest request) {
		int board_num = Integer.parseInt(request.getParameter("BOARD_NUM"));
		int board_re_ref = Integer.parseInt(request.getParameter("BOARD_RE_REF"));
		int board_re_lev = Integer.parseInt(request.getParameter("BOARD_RE_LEV"));
		int board_re_seq = Integer.parseInt(request.getParameter("BOARD_RE_SEQ"));

		String board_name = request.getParameter("BOARD_NAME");
		String board_pass = request.getParameter("BOARD_PASS");
		String board_subject = request.getParameter("BOARD_SUBJECT");
		String board_content = request.getParameter("BOARD_CONTENT");
		
		return new BoardDTO(board_num, board_name, board_pass, board_subject, board_content, ""
				, board_re_ref, board_re_lev, board_re_seq, 0, null);
	}

}
