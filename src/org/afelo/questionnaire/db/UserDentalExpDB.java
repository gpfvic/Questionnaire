package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class UserDentalExpDB {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String sessionid;
	@Persistent
	private String type;
	@Persistent
	private String lose_tooth;
	@Persistent
	private String num_teeth;
	@Persistent
	private String replace_front_teeth;
	@Persistent
	private String replace_back_teeth;
	@Persistent
	private String treatment;
	@Persistent
	private String where;
	@Persistent
	private String other_where;
	
	
	public UserDentalExpDB(String sessionid, String type, String lose_tooth,
			String num_teeth, String replace_front_teeth,
			String replace_back_teeth, String treatment, String where, String other_where) {
		super();
		this.sessionid = sessionid;
		this.type = type;
		this.lose_tooth = lose_tooth;
		this.num_teeth = num_teeth;
		this.replace_front_teeth = replace_front_teeth;
		this.replace_back_teeth = replace_back_teeth;
		this.treatment = treatment;
		this.where = where;
		this.other_where = other_where;
	}


	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}


	/**
	 * @param sessionid the sessionid to set
	 */
	public void setSessionid(String sessionid) {
		this.sessionid = sessionid;
	}


	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}


	/**
	 * @param type the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}


	/**
	 * @return the lose_tooth
	 */
	public String getLose_tooth() {
		return lose_tooth;
	}


	/**
	 * @param lose_tooth the lose_tooth to set
	 */
	public void setLose_tooth(String lose_tooth) {
		this.lose_tooth = lose_tooth;
	}


	/**
	 * @return the num_teeth
	 */
	public String getNum_teeth() {
		return num_teeth;
	}


	/**
	 * @param num_teeth the num_teeth to set
	 */
	public void setNum_teeth(String num_teeth) {
		this.num_teeth = num_teeth;
	}


	/**
	 * @return the replace_front_teeth
	 */
	public String getReplace_front_teeth() {
		return replace_front_teeth;
	}


	/**
	 * @param replace_front_teeth the replace_front_teeth to set
	 */
	public void setReplace_front_teeth(String replace_front_teeth) {
		this.replace_front_teeth = replace_front_teeth;
	}


	/**
	 * @return the replace_back_teeth
	 */
	public String getReplace_back_teeth() {
		return replace_back_teeth;
	}


	/**
	 * @param replace_back_teeth the replace_back_teeth to set
	 */
	public void setReplace_back_teeth(String replace_back_teeth) {
		this.replace_back_teeth = replace_back_teeth;
	}


	/**
	 * @return the treatment
	 */
	public String getTreatment() {
		return treatment;
	}


	/**
	 * @param treatment the treatment to set
	 */
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}


	/**
	 * @return the where
	 */
	public String getWhere() {
		return where;
	}


	/**
	 * @param where the where to set
	 */
	public void setWhere(String where) {
		this.where = where;
	}
	
	public String getOtherWhere() {
		if (other_where==null)
			return "";
		return other_where;
	}
	
	

}
