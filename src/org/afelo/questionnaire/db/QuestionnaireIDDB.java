package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class QuestionnaireIDDB {

	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private String sessionid;
	@Persistent
	private String questionnaireID;
	public QuestionnaireIDDB(String sessionid, String questionnaireID) {
		super();
		this.sessionid = sessionid;
		this.questionnaireID = questionnaireID;
	}
	/**
	 * @return the sessionid
	 */
	public String getSessionid() {
		return sessionid;
	}
	/**
	 * @return the questionnaireID
	 */
	public String getQuestionnaireID() {
		return questionnaireID;
	}

	

	
	
}
