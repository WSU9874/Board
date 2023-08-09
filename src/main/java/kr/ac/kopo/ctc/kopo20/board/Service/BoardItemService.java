package kr.ac.kopo.ctc.kopo20.board.Service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import kr.ac.kopo.ctc.kopo20.board.domain.BoardItem;

public interface BoardItemService {
	public List<BoardItem> findAll();

	public BoardItem findById(int id);

	public void save(BoardItem boardItem);

	public void delete(int id);

	public void viewCnt(BoardItem boardItem);
//	public int add(int a, int b);
//	void test();
//	void testAopBefore();
//	void testAopAfter();
//	String testAopAfterReturning();
//	void testAopAfterThrowing();
//	void testAopAround();
//	
//	void testPointcutBefore();
//	void testPointcutAfter();
//	String testPointcutAfterReturning();
//	void testPointcutAfterThrowing();
//	void testPointcutAround();

	// 게시글 페이지 추가해서 전체 조회하기
	public Page<BoardItem> selectAll(Pageable pageable);

	// ===========================================================================
	// 제목으로 검색하기
	public Page<BoardItem> searchKeyword(String searchKeyword, Pageable pageable);
	

	

}
