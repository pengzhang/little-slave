package com.ctb.entity.resource;

public enum ReadingType {
	
	
	YuYan("寓言"),GuShi("故事"),XiaoHua("笑话"),LiShi("历史"),ShuXue("数学"),YiShu("艺术");
	
	private String name;

	private ReadingType(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}
