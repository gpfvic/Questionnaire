package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class QuestionnaireAnswerDB {

	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private String sessionid;
	@Persistent
	private String q1_most;
	@Persistent
	private String q1_least;
	@Persistent
	private String q2_most;
	@Persistent
	private String q2_least;
	@Persistent
	private String q3_most;
	@Persistent
	private String q3_least;
	@Persistent
	private String q4_most;
	@Persistent
	private String q4_least;
	@Persistent
	private String q5_most;
	@Persistent
	private String q5_least;
	@Persistent
	private String q6_most;
	@Persistent
	private String q6_least;
	@Persistent
	private String q7_most;
	@Persistent
	private String q7_least;
	public QuestionnaireAnswerDB(String sessionid, String q1_most,
			String q1_least, String q2_most, String q2_least, String q3_most,
			String q3_least, String q4_most, String q4_least, String q5_most,
			String q5_least, String q6_most, String q6_least, String q7_most,
			String q7_least) {
		super();
		this.sessionid = sessionid;
		this.q1_most = q1_most;
		this.q1_least = q1_least;
		this.q2_most = q2_most;
		this.q2_least = q2_least;
		this.q3_most = q3_most;
		this.q3_least = q3_least;
		this.q4_most = q4_most;
		this.q4_least = q4_least;
		this.q5_most = q5_most;
		this.q5_least = q5_least;
		this.q6_most = q6_most;
		this.q6_least = q6_least;
		this.q7_most = q7_most;
		this.q7_least = q7_least;
	}
	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}
	/**
	 * @return the q1_most
	 */
	public String getQ1_most() {
		if(q1_most==null)
			return "Still Missing";
		return q1_most;
	}
	/**
	 * @return the q1_least
	 */
	public String getQ1_least() {
		if(q1_least==null)
			return "Still Missing";
		return q1_least;
	}
	/**
	 * @return the q2_most
	 */
	public String getQ2_most() {
		if(q2_most==null)
			return "Still Missing";
		return q2_most;
	}
	/**
	 * @return the q2_least
	 */
	public String getQ2_least() {
		if(q2_least==null)
			return "Still Missing";
		return q2_least;
	}
	/**
	 * @return the q3_most
	 */
	public String getQ3_most() {
		if(q3_most==null)
			return "Still Missing";
		return q3_most;
	}
	/**
	 * @return the q3_least
	 */
	public String getQ3_least() {
		if(q3_least==null)
			return "Still Missing";
		return q3_least;
	}
	/**
	 * @return the q4_most
	 */
	public String getQ4_most() {
		if(q4_most==null)
			return "Still Missing";
		return q4_most;
	}
	/**
	 * @return the q4_least
	 */
	public String getQ4_least() {
		if(q4_least==null)
			return "Still Missing";
		return q4_least;
	}
	/**
	 * @return the q5_most
	 */
	public String getQ5_most() {
		if(q5_most==null)
			return "Still Missing";
		return q5_most;
	}
	/**
	 * @return the q5_least
	 */
	public String getQ5_least() {
		if(q5_least==null)
			return "Still Missing";
		return q5_least;
	}
	/**
	 * @return the q6_most
	 */
	public String getQ6_most() {
		if(q6_most==null)
			return "Still Missing";
		return q6_most;
	}
	/**
	 * @return the q6_least
	 */
	public String getQ6_least() {
		if(q6_least==null)
			return "Still Missing";
		return q6_least;
	}
	/**
	 * @return the q7_most
	 */
	public String getQ7_most() {
		if(q7_most==null)
			return "Still Missing";
		return q7_most;
	}
	/**
	 * @return the q7_least
	 */
	public String getQ7_least() {
		if(q7_least==null)
			return "Still Missing";
		return q7_least;
	}
	
	
	
	

}
