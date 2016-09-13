package com.sakila.MybatisImpl;

import java.sql.SQLException;
import java.util.List;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.Dao.IDDao;
import com.hand.Entity.EntityWithID;
import com.sakila.Entity.Language;

public class LanguageDaoSp extends SqlSessionDaoSupport implements IDDao{

	public EntityWithID getByID(long ID) throws SQLException {
		return this.getSqlSession().selectOne("getByID_Language",ID);
	}

	public void delByID(long ID) throws SQLException {
		// TODO Auto-generated method stub
		
	}
	public Language[] getAllLanguage() throws SQLException{
		List<Language> LL=this.getSqlSession().selectList("selectAllLanguage_Language");
		Language[] res=new Language[LL.size()];
		res=LL.toArray(res);
		return res;
	}
}
