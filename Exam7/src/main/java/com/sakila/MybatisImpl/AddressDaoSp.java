package com.sakila.MybatisImpl;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.Dao.IDDao;
import com.hand.Entity.EntityWithID;
import com.sakila.Entity.Address;

public class AddressDaoSp extends SqlSessionDaoSupport implements IDDao {
	
	public EntityWithID getByID(long ID) throws SQLException {
		return this.getSqlSession().selectOne("getByID_Address",ID);
	}

	public void delByID(long ID) throws SQLException {
		this.getSqlSession().delete("delByID_Address", ID);
	}
	
	public int getCountById(long ID) throws SQLException{
		return this.getSqlSession().selectOne("getCountById_Address",ID);
	}
	
	public List<Address> getAllAddress(){
		List<Address> la=this.getSqlSession().selectList("getAllAddress_Address");
		return la;
	}
}
