package com.dj.renthouse.renthouseinfo.entity;

import java.util.List;

import com.dj.people.peoplebase.entity.DjPeopleBaseEntity;

public class Room {
	
	private DjHouseInfoEntity djHouseInfoEntity;
	
	private List<DjPeopleBaseEntity> djPeopleBaseEntities;
	
	public Room(DjHouseInfoEntity djHouseInfoEntity,
			List<DjPeopleBaseEntity> djPeopleBaseEntities) {
		super();
		this.djHouseInfoEntity = djHouseInfoEntity;
		this.djPeopleBaseEntities = djPeopleBaseEntities;
	}

	public DjHouseInfoEntity getDjHouseInfoEntity() {
		return djHouseInfoEntity;
	}

	public void setDjHouseInfoEntity(DjHouseInfoEntity djHouseInfoEntity) {
		this.djHouseInfoEntity = djHouseInfoEntity;
	}

	public List<DjPeopleBaseEntity> getDjPeopleBaseEntities() {
		return djPeopleBaseEntities;
	}

	public void setDjPeopleBaseEntities(
			List<DjPeopleBaseEntity> djPeopleBaseEntities) {
		this.djPeopleBaseEntities = djPeopleBaseEntities;
	}
	
	
	
	
	

}
