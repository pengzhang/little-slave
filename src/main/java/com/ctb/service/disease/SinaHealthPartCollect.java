package com.ctb.service.disease;

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

import com.ctb.entity.disease.BodyPart;
import com.ctb.entity.disease.BodyPartDisease;
import com.ctb.repository.disease.DiseaseInfoDao;
import com.ctb.util.JsoupUtil;

@Component
public class SinaHealthPartCollect {

	public static Logger logger = LoggerFactory.getLogger(SinaHealthPartCollect.class);

	@Autowired
	private BodyPartService bodyPartService;

	@Autowired
	private BodyPartDiseaseService bodyPartDiseaseService;
	
	@Autowired
	private DiseaseInfoDao diseaseInfoDao;

	/**
	 * 采集身体部位信息
	 * @param url
	 */
	public void collectBodyPartInfo(String url) {
		Document doc = JsoupUtil.getDoc(url);
		Element element = doc.select(".mainBody .Fenlei #basic-accordian").first();
		List<BodyPart> bodyParts = new ArrayList<BodyPart>();
		for (int i = 1; i <= 12; i++) {
			String testStr = "#test";
			if (i != 5) {
				testStr += i;
			}
			Elements bodyparts = element.select(testStr + "-content ul li a");
			for (Element bodypartA : bodyparts) {
				BodyPart bodyPart = new BodyPart();
				bodyPart.setBodyPartType(element.select(testStr + "-header").text());
				logger.info("采集部位信息:" + bodyPart.getBodyPartType());
				Map<String, String> map = JsoupUtil.parseATag(bodypartA);
				bodyPart.setBodyPart(map.get("text"));
				bodyPart.setBodyPartUrl(map.get("href"));
				bodyParts.add(bodyPart);
				bodyPartService.save(bodyPart);
			}
		}
		collectBodyPartDiseaseInfo(bodyParts);
	}

	/**
	 * 采集身体部位下的疾病信息
	 * @param bodyParts
	 */
	public void collectBodyPartDiseaseInfo(List<BodyPart> bodyParts) {
		List<BodyPartDisease> bodyPartDiseases = new ArrayList<BodyPartDisease>();
		for (BodyPart bodyPart : bodyParts) {
			Document doc = JsoupUtil.getDoc(bodyPart.getBodyPartUrl());
			Elements diseaseInfos = doc.select(".main_right .main_R1 .main_R1_txt ul li a");
			logger.info(bodyPart.getBodyPart() + "部位有" + diseaseInfos.size() + "种疾病");
			for (Element diseaseInfoA : diseaseInfos) {
				BodyPartDisease bodyPartDisease = new BodyPartDisease();
				bodyPartDisease.setBodyPartType(bodyPart.getBodyPartType());
				bodyPartDisease.setBodyPart(bodyPart.getBodyPart());
				bodyPartDisease.setBodyPartUrl(bodyPart.getBodyPartUrl());
				Map<String, String> map = JsoupUtil.parseATag(diseaseInfoA);
				bodyPartDisease.setDisease(map.get("text"));
				bodyPartDisease.setDiseaseUrl(map.get("href"));
				bodyPartDisease.setFromSite("Sina");
				bodyPartDiseases.add(bodyPartDisease);
				bodyPartDiseaseService.save(bodyPartDisease);
			}
		}
	}
	
	
	
	
}