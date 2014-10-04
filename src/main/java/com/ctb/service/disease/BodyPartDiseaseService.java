package com.ctb.service.disease;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import com.ctb.entity.disease.BodyPartDisease;
import com.ctb.repository.disease.BodyPartDiseaseDao;

@Component
@Transactional
public class BodyPartDiseaseService {

	private BodyPartDiseaseDao bodyPartDiseaseDao;

	@Autowired
	public void setBodyPartDiseaseDao(BodyPartDiseaseDao bodyPartDiseaseDao) {
		this.bodyPartDiseaseDao = bodyPartDiseaseDao;
	}

	public void save(BodyPartDisease bodyPartDisease) {
		bodyPartDiseaseDao.save(bodyPartDisease);
	}

	public Page<BodyPartDisease> getBodyPartDisease(int pageNumber, int pageSize, String sortType) {
		PageRequest pageRequest = buildPageRequest(pageNumber, pageSize, sortType);
		return bodyPartDiseaseDao.findAll(pageRequest);
	}

	public BodyPartDisease findByCode(String code) {
		return bodyPartDiseaseDao.findByCode(code);
	}
	
	public long getCount() {
		return bodyPartDiseaseDao.count();
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
