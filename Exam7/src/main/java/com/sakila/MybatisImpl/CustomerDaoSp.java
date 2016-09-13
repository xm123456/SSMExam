package com.sakila.MybatisImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.Dao.BasicIdEntityDao;
import com.hand.Entity.EntityWithID;
import com.sakila.Entity.Customer;

public class CustomerDaoSp extends SqlSessionDaoSupport implements BasicIdEntityDao{

	public EntityWithID getByID(long ID) throws SQLException {
		return this.getSqlSession().selectOne("getByID_Customer",ID);
	}

	public void delByID(long ID) throws SQLException {
		this.getSqlSession().delete("delByID_Customer",ID);

	}

	public void ModifyIdEntity(EntityWithID entity) throws SQLException {
		this.getSqlSession().update("ModifyIdEntity_Customer", entity);

	}

	public void AddIdEntity(EntityWithID entity) throws SQLException {
		this.getSqlSession().insert("AddIdEntity_Customer", entity);

	}
	
	public Customer[] getByFirstName_Customer(String first_name) throws SQLException{
		List<Customer> lc=this.getSqlSession().selectList("getByFirstName_Customer", first_name);
		Customer[] res=new Customer[lc.size()];
		res=lc.toArray(res);
		return res;
	}
	
	public List<Customer> getCustomerInPage(int pageNum, int ctInOnePage) throws SQLException {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("startFrom", (pageNum - 1) * ctInOnePage);
		args.put("howMany", ctInOnePage);
		List<Customer> cl = this.getSqlSession().selectList("getCustomerInPage_Customer", args);
		return cl;
	}
	
	public int getCustomerCount(){
		return this.getSqlSession().selectOne("getCustomerCount_Customer");
	}
}
