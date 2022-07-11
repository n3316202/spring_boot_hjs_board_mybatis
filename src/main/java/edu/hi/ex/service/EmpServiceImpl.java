package edu.hi.ex.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.hi.ex.mapper.BoardMapper;
import edu.hi.ex.mapper.EmpMapper;
import edu.hi.ex.page.Criteria;
import edu.hi.ex.vo.BoardVO;
import edu.hi.ex.vo.DeptVO;
import edu.hi.ex.vo.EmpDeptVO;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class EmpServiceImpl implements EmpService{

	@Autowired
	private EmpMapper empMapper;

	@Override
	public List<EmpDeptVO> getEmpDeptList() {
		log.info("getEmpDeptList()");
		
		return empMapper.getEmpDetpList();
	}

	@Override
	public List<DeptVO> getEmpDetpList2() {
		log.info("getEmpDetpList2()");
		
		return empMapper.getEmpDetpList2();
	}	
}
