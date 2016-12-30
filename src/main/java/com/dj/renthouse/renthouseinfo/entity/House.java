package com.dj.renthouse.renthouseinfo.entity;

import java.util.List;

import com.dj.people.peoplebase.entity.DjPeopleBaseEntity;
import com.dj.renthouse.house.entity.DjHouseEntity;

public class House {
	
	String address = "";
	
	/**
	 * 户主
	 */
	private DjPeopleBaseEntity djPeopleBaseEntity;
	
	/**
	 * 楼层
	 */
	private List<Floor> floors;
	
	/**
	 * 房屋信息
	 */
	private DjHouseEntity djHouseEntity;
	
	
	
	public House() {
		super();
	}

	public House(DjPeopleBaseEntity djPeopleBaseEntity, List<Floor> floors) {
		super();
		this.djPeopleBaseEntity = djPeopleBaseEntity;
		this.floors = floors;
	}

	public DjPeopleBaseEntity getDjPeopleBaseEntity() {
		return djPeopleBaseEntity;
	}

	public void setDjPeopleBaseEntity(DjPeopleBaseEntity djPeopleBaseEntity) {
		this.djPeopleBaseEntity = djPeopleBaseEntity;
	}

	public List<Floor> getFloors() {
		return floors;
	}

	public void setFloors(List<Floor> floors) {
		this.floors = floors;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public DjHouseEntity getDjHouseEntity() {
		return djHouseEntity;
	}

	public void setDjHouseEntity(DjHouseEntity djHouseEntity) {
		this.djHouseEntity = djHouseEntity;
	}
	
	
	
	

}
