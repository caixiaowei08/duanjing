package com.dj.renthouse.renthouseinfo.entity;

import java.util.List;

public class HouseDetailInfo {
	/**
	 * 存储楼层信息
	 */
	private DjHouseInfoEntity djHouseInfoEntity;
	/**
	 * 存储楼层房间信息
	 */
	private List<HouseInfo> houseInfos;
	
	public HouseDetailInfo(DjHouseInfoEntity djHouseInfoEntity,
			List<HouseInfo> houseInfos) {
		super();
		this.djHouseInfoEntity = djHouseInfoEntity;
		this.houseInfos = houseInfos;
	}
	
	public DjHouseInfoEntity getDjHouseInfoEntity() {
		return djHouseInfoEntity;
	}
	public void setDjHouseInfoEntity(DjHouseInfoEntity djHouseInfoEntity) {
		this.djHouseInfoEntity = djHouseInfoEntity;
	}
	public List<HouseInfo> getHouseInfos() {
		return houseInfos;
	}
	public void setHouseInfos(List<HouseInfo> houseInfos) {
		this.houseInfos = houseInfos;
	}
	
	
	

}
