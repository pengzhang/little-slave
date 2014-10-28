package com.ctb.service.disease.collect;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.disease.DepartmentDisease;
import com.ctb.entity.disease.HospitalDepartment;
import com.ctb.repository.disease.DepartmentDiseaseDao;
import com.ctb.repository.disease.HospitalDepartmentDao;
import com.ctb.util.JsoupUtil;

@Component
public class SinaHealthDepartmentCollect {

	public static Logger logger = LoggerFactory.getLogger(SinaHealthDepartmentCollect.class);

	@Autowired
	private DepartmentDiseaseDao departmentDiseaseDao;
	
	@Autowired
	private HospitalDepartmentDao hospitalDepartmentDao;
	
	/**
	 * 采集科室信息
	 * @param url
	 */
	public void collectHospitalDepartmentInfo(String url) {
		Document doc = JsoupUtil.getDoc(url);
		Element element = doc.select(".mainBody .Fenlei #basic-accordian").first();
		List<HospitalDepartment> departments = new ArrayList<HospitalDepartment>();
		for (int i = 1; i <= 12; i++) {
			String testStr = "#test";
			if (i != 5) {
				testStr += i;
			}
			Elements bodyparts = element.select(testStr + "-content ul li a");
			for (Element bodypartA : bodyparts) {
				HospitalDepartment department = new HospitalDepartment();
				department.setDepartmentType(element.select(testStr + "-header").text());
				logger.info("采集科室信息:" + department.getDepartmentType());
				Map<String, String> map = JsoupUtil.parseATag(bodypartA);
				department.setDepartment(map.get("text"));
				department.setDepartmentUrl(map.get("href"));
				departments.add(department);
				hospitalDepartmentDao.save(department);
			}
		}
		collectDepartmentDiseaseInfo(departments);
	}
	
	/**
	 * 采集科室治疗的疾病信息
	 * @param bodyParts
	 */
	public void collectDepartmentDiseaseInfo(List<HospitalDepartment> departments) {
		List<DepartmentDisease> departmentDiseases = new ArrayList<DepartmentDisease>();
		for (HospitalDepartment department : departments) {
			Document doc = JsoupUtil.getDoc(department.getDepartmentUrl());
			Elements diseaseInfos = doc.select(".main_right .main_R1 .main_R1_txt ul li a");
			logger.info(department.getDepartment() + "科室,治疗" + diseaseInfos.size() + "种疾病");
			for (Element diseaseInfoA : diseaseInfos) {
				DepartmentDisease departmentDisease = new DepartmentDisease();
				departmentDisease.setDepartmentType(department.getDepartmentType());
				departmentDisease.setDepartment(department.getDepartment());
				departmentDisease.setDepartmentUrl(department.getDepartmentUrl());
				
				Map<String, String> map = JsoupUtil.parseATag(diseaseInfoA);
				departmentDisease.setDisease(map.get("text"));
				departmentDisease.setDiseaseUrl(map.get("href"));
				departmentDisease.setFromSite("Sina");
				departmentDiseases.add(departmentDisease);
				departmentDiseaseDao.save(departmentDisease);
			}
		}
	}

}