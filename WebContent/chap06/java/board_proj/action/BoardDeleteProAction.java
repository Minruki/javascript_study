package board_proj.action;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import board_proj.dto.ActionForward;
import board_proj.service.BoardDeleteService;

public class BoardDeleteProAction implements Action {

	@Override
	public ActionForward execute(HttpServletRequest request, HttpServletResponse response) throws Exception {
		// boardDeletePro.bo?board_num=26
		// hidden page=1
		// BOARD_PASS=aaa
		response.setContentType("text/html;charset=UTF-8");
		
		int board_num = Integer.parseInt(request.getParameter("board_num"));
		String page = request.getParameter("page");
		String pass = request.getParameter("BOARD_PASS");
		
		BoardDeleteService service = new BoardDeleteService();
		
		ActionForward forward = null;
		
		boolean isArticleWriter = service.isArticleWriter(board_num, pass);
		if (!isArticleWriter) {
			sendMessage(response, "삭제할 권한이 없습니다");
			return forward;
		}
		
		boolean isDeleteSuccess = service.removeArticle(board_num);
		if (!isDeleteSuccess) {
			sendMessage(response, "삭제 실패");
			return forward;
		}

		forward = new ActionForward();
		forward.setRedirect(true);
		forward.setPath("boardList.do?page=" + page);
		
		return forward;
	}

	private void sendMessage(HttpServletResponse response, String msg) throws IOException {
		PrintWriter out=response.getWriter();
		out.println("<script>");
		out.println("alert('"+ msg +"');");
		out.println("history.back();");
		out.println("</script>");
		out.close();
	}

}
