package kr.ac.kopo.ctc.kopo20.board.Repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import kr.ac.kopo.ctc.kopo20.board.domain.BoardItem;

@Repository
public interface BoardItemRepository extends JpaRepository<BoardItem, Integer> {
	List<BoardItem> findAll();
	
	BoardItem findById(int id);
	
	Page<BoardItem> findAllBytitle(String title, Pageable pageable);
	
	Page<BoardItem> findByTitleContaining(String searchKeyword, Pageable pageable);
	
	

}
