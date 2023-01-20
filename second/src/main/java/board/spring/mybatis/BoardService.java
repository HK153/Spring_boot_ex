package board.spring.mybatis;

import java.util.List;

import org.springframework.stereotype.Service;

public interface BoardService {
	//게시물 리스트 서비스 명세서
	int getTotalBoard();
	List<BoardDTO> getBoardlist(int limit); 
	//상세 게시물 정보
	BoardDTO getOneBoard(int seq);
	//void updateViewCount(int seq);
	void insertBoard (BoardDTO dto);
}
