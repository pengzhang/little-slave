package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.DepartmentDisease;
import com.ctb.repository.disease.DepartmentDiseaseDao;


@Component
@Transactional
public class DepartmentDiseaseService {
	
	private DepartmentDiseaseDao departmentDiseaseDao;

	@Autowired
	public void setDepartmentDiseaseDao(DepartmentDiseaseDao departmentDiseaseDao) {
		this.departmentDiseaseDao = departmentDiseaseDao;
	}
	
	public void save(DepartmentDisease department_disease){
		departmentDiseaseDao.save(department_disease);
	}
	
	public long getCount(){
		return departmentDiseaseDao.count();
	}
	
	public Page<DepartmentDisease> getDepartmentDisease(int pageNumber, int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		return departmentDiseaseDao.findAll(pageRequest);
	}
	
	/**
	 * 创建分页请求.
	 */
	private PageRequest buildPageRequest(int pageNumber, int pageSize, String sortType) {
		Sort sort = null;
		if ("auto".equals(sortType)) {
			sort = new Sort(Direction.DESC, "id");
		}
		return new PageRequest(pageNumber - 1, pageSize, sort);
	}

}
