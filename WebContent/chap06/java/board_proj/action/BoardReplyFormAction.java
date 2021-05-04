package board_proj.action;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;
import board_proj.dto.BoardDTO;
import board_proj.service.BoardReplyService;

public class BoardReplyFormAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		int page= Integer.parseInt(request.getParameter("page"));;
		
//		System.out.println("board_num > " + board_num + " page > "+ page);
		
		BoardReplyService service = new BoardReplyService();
		BoardDTO article = service.getArticle(board_num);
		
		System.out.println("article " + article);
		request.setAttribute("article", article);
		request.setAttribute("page", page);
		
		ActionForward forward = new ActionForward();
		forward.setPath("/board/qna_board_reply.jsp");
		return forward;
	}

}
