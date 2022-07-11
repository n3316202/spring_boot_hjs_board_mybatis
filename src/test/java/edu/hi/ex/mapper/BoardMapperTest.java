package edu.hi.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.hi.ex.vo.BoardVO;

@SpringBootTest
class BoardMapperTest {

	@Autowired
	BoardMapper boardMapper;
	
	
//	@Test
//	void testGetList() {
//		
//		List<BoardVO> boards = boardMapper.getList();
//		
//		for (BoardVO boardVO : boards) {
//			System.out.println(boardVO);
//		}		
//	}
	
	@Test
	void testRead() {
		
		BoardVO boards = boardMapper.read(10);		
		System.out.println(boards);	
	}

}
