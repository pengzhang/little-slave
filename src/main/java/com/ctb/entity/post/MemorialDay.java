package com.ctb.entity.post;

public enum MemorialDay {
	
	ManYue("满月"),YiBaiTian("100天"),BanSui("半岁"),ErBaiTian("200天"),YiSui("一岁");
	
	private String name;

	private MemorialDay(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
