package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class UserMissingToothDB {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String sessionid;
	@Persistent
	private String look;
	@Persistent
	private String other_look;
	@Persistent
	private String eating;
	@Persistent
	private String other_eating;
	@Persistent
	private String comfort;
	@Persistent
	private String other_comfort;
	@Persistent
	private String time_restored;
	@Persistent
	private String time_last;
	@Persistent
	private String risks;
	@Persistent
	private String other_risks;
	@Persistent
	private String cost_replacement;
	@Persistent
	private String other_cost_replacement;
	@Persistent
	private String remove;
	@Persistent
	private String fix;
	@Persistent
	private String implant;
	@Persistent
	private String max_pay;
	@Persistent
	private String reason_not_pay;
	@Persistent
	private String other_reason;
	public UserMissingToothDB(String sessionid, String look, String other_look,
			String eating, String other_eating, String comfort,
			String other_comfort, String time_restored, String time_last,
			String risks, String other_risks, String cost_replacement,
			String other_cost_replacement, String remove, String fix,
			String implant, String max_pay, String reason_not_pay,
			String other_reason) {
		super();
		this.sessionid = sessionid;
		this.look = look;
		this.other_look = other_look;
		this.eating = eating;
		this.other_eating = other_eating;
		this.comfort = comfort;
		this.other_comfort = other_comfort;
		this.time_restored = time_restored;
		this.time_last = time_last;
		this.risks = risks;
		this.other_risks = other_risks;
		this.cost_replacement = cost_replacement;
		this.other_cost_replacement = other_cost_replacement;
		this.remove = remove;
		this.fix = fix;
		this.implant = implant;
		this.max_pay = max_pay;
		this.reason_not_pay = reason_not_pay;
		this.other_reason = other_reason;
	}
	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}
	/**
	 * @return the look
	 */
	public String getLook() {
		return look;
	}
	/**
	 * @return the other_look
	 */
	public String getOther_look() {
		return other_look;
	}
	/**
	 * @return the eating
	 */
	public String getEating() {
		return eating;
	}
	/**
	 * @return the other_eating
	 */
	public String getOther_eating() {
		return other_eating;
	}
	/**
	 * @return the comfort
	 */
	public String getComfort() {
		return comfort;
	}
	/**
	 * @return the other_comfort
	 */
	public String getOther_comfort() {
		return other_comfort;
	}
	/**
	 * @return the time_restored
	 */
	public String getTime_restored() {
		return time_restored;
	}
	/**
	 * @return the time_last
	 */
	public String getTime_last() {
		return time_last;
	}
	/**
	 * @return the risks
	 */
	public String getRisks() {
		return risks;
	}
	/**
	 * @return the other_risks
	 */
	public String getOther_risks() {
		return other_risks;
	}
	/**
	 * @return the cost_replacement
	 */
	public String getCost_replacement() {
		return cost_replacement;
	}
	/**
	 * @return the other_cost_replacement
	 */
	public String getOther_cost_replacement() {
		return other_cost_replacement;
	}
	/**
	 * @return the remove
	 */
	public String getRemove() {
		return remove;
	}
	/**
	 * @return the fix
	 */
	public String getFix() {
		return fix;
	}
	/**
	 * @return the implant
	 */
	public String getImplant() {
		return implant;
	}
	/**
	 * @return the max_pay
	 */
	public String getMax_pay() {
		return max_pay;
	}
	/**
	 * @return the reason_not_pay
	 */
	public String getReason_not_pay() {
		return reason_not_pay;
	}
	/**
	 * @return the other_reason
	 */
	public String getOther_reason() {
		return other_reason;
	}
	
	
	

}
