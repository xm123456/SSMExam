package com.sakila.Entity;

import java.sql.Timestamp;

import com.hand.Entity.EntityWithID;

public class Address extends EntityWithID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -7996706690166398778L;
	private String address;
	private String address2;
	private String district;
	private int city_id;
	private String postal_code;
	private String phone;
	private Timestamp last_update;

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	@Override
	public long getID() {
		return this.ID;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	public String getAddress2() {
		return address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getDistrict() {
		return district;
	}

	public void setDistrict(String district) {
		this.district = district;
	}

	public int getCity_id() {
		return city_id;
	}

	public void setCity_id(int city_id) {
		this.city_id = city_id;
	}

	public String getPostal_code() {
		return postal_code;
	}

	public void setPostal_code(String postal_code) {
		this.postal_code = postal_code;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	
	//这个setter是为了兼容Mybatis，不使用整合框架可以不写
	public void setAddress_id(long ID){
		this.ID=ID;
	}
	
	//这个getter是为了兼容Mybatis，不使用整合框架可以不写
	public Long getAddress_id(){
		return this.ID;
	}

	@Override
	public String toString() {
		return "Address [ID=" + ID + ", address=" + address + ", address2=" + address2 + ", district=" + district
				+ ", city_id=" + city_id + ", postal_code=" + postal_code + ", phone=" + phone + ", last_update="
				+ last_update + "]";
	}

}
