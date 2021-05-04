package board_proj.dao;

import java.util.ArrayList;

import board_proj.dto.BoardDTO;

public interface BoardDao {
	int selectListCount();
	ArrayList<BoardDTO> selectArticleList(int page, int limit);
	BoardDTO selectArticle(int board_num);
	int insertArticle(BoardDTO article);
	int insertReplyArticle(BoardDTO article);
	int updateArticle(BoardDTO article);
	int deleteArticle(int board_num);
	int updateReadCount(int board_num);
	boolean isArticleBoardWriter(int board_num, String pass);
	int nextBoardNum();
}
