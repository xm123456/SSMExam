package com.sakila.Entity;

import java.io.Serializable;
import java.sql.Timestamp;

import com.hand.Entity.EntityWithID;

public class Customer extends EntityWithID implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3152932715442720265L;
	private int store_id;
	private String first_name;
	private String last_name;
	private String email;
	private int address_id;
	private boolean active;
	private Timestamp create_date;
	private Timestamp last_update;

	@Override
	public void setID(long ID) {
		this.ID = ID;

	}

	@Override
	public long getID() {
		return this.ID;
	}

	public int getStore_id() {
		return store_id;
	}

	public void setStore_id(int store_id) {
		this.store_id = store_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getAddress_id() {
		return address_id;
	}

	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}

	public boolean isActive() {
		return active;
	}

	public void setActive(boolean active) {
		this.active = active;
	}

	public Timestamp getCreate_date() {
		return create_date;
	}

	public void setCreate_date(Timestamp create_date) {
		this.create_date = create_date;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	
	//这个setter是为了兼容Mybatis，不使用整合框架可以不写
	public void setCustomer_id(long ID){
		this.ID=ID;
	}
	
	//这个getter是为了兼容Mybatis，不使用整合框架可以不写
	public Long getCustomer_id(){
		return this.ID;
	}

	@Override
	public String toString() {
		return "Customer [ID=" + ID + ", store_id=" + store_id + ", first_name=" + first_name + ", last_name="
				+ last_name + ", email=" + email + ", address_id=" + address_id + ", active=" + active
				+ ", create_date=" + create_date + ", last_update=" + last_update + "]";
	}

}
