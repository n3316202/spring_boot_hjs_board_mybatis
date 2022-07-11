package edu.hi.ex.service;

import java.util.List;

import edu.hi.ex.page.Criteria;
import edu.hi.ex.vo.BoardVO;

public interface BoardService {
	List<BoardVO> getList();//리스트 메소드
	BoardVO read(int bid);//글보기 메소드
	void register(BoardVO board); //글쓰기
	int modify(BoardVO board); //글수정
	int remove(BoardVO board); //글삭제
	void registerReply(BoardVO board); //댓글쓰기
	//paging
	int getTotal();
	List<BoardVO> getList(Criteria criteria);//리스트 메소드
	
}
