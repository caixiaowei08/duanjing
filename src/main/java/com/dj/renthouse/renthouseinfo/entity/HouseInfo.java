package com.dj.renthouse.renthouseinfo.entity;

import java.util.List;

import com.dj.people.peoplebase.entity.DjPeopleBaseEntity;

public class HouseInfo {
	/**
	 * 房间主人
	 */
	private DjPeopleBaseEntity djPeopleBaseEntity;
	/**
	 * 房间信息
	 */
	private DjHouseInfoEntity djHouseInfoEntity;
	/**
	 * 住在房间人的信息
	 */
	private List<DjPeopleBaseEntity> peoples;
	
	public HouseInfo(DjPeopleBaseEntity djPeopleBaseEntity,
			DjHouseInfoEntity djHouseInfoEntity,
			List<DjPeopleBaseEntity> peoples) {
		super();
		this.djPeopleBaseEntity = djPeopleBaseEntity;
		this.djHouseInfoEntity = djHouseInfoEntity;
		this.peoples = peoples;
	}
	public DjPeopleBaseEntity getDjPeopleBaseEntity() {
		return djPeopleBaseEntity;
	}
	public void setDjPeopleBaseEntity(DjPeopleBaseEntity djPeopleBaseEntity) {
		this.djPeopleBaseEntity = djPeopleBaseEntity;
	}
	public DjHouseInfoEntity getDjHouseInfoEntity() {
		return djHouseInfoEntity;
	}
	public void setDjHouseInfoEntity(DjHouseInfoEntity djHouseInfoEntity) {
		this.djHouseInfoEntity = djHouseInfoEntity;
	}
	public List<DjPeopleBaseEntity> getPeoples() {
		return peoples;
	}
	public void setPeoples(List<DjPeopleBaseEntity> peoples) {
		this.peoples = peoples;
	}
	
	

	

}
