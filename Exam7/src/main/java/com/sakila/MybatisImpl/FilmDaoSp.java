package com.sakila.MybatisImpl;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.mybatis.spring.support.SqlSessionDaoSupport;

import com.hand.Dao.BasicIdEntityDao;
import com.hand.Entity.EntityWithID;
import com.sakila.Entity.Film;;

public class FilmDaoSp extends SqlSessionDaoSupport implements BasicIdEntityDao {

	public EntityWithID getByID(long ID) throws SQLException {
		return this.getSqlSession().selectOne("getByID_Film", ID);
	}

	public void delByID(long ID) throws SQLException {
		this.getSqlSession().delete("delByID_Film", ID);
	}

	public void ModifyIdEntity(EntityWithID entity) throws SQLException {
		this.getSqlSession().update("ModifyIdEntity_Film", entity);
	}

	public void AddIdEntity(EntityWithID entity) throws SQLException {
		this.getSqlSession().insert("AddIdEntity_Film", entity);
	}

	public Film[] getAllFilm() throws SQLException {
		List<Film> fl = this.getSqlSession().selectList("getAllFilm_Film");
		Film[] res = new Film[fl.size()];
		res = fl.toArray(res);
		return res;
	}

	public Film[] getFilmInPage(int pageNum, int ctInOnePage) throws SQLException {
		Map<String, Integer> args = new HashMap<String, Integer>();
		args.put("startFrom", (pageNum - 1) * ctInOnePage);
		args.put("howMany", ctInOnePage);
		List<Film> fl = this.getSqlSession().selectList("getFilmInPage_Film", args);
		Film[] res = new Film[fl.size()];
		res = fl.toArray(res);
		return res;
	}
	
	public int getFilmCount(){
		return this.getSqlSession().selectOne("getFilmCount_Film");
	}
}
