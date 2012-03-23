package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class UserDetailsDB {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String sessionid;
	@Persistent
	private String sex;
	@Persistent
	private String age;
	@Persistent
	private String edcuation;
	@Persistent
	private String work;
	@Persistent
	private String salary;
	@Persistent
	private String comments;
	
	public UserDetailsDB(String sessionid, String sex, String age,
			String edcuation, String work, String salary, String comments) {
		super();
		this.sessionid = sessionid;
		this.sex = sex;
		this.age = age;
		this.edcuation = edcuation;
		this.work = work;
		this.salary = salary;
		this.comments = comments;
	}

	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}

	/**
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}

	/**
	 * @return the age
	 */
	public String getAge() {
		return age;
	}

	/**
	 * @return the edcuation
	 */
	public String getEdcuation() {
		return edcuation;
	}

	/**
	 * @return the work
	 */
	public String getWork() {
		return work;
	}

	/**
	 * @return the salary
	 */
	public String getSalary() {
		return salary;
	}

	/**
	 * @return the comments
	 */
	public String getComments() {
		return comments;
	}
	
	
	
}
