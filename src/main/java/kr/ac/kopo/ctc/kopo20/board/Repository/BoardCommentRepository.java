package kr.ac.kopo.ctc.kopo20.board.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo20.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo20.board.domain.BoardItem;

@Repository
public interface BoardCommentRepository extends JpaRepository<BoardComment, Integer>{

	List<BoardComment> findAllByBoardItem(BoardItem boardItem);
	
 
}
