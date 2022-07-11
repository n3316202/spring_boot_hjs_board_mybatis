package edu.hi.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hi.ex.mapper.BoardMapper;
import edu.hi.ex.page.Criteria;
import edu.hi.ex.vo.BoardVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class BoardServiceImpl implements BoardService{

	@Autowired
	private BoardMapper boardMapper;
	
	//글전체목록
	@Override
	public List<BoardVO> getList() {
		log.info("getList() ..");
		
		return boardMapper.getList();
	}

	//선택한 글보기
	@Override
	public BoardVO read(int bid) {
		log.info("read() ..");
		
		return boardMapper.read(bid);
	}

	@Override
	public void register(BoardVO board) {
		log.info("register() ..");		
		 boardMapper.insert(board);		
	}

	@Override
	public int modify(BoardVO board) {
		log.info("modify() ..");		
		
		return  boardMapper.update(board);	
	}

	@Override
	public int remove(BoardVO board) {
		log.info("remove() ..");
		return boardMapper.delete(board);
	}

	@Override
	public void registerReply(BoardVO board) {
		log.info("registerReply() ..");
		
		boardMapper.updateShape(board);//답글의 위치를 먼저 잡아준 후
		boardMapper.insertReply(board);//답글을 등록한다.
		
	}

	@Override
	public int getTotal() {
		log.info("getTotal() ..");
		
		return boardMapper.getTotalCount();
	}

	@Override
	public List<BoardVO> getList(Criteria criteria) {
		log.info("getList(Criteria criteria) ..");
		
		return boardMapper.getListWithPaging(criteria);
	}
	
}
