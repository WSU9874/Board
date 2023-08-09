package kr.ac.kopo.ctc.kopo20.board.Service;

import java.util.List;

import kr.ac.kopo.ctc.kopo20.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo20.board.domain.BoardItem;

public interface BoardCommentService {
	public void save_comment(BoardComment boardComment);
	
	public List<BoardComment> findAllByBoardItem(BoardItem boardItem);
	
	public void delete_comment(BoardComment boardComment);
	
	public void delete_commentId(int id);
}
