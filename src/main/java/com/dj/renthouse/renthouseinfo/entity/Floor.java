package com.dj.renthouse.renthouseinfo.entity;

import java.util.List;

public class Floor {
	
	private DjHouseInfoEntity djHouseInfoEntity;
	
	private List<Room> rooms;

	
	
	public Floor() {
		super();
	}

	public Floor(DjHouseInfoEntity djHouseInfoEntity, List<Room> rooms) {
		super();
		this.djHouseInfoEntity = djHouseInfoEntity;
		this.rooms = rooms;
	}

	public DjHouseInfoEntity getDjHouseInfoEntity() {
		return djHouseInfoEntity;
	}

	public void setDjHouseInfoEntity(DjHouseInfoEntity djHouseInfoEntity) {
		this.djHouseInfoEntity = djHouseInfoEntity;
	}

	public List<Room> getRooms() {
		return rooms;
	}

	public void setRooms(List<Room> rooms) {
		this.rooms = rooms;
	}
	
	

}
