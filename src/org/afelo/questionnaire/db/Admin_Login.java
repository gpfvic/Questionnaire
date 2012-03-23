package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;


@PersistenceCapable
public class Admin_Login {
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long lid;//pk
	/**
	 * @return the lid
	 */
	public Long getLid() {
		return lid;
	}
	public Admin_Login(Long lid, String uname, String pwd) {
		super();
		this.lid = lid;
		this.uname = uname;
		this.pwd = pwd;
	}
	/**
	 * @param lid the lid to set
	 */
	public void setLid(Long lid) {
		this.lid = lid;
	}
	/**
	 * @return the uname
	 */
	public String getUname() {
		return uname;
	}
	/**
	 * @param uname the uname to set
	 */
	public void setUname(String uname) {
		this.uname = uname;
	}
	/**
	 * @return the pwd
	 */
	public String getPwd() {
		return pwd;
	}
	/**
	 * @param pwd the pwd to set
	 */
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	@Persistent
	private String uname;
	@Persistent
	private String pwd;
}
