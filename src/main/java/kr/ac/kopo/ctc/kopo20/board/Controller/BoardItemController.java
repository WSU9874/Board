package kr.ac.kopo.ctc.kopo20.board.Controller;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.ac.kopo.ctc.kopo20.board.domain.BoardComment;
import kr.ac.kopo.ctc.kopo20.board.domain.BoardItem;
import kr.ac.kopo.ctc.kopo20.board.Service.BoardCommentService;
import kr.ac.kopo.ctc.kopo20.board.Service.BoardItemService;

@Controller
@RequestMapping("/board")
public class BoardItemController {

	@Autowired
	private BoardItemService boardItemService;

	@Autowired
	private BoardCommentService boardCommentService;

//	@RequestMapping("/list")
//	public String findAllByPage(Model model) {
//		List<BoardItem> boardItem_list = boardItemService.findAll();
//		model.addAttribute("Board_list", boardItem_list);
//		return "board";
//	}

	@RequestMapping("/selectOne")
	public String findById(Model model, BoardItem board) {
		int id = board.getId();
		BoardItem boardItem = boardItemService.findById(id);
		model.addAttribute("boardItem", boardItem);
		boardItemService.viewCnt(boardItem);
		List<BoardComment> boardCommentlist = boardCommentService.findAllByBoardItem(boardItem);
		model.addAttribute("boardCommentlist", boardCommentlist);
		return "selectOne";
	}

	@RequestMapping("/update")
	public void update(Model model, BoardItem boardItem, HttpServletResponse rep) throws IOException {
		boardItemService.save(boardItem);
		rep.sendRedirect("/board/list");
	}

	@RequestMapping("/insert")
	public String insertLocation(Model model1) {
		LocalDate now = LocalDate.now();
		model1.addAttribute("date", now);
		return "insert";
	}

	@RequestMapping("/insertDB")
	public void insert(BoardItem boardItem, HttpServletResponse rep) throws IOException {
		boardItem.setViewcnt(0);
		boardItemService.save(boardItem);
		rep.sendRedirect("/board/list");
	}

	@RequestMapping("/deleteDB")
	public void delete(BoardItem boardItem, HttpServletResponse rep) throws IOException {
		boardItemService.delete(boardItem.getId());
		rep.sendRedirect("/board/list");
	}

//	@RequestMapping("/comment")
//	public String comment(Model model1, BoardItem board) {
//		LocalDate now = LocalDate.now();
//		BoardItem board1 = boardItemService.findById(board.getId());
//		model1.addAttribute("board", board1);
//		model1.addAttribute("date", now);
//		return "comment";
//	}
	
	@RequestMapping("/comment")
	public String comment(Model model1, BoardItem board,int id) {
		LocalDate now = LocalDate.now();
		BoardItem board1 = boardItemService.findById(board.getId());
		model1.addAttribute("board", board1);
		model1.addAttribute("date", now);
		model1.addAttribute("id",id);
		return "comment";
	}

	@RequestMapping("/commentDB")
	public void insert(BoardComment boardcomment, HttpServletResponse rep, HttpServletRequest req) throws IOException {
		int root_id = Integer.parseInt(req.getParameter("root_id"));
		BoardItem boardItem = boardItemService.findById(root_id);
		boardcomment.setBoardItem(boardItem);
		boardcomment.setViewcnt(0);
		System.out.println(boardcomment.getContent());
		System.out.println(boardcomment.getBoardItem().getId());

		boardCommentService.save_comment(boardcomment);
		rep.sendRedirect("/board/list");
	}

	@RequestMapping("/update_comment")
	public void update_comment(BoardComment boardComment, HttpServletResponse rep, HttpServletRequest req)
			throws IOException {
		int rootid = Integer.parseInt(req.getParameter("rootid"));
		boardComment.setBoardItem(boardItemService.findById(rootid));
		boardCommentService.save_comment(boardComment);
		rep.sendRedirect("/board/list");
	}

	@RequestMapping("/delete_comment")
	public void delete_comment(HttpServletResponse rep, HttpServletRequest req, BoardComment boardComment)
			throws IOException {
		System.out.println("컨트롤러 : " + boardComment.getId());
		boardCommentService.delete_commentId(boardComment.getId());

		rep.sendRedirect("/board/list");
	}
	
//	@GetMapping("/board/list")
//    public String showBoard(@RequestParam(name = "searchKeyword", required = false) String searchKeyword,
//                            @RequestParam(name = "sortTitle", required = false, defaultValue = "0") int sortTitle,
//                            @RequestParam(name = "sortView", required = false, defaultValue = "0") int sortView,
//                            @RequestParam(name = "page", required = false, defaultValue = "0") int page,
//                            Model model) {
//        
//        // 페이지당 표시되는 항목 개수
//        int pageSize = 10;
//        
//        // 정렬 기준과 방향 설정
//        String sortField = "id";
//        Sort.Direction sortDirection = Sort.Direction.DESC;
//        if (sortTitle == 1) {
//            sortField = "title";
//        } else if (sortView == 1) {
//            sortField = "viewcnt";
//        }
//        
//        // 검색 기능 추가 시 boardService.searchKeyword 메서드 활용
//        Pageable pageable = PageRequest.of(page, pageSize, Sort.by(sortDirection, sortField));
//        Page<BoardItem> boardPage = boardItemService.selectAll(pageable);
//        
//        int nowPage = boardPage.getNumber() + 1; // 페이지가 0부터 시작해서 +1
//        int startPage = Math.max(nowPage - 4, 1);
//        int endPage = Math.min(nowPage + 5, boardPage.getTotalPages());
//        
//        model.addAttribute("boards", boardPage);
//        model.addAttribute("nowPage", nowPage);
//        model.addAttribute("startPage", startPage);
//        model.addAttribute("endPage", endPage);
//        model.addAttribute("searchKeyword", searchKeyword);
//        model.addAttribute("sortTitle", sortTitle);
//        model.addAttribute("sortView", sortView);
//        
//        return "/board/list";
//    }
	

//	// 첫 게시판 인덱스 화면
//	@RequestMapping("/list")
//	public String indexBoard(
//			@PageableDefault(page = 0, size = 5, sort = "id", direction = Sort.Direction.DESC) Pageable pageable,
//			String searchKeyword, String sortTitle, String sortView, Model model) {
//
//		Page<BoardItem> boards = null;
//
//		if (sortTitle != null && sortTitle.equals("1")) {
//			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("title").descending());
//		}
//
//		if (sortView != null && sortView.equals("1")) {
//			pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(),
//					Sort.by("viewcnt").descending());
//		}
//
//		if (searchKeyword == null) {
//			boards = boardItemService.selectAll(pageable);
//		} else {
//			boards = boardItemService.searchKeyword(searchKeyword, pageable);
//		}
//
//		int nowPage = boards.getPageable().getPageNumber() + 1; // 페이지가 0부터시작해서 +1
//		int startPage = Math.max(nowPage - 4, 1);
//		int endPage = Math.min(nowPage + 5, boards.getTotalPages());
//
//		model.addAttribute("boards", boards);
//		model.addAttribute("nowPage", nowPage);
//		model.addAttribute("startPage", startPage);
//		model.addAttribute("endPage", endPage);
//		model.addAttribute("searchKeyword", searchKeyword);
//
//		model.addAttribute("sortTitle", sortTitle);
//		model.addAttribute("sortView", sortView);
//
//		return "board";
//	}
	
	@RequestMapping("/list")
	public String indexBoard(@RequestParam(name = "page", defaultValue = "0") int page,
	                         @RequestParam(name = "size", defaultValue = "5") int size,
	                         @RequestParam(name = "sort", defaultValue = "id") String sort,
	                         @RequestParam(name = "direction", defaultValue = "DESC") String direction,
	                         String searchKeyword, String sortTitle, String sortView, Model model) {

	    Sort.Direction sortDirection = Sort.Direction.fromString(direction);
	    Pageable pageable = PageRequest.of(page, size, Sort.by(sortDirection, sort));

	    Page<BoardItem> boards = null;

	    if (sortTitle != null && sortTitle.equals("1")) {
	        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("title").descending());
	    }

	    if (sortView != null && sortView.equals("1")) {
	        pageable = PageRequest.of(pageable.getPageNumber(), pageable.getPageSize(), Sort.by("viewcnt").descending());
	    }

	    if (searchKeyword == null) {
	        boards = boardItemService.selectAll(pageable);
	    } else {
	        boards = boardItemService.searchKeyword(searchKeyword, pageable);
	    }

	    int nowPage = boards.getPageable().getPageNumber() + 1; // 페이지가 0부터 시작해서 +1
	    int startPage = Math.max(nowPage - 4, 1);
	    int endPage = Math.min(nowPage + 5, boards.getTotalPages());

	    model.addAttribute("boards", boards);
	    model.addAttribute("nowPage", nowPage);
	    model.addAttribute("startPage", startPage);
	    model.addAttribute("endPage", endPage);
	    model.addAttribute("searchKeyword", searchKeyword);

	    model.addAttribute("sortTitle", sortTitle);
	    model.addAttribute("sortView", sortView);

	    return "board";
	}


}
