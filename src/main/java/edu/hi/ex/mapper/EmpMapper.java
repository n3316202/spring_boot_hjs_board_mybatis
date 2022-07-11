package edu.hi.ex.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import edu.hi.ex.vo.DeptVO;
import edu.hi.ex.vo.EmpDeptVO;

@Mapper
public interface EmpMapper {
	List<EmpDeptVO> getEmpDetpList();
	List<DeptVO> getEmpDetpList2();
	
}

