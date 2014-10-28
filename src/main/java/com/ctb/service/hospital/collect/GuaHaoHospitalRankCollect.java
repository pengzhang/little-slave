package com.ctb.service.hospital.collect;

import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.ctb.entity.hospital.HospitalDepartRank;
import com.ctb.entity.hospital.HospitalRank;
import com.ctb.service.hospital.HospitalDepartRankService;
import com.ctb.service.hospital.HospitalRankService;
import com.ctb.util.JsoupUtil;

@Component
public class GuaHaoHospitalRankCollect {

	public static Logger logger = LoggerFactory.getLogger(GuaHaoHospitalRankCollect.class);

	@Autowired
	private HospitalRankService hospitalRankService;
	@Autowired
	private HospitalDepartRankService hospitalDepartRankService;

	/**
	 * 采集医院排行信息信息
	 * 
	 * @param url
	 */
	public void collectHospitalRank(String url, String year) {
		Document doc = JsoupUtil.getDoc(url);
		Elements elements = doc.select("#gc #hc-content .hc-table tbody tr");
		for (int i = 1; i < elements.size(); i++) {
			HospitalRank hr = new HospitalRank();
			hr.setRankId(elements.get(i).select("td").get(0).text());
			hr.setHospitalName(elements.get(i).select("td").get(1).text());
			hr.setDistrict(elements.get(i).select("td").get(2).text());
			hr.setReputation(elements.get(i).select("td").get(3).text());
			hr.setScientificResearch(elements.get(i).select("td").get(4).text());
			hr.setTotal(elements.get(i).select("td").get(5).text());
			hr.setYear(year);
			hospitalRankService.save(hr);
			logger.info("已采集" + year + "年的" + i + "医院");
		}
	}

	/**
	 * 采集医院排行信息信息
	 * 
	 * @param url
	 */
	public void collectHospitalDepartRank(String url, String year) {
		Document doc = JsoupUtil.getDoc(url);
		Elements elements = doc.select("#gc #g-cfg #gp-depart-rank-list .gp-depart-rank-list-list.sec-ranklist ul");
		for (int i = 0; i < elements.size(); i++) {
			String depart = elements.get(i).select(".left .spec-name").text();
			Elements right = elements.get(i).select(".right .data-tab tbody tr");
			for (int j = 0; j < right.size(); j++) {
				HospitalDepartRank hdr = new HospitalDepartRank();
				hdr.setHospitalDepart(depart);
				hdr.setRankId(right.get(j).select("td").get(0).text());
				hdr.setHospitalName(right.get(j).select("td").get(1).text());
				hdr.setTotal(right.get(j).select("td").get(2).text());
				hdr.setYear(year);
				hospitalDepartRankService.save(hdr);
				logger.info("已采集" + year + "年的"+i+"医院");
			}
		}
	}

	public static void main(String[] args) {
		// new
		// GuaHaoHospitalRankCollect().collectHospitalRank("http://www.guahao.com/rank/hospital/2012","2012");
		new GuaHaoHospitalRankCollect().collectHospitalDepartRank("http://www.guahao.com/rank/department/2012", "2012");
	}
}