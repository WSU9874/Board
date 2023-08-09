package kr.ac.kopo.ctc.kopo20.board.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import kr.ac.kopo.ctc.kopo20.board.Repository.BoardItemRepository;
import kr.ac.kopo.ctc.kopo20.board.domain.BoardItem;

@Service
public class BoardItemServiceImpl implements BoardItemService {

	@Autowired
	private BoardItemRepository boardRepository;

	@Override
	public List<BoardItem> findAll() {
		List<BoardItem> boardItem_list = boardRepository.findAll();

		return boardItem_list;
	}

	@Override
	public BoardItem findById(int id) {
		BoardItem boardItem = boardRepository.findById(id);
		return boardItem;
	}

	@Override
	public void save(BoardItem boardItem) {
		boardRepository.save(boardItem);
	}

	@Override
	public void delete(int id) {
		boardRepository.deleteById(id);
	}

	@Override
	public void viewCnt(BoardItem boardItem) {
		boardItem.setViewcnt(boardItem.getViewcnt() + 1);
		boardRepository.save(boardItem);
	}

	@Override
	public Page<BoardItem> selectAll(Pageable pageable) {
		Page<BoardItem> boards = boardRepository.findAll(pageable);
		return boards;

	}

	@Override
	public Page<BoardItem> searchKeyword(String searchKeyword, Pageable pageable) {
		return boardRepository.findByTitleContaining(searchKeyword, pageable);
	}





//	public BoardItem findById(int id) {
//		
//	}
//	
//	public Page<BoardItem> findAllBytitle(String title, Pageable pageable){
//		
//	}

//	public int add(int a, int b) {
//		return a + b;
//	}
//	@Override
//	public void test() {
//		System.out.println("BoardItemServiceImpl.test()  메소드 호출");
//	}
//	@Override
//	public void testAopBefore() {
//		System.out.println("BoardItemServiceImpl.testAopBefore()  메소드 호출");
//	}
//	@Override
//	public void testAopAfter() {
//		System.out.println("BoardItemServiceImpl.testAopAfter()  메소드 호출");
//	}
//	@Override
//	public String testAopAfterReturning() {
//		System.out.println("BoardItemServiceImpl.testAopAfterReturning()  메소드 호출");
//		return "Success";
//	}
//	@Override
//	public void testAopAfterThrowing() {
//		System.out.println("BoardItemServiceImpl.testAopAfterThrowing()  메소드 호출");	
//		throw new RuntimeException("runtime exception 발생");
//	}
//	@Override
//	public void testAopAround() {
//		System.out.println("BoardItemServiceImpl.testAopAround()  메소드 호출");		
//	}
//	@Override
//	public void testPointcutBefore() {
//		System.out.println("BoardItemServiceImpl.testPointcutBefore()  메소드 호출");		
//	}
//	@Override
//	public void testPointcutAfter() {
//		System.out.println("BoardItemServiceImpl.testPointcutAfter()  메소드 호출");	
//	}
//	@Override
//	public String testPointcutAfterReturning() {
//		System.out.println("BoardItemServiceImpl.testPointcutAfterReturning()  메소드 호출");
//		return "Success";
//	}
//	@Override
//	public void testPointcutAfterThrowing() {
//		System.out.println("BoardItemServiceImpl.testPointcutAfterThrowing()  메소드 호출");
//		throw new RuntimeException("runtime exception 발생");
//	}
//	@Override
//	public void testPointcutAround() {
//		System.out.println("BoardItemServiceImpl.testPointcutAround()  메소드 호출");		
//	}
}
