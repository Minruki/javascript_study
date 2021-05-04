package board_proj.service;

import java.sql.Connection;

import board_proj.dao.impl.BoardDaoImpl;
import board_proj.ds.JndiDS;
import board_proj.dto.BoardDTO;

public class BoardReplyProService {
	private BoardDaoImpl dao = BoardDaoImpl.getInstance();
	private Connection con = JndiDS.getConnection();
	
	public BoardReplyProService() {
		dao.setCon(con);
	}
	
	public boolean replyArticle(BoardDTO article){
		return dao.insertReplyArticle(article)==1?true:false;
	}
}

