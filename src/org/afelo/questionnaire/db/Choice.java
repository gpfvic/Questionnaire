package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;


@PersistenceCapable
public class Choice {

	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String look;
	@Persistent
	private String eating;
	@Persistent
	private String comfort;
	@Persistent
	private String worktime;
	@Persistent
	private String risk;
	@Persistent
	private String cost;
	@Persistent
	private String look_exp;
	@Persistent
	private String eating_exp;
	@Persistent
	private String comfort_exp;
	@Persistent
	private String worktime_exp;
	@Persistent
	private String risk_exp;
	@Persistent
	private String cost_exp;
	@Persistent
	private Long question_id;
	@Persistent
	private Long questionnaire_id;
	public Choice(Long id, String look, String eating, String comfort,
			String worktime, String risk, String cost, String look_exp,
			String eating_exp, String comfort_exp, String worktime_exp,
			String risk_exp, String cost_exp, Long question_id,
			Long questionnaire_id) {
		super();
		this.id = id;
		this.look = look;
		this.eating = eating;
		this.comfort = comfort;
		this.worktime = worktime;
		this.risk = risk;
		this.cost = cost;
		this.look_exp = look_exp;
		this.eating_exp = eating_exp;
		this.comfort_exp = comfort_exp;
		this.worktime_exp = worktime_exp;
		this.risk_exp = risk_exp;
		this.cost_exp = cost_exp;
		this.question_id = question_id;
		this.questionnaire_id = questionnaire_id;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @return the look
	 */
	public String getLook() {
		if(look==null)
			return "Stay Missing";
		return look;
	}
	/**
	 * @return the eating
	 */
	public String getEating() {
		if(eating==null)
			return "Stay Missing";
		return eating;
	}
	/**
	 * @return the comfort
	 */
	public String getComfort() {
		if(comfort==null)
			return "Stay Missing";
		return comfort;
	}
	/**
	 * @return the worktime
	 */
	public String getWorktime() {
		if(worktime==null)
			return "Stay Missing";
		return worktime;
	}
	/**
	 * @return the risk
	 */
	public String getRisk() {
		if(risk==null)
			return "Stay Missing";
		return risk;
	}
	/**
	 * @return the cost
	 */
	public String getCost() {
		if(cost==null)
			return "Stay Missing";
		return cost;
	}
	/**
	 * @return the look_exp
	 */
	public String getLook_exp() {
		if(look_exp==null)
			return "Stay Missing";
		return look_exp;
	}
	/**
	 * @return the eating_exp
	 */
	public String getEating_exp() {
		if(eating_exp==null)
			return "Stay Missing";
		return eating_exp;
	}
	/**
	 * @return the comfort_exp
	 */
	public String getComfort_exp() {
		if(comfort_exp==null)
			return "Stay Missing";
		return comfort_exp;
	}
	/**
	 * @return the worktime_exp
	 */
	public String getWorktime_exp() {
		if(worktime_exp==null)
			return "Stay Missing";
		return worktime_exp;
	}
	/**
	 * @return the risk_exp
	 */
	public String getRisk_exp() {
		if(risk_exp==null)
			return "Stay Missing";
		return risk_exp;
	}
	/**
	 * @return the cost_exp
	 */
	public String getCost_exp() {
		if(cost_exp==null)
			return "Stay Missing";
		return cost_exp;
	}
	/**
	 * @return the question_id
	 */
	public Long getQuestion_id() {
		return question_id;
	}
	/**
	 * @return the questionnaire_id
	 */
	public Long getQuestionnaire_id() {
		return questionnaire_id;
	}

}
