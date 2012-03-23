package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class User {

	public User(Long uid, String uname, String sex, int age, String note,
			int education, String occupation, int employment, int toothloss,
			int toothnum, int dentaltreat, int prosthesis) {
		super();
		this.uid = uid;
		this.uname = uname;
		this.sex = sex;
		this.age = age;
		this.note = note;
		this.education = education;
		this.occupation = occupation;
		this.employment = employment;
		this.toothloss = toothloss;
		this.toothnum = toothnum;
		this.dentaltreat = dentaltreat;
		this.prosthesis = prosthesis;
	}
	@PrimaryKey
	@Persistent(valueStrategy = IdGeneratorStrategy.IDENTITY)
	private Long uid; //pk
	/**
	 * @return the uid
	 */
	public Long getUid() {
		return uid;
	}
	/**
	 * @param uid the uid to set
	 */
	public void setUid(Long uid) {
		this.uid = uid;
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
	 * @return the sex
	 */
	public String getSex() {
		return sex;
	}
	/**
	 * @param sex the sex to set
	 */
	public void setSex(String sex) {
		this.sex = sex;
	}
	/**
	 * @return the age
	 */
	public int getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(int age) {
		this.age = age;
	}
	/**
	 * @return the note
	 */
	public String getNote() {
		return note;
	}
	/**
	 * @param note the note to set
	 */
	public void setNote(String note) {
		this.note = note;
	}
	/**
	 * @return the education
	 */
	public int getEducation() {
		return education;
	}
	/**
	 * @param education the education to set
	 */
	public void setEducation(int education) {
		this.education = education;
	}
	/**
	 * @return the occupation
	 */
	public String getOccupation() {
		return occupation;
	}
	/**
	 * @param occupation the occupation to set
	 */
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	/**
	 * @return the employment
	 */
	public int getEmployment() {
		return employment;
	}
	/**
	 * @param employment the employment to set
	 */
	public void setEmployment(int employment) {
		this.employment = employment;
	}
	/**
	 * @return the toothloss
	 */
	public int getToothloss() {
		return toothloss;
	}
	/**
	 * @param toothloss the toothloss to set
	 */
	public void setToothloss(int toothloss) {
		this.toothloss = toothloss;
	}
	/**
	 * @return the toothnum
	 */
	public int getToothnum() {
		return toothnum;
	}
	/**
	 * @param toothnum the toothnum to set
	 */
	public void setToothnum(int toothnum) {
		this.toothnum = toothnum;
	}
	/**
	 * @return the dentaltreat
	 */
	public int getDentaltreat() {
		return dentaltreat;
	}
	/**
	 * @param dentaltreat the dentaltreat to set
	 */
	public void setDentaltreat(int dentaltreat) {
		this.dentaltreat = dentaltreat;
	}
	/**
	 * @return the prosthesis
	 */
	public int getProsthesis() {
		return prosthesis;
	}
	/**
	 * @param prosthesis the prosthesis to set
	 */
	public void setProsthesis(int prosthesis) {
		this.prosthesis = prosthesis;
	}
	@Persistent
	private String uname;
	@Persistent
	private String sex;
	@Persistent
	private int age;
	@Persistent
	private String note;
	@Persistent
	private int education;
	@Persistent
	private String occupation;
	@Persistent
	private int employment;
	@Persistent
	private int toothloss;
	@Persistent
	private int toothnum;
	@Persistent
	private int dentaltreat;
	@Persistent
	private int prosthesis;
}
