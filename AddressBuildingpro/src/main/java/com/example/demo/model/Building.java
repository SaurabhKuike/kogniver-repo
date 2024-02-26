package com.example.demo.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.stereotype.Component;

@Component
@Document("adbuild")
public class Building {
	@Id
	private int BuildingNo;
	private String builder;
	private int floors;
	public int getBuildingNo() {
		return BuildingNo;
	}
	public void setBuildingNo(int buildingNo) {
		BuildingNo = buildingNo;
	}
	public String getBuilder() {
		return builder;
	}
	public void setBuilder(String builder) {
		this.builder = builder;
	}
	public int getFloors() {
		return floors;
	}
	public void setFloors(int floors) {
		this.floors = floors;
	}
	@Override
	public String toString() {
		return "Building [BuildingNo=" + BuildingNo + ", builder=" + builder + ", floors=" + floors + "]";
	}
	
}
