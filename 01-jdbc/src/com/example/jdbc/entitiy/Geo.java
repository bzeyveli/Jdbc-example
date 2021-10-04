package com.example.jdbc.entitiy;

public class Geo {

	private int id;
	private double lat;
	private double lgn;

	public Geo() {

	}

	public Geo(double lat, double lgn) {
		this.lat = lat;
		this.lgn = lgn;
	}

	public double getLat() {
		return lat;
	}

	public void setLat(double lat) {
		this.lat = lat;
	}

	public double getLgn() {
		return lgn;
	}

	public void setLgn(double lgn) {
		this.lgn = lgn;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Geo [id=" + id + ", lat=" + lat + ", lgn=" + lgn + "]";
	}

}
