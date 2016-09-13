package com.hand.Dao;

import java.sql.SQLException;

import com.hand.Entity.EntityWithID;

public interface IDDao {
	/*
	 * 根据ID获得一个对象
	 */
	public EntityWithID getByID(long ID) throws SQLException;

	/*
	 * 根据ID删除一个对象
	 */
	public void delByID(long ID) throws SQLException;
}
