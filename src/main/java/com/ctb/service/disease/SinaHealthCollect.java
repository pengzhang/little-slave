package com.ctb.service.disease;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ctb.entity.BodyPartDisease;
import com.ctb.util.ConfigUtil;
import com.ctb.util.JsoupUtil;

public class SinaHealthCollect {
	
	public static Logger logger = LoggerFactory.getLogger(SinaHealthCollect.class);

	public static List<BodyPartDisease> collectBodyPartInfo(String url) {
		Document doc = JsoupUtil.getDoc(url);
		Element element = doc.select(".mainBody .Fenlei #basic-accordian").first();
		List<BodyPart> bodyParts = new ArrayList<BodyPart>();
		for (int i = 1; i <= 12; i++) {
			BodyPart bodyPart = new BodyPart();
			String testStr = "#test";
			if (i != 5) {
				bodyPart.bodyPartType = element.select(testStr + i + "-header").text();
				logger.info("采集部位信息:" + bodyPart.bodyPartType);
				Elements bodyparts = element.select(testStr + i + "-content ul li a");
				for (Element bodypartA : bodyparts) {
					Map<String, String> map = JsoupUtil.parseATag(bodypartA);
					bodyPart.bodyPart = map.get("text");
					bodyPart.bodyPartUrl = map.get("href");
				}
				bodyParts.add(bodyPart);
			}
		}
		return collectBodyPartDiseaseInfo( bodyParts);
	}

	private static List<BodyPartDisease> collectBodyPartDiseaseInfo(List<BodyPart> bodyParts) {
		List<BodyPartDisease> bodyPartDiseases = new ArrayList<BodyPartDisease>();
		for (BodyPart bodyPart : bodyParts) {
			Document doc = JsoupUtil.getDoc(bodyPart.bodyPartUrl);
			Elements diseaseInfos = doc.select(".main_right .main_R1 .main_R1_txt ul li a");
			logger.info(bodyPart.bodyPart+"部位有"+diseaseInfos.size()+"种疾病");
			for (Element diseaseInfoA : diseaseInfos) {
				BodyPartDisease bodyPartDisease = new BodyPartDisease();
				bodyPartDisease.setBodyPartType(bodyPart.bodyPartType);
				bodyPartDisease.setBodyPart(bodyPart.bodyPart);
				bodyPartDisease.setBodyPartUrl(bodyPart.bodyPartUrl);
				Map<String, String> map = JsoupUtil.parseATag(diseaseInfoA);
				bodyPartDisease.setDisease(map.get("text"));
				bodyPartDisease.setDiseaseUrl(map.get("href"));
				bodyPartDisease.setFromSite("Sina");
				bodyPartDiseases.add(bodyPartDisease);
			}
		}
		return bodyPartDiseases;
	}

	public static List<String> getCollectUrlInfo() {
		List<String> urls = new ArrayList<String>();
		// 头部
		urls.add(ConfigUtil.readValue("sina_health_btb"));
		// 颈部
		urls.add(ConfigUtil.readValue("sina_health_bjb"));
		// 胸部
		urls.add(ConfigUtil.readValue("sina_health_bxb"));
		// 背部
		urls.add(ConfigUtil.readValue("sina_health_bbb"));
		// 腹部
		urls.add(ConfigUtil.readValue("sina_health_bfb"));
		// 盆腔
		urls.add(ConfigUtil.readValue("sina_health_bpq"));
		// 臀部
		urls.add(ConfigUtil.readValue("sina_health_btbu"));
		// 四肢
		urls.add(ConfigUtil.readValue("sina_health_bssz"));
		// 皮肤
		urls.add(ConfigUtil.readValue("sina_health_bpf"));
		// 全身
		urls.add(ConfigUtil.readValue("sina_health_bqs"));
		// 其它
		urls.add(ConfigUtil.readValue("sina_health_bxn"));
		// 生殖部位
		urls.add(ConfigUtil.readValue("sina_health_bsz"));
		return urls;
	}

}

class BodyPart {
	/**
	 * 大部位名称
	 */
	public String bodyPartType;
	/**
	 * 具体部位名称
	 */
	public String bodyPart;
	/**
	 * 疾病信息采集网址
	 */
	public String bodyPartUrl;
}
