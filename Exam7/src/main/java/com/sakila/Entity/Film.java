package com.sakila.Entity;

import java.math.BigDecimal;
import java.sql.Timestamp;

import com.hand.Entity.EntityWithID;

public class Film extends EntityWithID {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1764969125543032413L;
	private String title;
	private String description;
	private short release_year;
	private int language_id;
	private int original_language_id;
	private int rental_duration;
	private BigDecimal rental_rate;
	private int length;
	private BigDecimal replacement_cost;
	private String rating;
	private String special_features;
	private Timestamp last_update;

	@Override
	public void setID(long ID) {
		this.ID = ID;
	}

	@Override
	public long getID() {
		return this.ID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public short getRelease_year() {
		return release_year;
	}

	public void setRelease_year(short release_year) {
		this.release_year = release_year;
	}

	public int getLanguage_id() {
		return language_id;
	}

	public void setLanguage_id(int language_id) {
		this.language_id = language_id;
	}

	public int getOriginal_language_id() {
		return original_language_id;
	}

	public void setOriginal_language_id(int original_language_id) {
		this.original_language_id = original_language_id;
	}

	public int getRental_duration() {
		return rental_duration;
	}

	public void setRental_duration(int rental_duration) {
		this.rental_duration = rental_duration;
	}

	public BigDecimal getRental_rate() {
		return rental_rate;
	}

	public void setRental_rate(BigDecimal rental_rate) {
		this.rental_rate = rental_rate;
	}

	public int getLength() {
		return length;
	}

	public void setLength(int length) {
		this.length = length;
	}

	public BigDecimal getReplacement_cost() {
		return replacement_cost;
	}

	public void setReplacement_cost(BigDecimal replacement_cost) {
		this.replacement_cost = replacement_cost;
	}

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

	public String getSpecial_features() {
		return special_features;
	}

	public void setSpecial_features(String special_features) {
		this.special_features = special_features;
	}

	public Timestamp getLast_update() {
		return last_update;
	}

	public void setLast_update(Timestamp last_update) {
		this.last_update = last_update;
	}
	
	//���setter��Ϊ�˼���Mybatis����ʹ�����Ͽ�ܿ��Բ�д
	public void setFilm_id(long ID){
		this.ID=ID;
	}
	
	//���getter��Ϊ�˼���Mybatis����ʹ�����Ͽ�ܿ��Բ�д
	public Long getFilm_id(){
		return this.ID;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

	@Override
	public String toString() {
		return "File [ID=" + ID + ", title=" + title + ", description=" + description + ", release_year=" + release_year
				+ ", language_id=" + language_id + ", original_language_id=" + original_language_id
				+ ", rental_duration=" + rental_duration + ", rental_rate=" + rental_rate + ", length=" + length
				+ ", replacement_cost=" + replacement_cost + ", rating=" + rating + ", special_features="
				+ special_features + ", last_update=" + last_update + "]";
	}

}
