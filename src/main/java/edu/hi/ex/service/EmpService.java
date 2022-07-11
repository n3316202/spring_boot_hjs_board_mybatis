package edu.hi.ex.service;

import java.util.List;

import edu.hi.ex.vo.DeptVO;
import edu.hi.ex.vo.EmpDeptVO;

public interface EmpService {
	List<EmpDeptVO> getEmpDeptList();//리스트 메소드
	List<DeptVO> getEmpDetpList2();
}
