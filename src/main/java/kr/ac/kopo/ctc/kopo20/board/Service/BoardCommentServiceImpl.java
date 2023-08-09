package kr.ac.kopo.ctc.kopo20.board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo20.board.Repository.BoardCommentRepository;
import kr.ac.kopo.ctc.kopo20.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo20.board.domain.BoardItem;

@Service
public class BoardCommentServiceImpl  implements BoardCommentService{
	
	@Autowired
	private BoardCommentRepository boardCommentRepository;
	
	public void save_comment(BoardComment boardComment) {
		boardCommentRepository.save(boardComment);
	}
	
	public List<BoardComment> findAllByBoardItem(BoardItem boardItem){
		List<BoardComment> boardComment = boardCommentRepository.findAllByBoardItem(boardItem);
		return boardComment;
	}
	
	public void delete_comment(BoardComment boardComment) {
		boardCommentRepository.delete(boardComment);
	}
	
	public void delete_commentId(int id) {
		System.out.println("서비스 : " + id);
		boardCommentRepository.deleteById(id);
	}
}
