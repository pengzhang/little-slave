package com.ctb.service.disease;

import java.util.List;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.disease.BodyPartDisease;
import com.ctb.entity.disease.DepartmentDisease;
import com.ctb.entity.disease.DiseaseDetailInfo;
import com.ctb.entity.disease.DiseaseInfo;
import com.ctb.util.JsoupUtil;

@Component
public class SinaHealthDiseaseCollect {

	public static Logger logger = LoggerFactory.getLogger(SinaHealthDiseaseCollect.class);

	@Autowired
	private BodyPartDiseaseService bodyPartDiseaseService;

	@Autowired
	private DepartmentDiseaseService departmentDiseaseService;

	@Autowired
	private DiseaseInfoService diseaseInfoService;

	@Autowired
	private DiseaseDetailInfoService diseaseDetailInfoService;

	/**
	 * 采集按部位的疾病详情
	 */
	public void collectBodyPartDiseaseInfo() {
		long total = bodyPartDiseaseService.getCount();
		int m = 1;
		for (int i = 1; i < total / 30 + 1; i++) {
			List<BodyPartDisease> diseases = bodyPartDiseaseService.getBodyPartDisease(i, 30, "auto").getContent();
			if (diseases != null && diseases.size() > 0) {
				for (BodyPartDisease disease : diseases) {
					if (disease.getDiseaseUrl().contains("#")) {
						logger.info("按部位疾病,网址错误,忽略,Code:" + disease.getCode());
						continue;
					}
					collectDiseaseInfo(disease.getDiseaseUrl(), "body_part");
					collectDiseaseDetailInfo(disease.getDiseaseUrl(), disease.getCode());
					logger.info("按部位疾病:" + disease.getBodyPart() + ",Code:" + disease.getCode() + ",采集完毕,已采集" + (m++) + "个疾病信息");
				}
			}
		}
	}
	
	/**
	 * 采集按部位的疾病详情-指定Code
	 */
	public void collectBodyPartDiseaseInfo(String code) {
		BodyPartDisease disease = bodyPartDiseaseService.findByCode(code);
		collectDiseaseInfo(disease.getDiseaseUrl(), "body_part");
		collectDiseaseDetailInfo(disease.getDiseaseUrl(), disease.getCode());
		logger.info("按部位疾病:" + disease.getBodyPart() + ",Code:" + disease.getCode() + ",采集完毕");
	}

	/**
	 * 采集按科室的疾病详情
	 */
	public void collectDepartmentDiseaseInfo() {
		long total = departmentDiseaseService.getCount();
		int m = 1;
		for (int i = 1; i < total / 30 + 1; i++) {
			List<DepartmentDisease> diseases = departmentDiseaseService.getDepartmentDisease(i, 30, "auto").getContent();
			if (diseases != null && diseases.size() > 0) {
				for (DepartmentDisease disease : diseases) {
					if (disease.getDiseaseUrl().contains("#")) {
						logger.info("按科室疾病,网址错误,忽略,Code:" + disease.getCode());
						continue;
					}
					collectDiseaseInfo(disease.getDiseaseUrl(), "department");
					collectDiseaseDetailInfo(disease.getDiseaseUrl(), disease.getCode());
					logger.info("按科室疾病:" + disease.getDepartment() + ",Code:" + disease.getCode() + ",采集完毕,已采集" + (m++) + "个疾病信息");
				}
			}
		}
	}

	/**
	 * 采集身体部位疾病信息
	 * 
	 * @param url
	 */
	private void collectDiseaseInfo(String url, String from_type) {

		DiseaseInfo diseaseInfo = new DiseaseInfo();
		diseaseInfo.setFrom_type(from_type);
		Document doc = JsoupUtil.getDoc(url);
		if (doc != null) {
			Element element = doc.select(".main_C .C_box1").first();
			Elements overview = element.select("ul li");

			// 采集疾病概况
			diseaseInfo.setDisease(overview.get(0).text().split("：").length >= 2 ? overview.get(0).text().split("：")[1] : "无");
			diseaseInfo.setBodyPartType(overview.get(1).text().split("：").length >= 2 ? overview.get(1).text().split("：")[1] : "无");
			diseaseInfo.setDepartment(overview.get(2).text().split("：").length >= 2 ? overview.get(2).text().split("：")[1] : "无");
			diseaseInfo.setSymptoms(overview.get(3).text().split("：").length >= 2 ? overview.get(3).text().split("：")[1] : "无");

			// 采集疾病概述,临床表现,疾病防治
			Elements desc = element.select("dl dd");
			diseaseInfo.setDisease_description(desc.get(0).text().replace("查看详细", ""));
			diseaseInfo.setClinical_feature(desc.get(1).text().replace("查看详细", ""));
			diseaseInfo.setDisease_prevention(desc.get(2).text().replace("查看详细", ""));
			diseaseInfoService.save(diseaseInfo);
		}
	}

	private void collectDiseaseDetailInfo(String url, String disease_code) {
		DiseaseDetailInfo diseaseDetailInfo = new DiseaseDetailInfo();
		diseaseDetailInfo.setDisease_code(disease_code);
		diseaseDetailInfo.setClinical_feature_detail(getDetailInfo(url + "zhengzhuang.html"));
		diseaseDetailInfo.setDisease_check_detail(getDetailInfo(url + "jiancha.html"));
		diseaseDetailInfo.setDisease_cure_detail(getDetailInfo(url + "zhiliao.html"));
		diseaseDetailInfo.setDisease_description_detail(getDetailInfo(url + "bingyin.html"));
		diseaseDetailInfo.setDisease_prevention_detail(getDetailInfo(url + "yufang.html"));
		diseaseDetailInfoService.save(diseaseDetailInfo);
	}

	private String getDetailInfo(String url) {
		try {
			Document doc = JsoupUtil.getDoc(url);
			Element element = doc.select(".C_box2 .box2_txt .txt_xx").first();
			return element.select("p").get(1).text();
		} catch (Exception e) {
			logger.info("没有采集到任何信息");
		}
		return "暂无相关信息";
	}

}