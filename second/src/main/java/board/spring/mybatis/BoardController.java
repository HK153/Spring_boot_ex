package board.spring.mybatis;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import jakarta.servlet.http.HttpSession;

@Controller
public class BoardController {

	@Autowired
	@Qualifier("boardservice")
	BoardService service;

	@RequestMapping("/boardlist")
	public ModelAndView boardlist(@RequestParam(value = "page", required = false, defaultValue = "1") int page) {

		// 몇페이지 구성 선택 가능 보여주는 링크
		// 1.select count(*) from board=int-nil 저장
		// 2.select * from board limit (page -1)*3,3-list-model 저장
		// 3.board/list 뷰

		int totalboard = service.getTotalBoard();
		int limit = (page - 1) * 3;
		List<BoardDTO> list = service.getBoardlist(limit);

		ModelAndView mv = new ModelAndView();
		mv.addObject("totalboard", totalboard);
		mv.addObject("list", list);
		mv.setViewName("board/list");
		return mv;
	}

	@RequestMapping("/oneboard")
	public ModelAndView getOneBoard(int seq) {
		BoardDTO dto = service.getOneBoard(seq);
		ModelAndView mv = new ModelAndView();
		mv.addObject("board", dto);
		mv.setViewName("board/oneboard");
		return mv;
	}

	@GetMapping("/insertBoard")
	public String insertboardForm(HttpSession session) {
		String viewname =null;
		String id = (String) session.getAttribute("loginid");
		if (id ==null) {
			viewname= "mybatis/loginform";
		}
		else {
			viewname="board/insertform";
		}
		/*
		 * ModelAndView mv = new ModelAndView(); mv.setViewName(viewname);
		 */
		return viewname;
	}
	
	@PostMapping("/insertBoard")
	public ModelAndView insertboardPost(BoardDTO dto) {
		ModelAndView mv = new ModelAndView();
		service.insertBoard(dto);
		mv.setViewName("redirect:/boardlist"); //매핑 url /boardlist 메소드 호출
		return mv;
	}
}
