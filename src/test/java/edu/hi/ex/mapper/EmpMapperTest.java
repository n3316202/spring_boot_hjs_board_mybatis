package edu.hi.ex.mapper;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import edu.hi.ex.vo.DeptVO;
import edu.hi.ex.vo.EmpDeptVO;
import edu.hi.ex.vo.EmpVO;

@SpringBootTest
class EmpMapperTest {

	@Autowired
	private EmpMapper empMapper;
	
//	@Test
//	void testGetEmpDetpList() {
//		
//		assertNotNull(empMapper);
//		
//		System.out.println(empMapper.getEmpDetpList());
//		
//		for (EmpDeptVO vo : empMapper.getEmpDetpList()) {
//			System.out.println(vo);
//		}		
//	}
	
	@Test
	void testGetEmpDetpList2() {
		
		assertNotNull(empMapper);
		
		System.out.println(empMapper.getEmpDetpList2());
		
		for (DeptVO vo : empMapper.getEmpDetpList2()) {
			
			for (EmpVO emp : vo.getEmpList()) {
				System.out.println(emp);
			}
		}		
	}
	

}
