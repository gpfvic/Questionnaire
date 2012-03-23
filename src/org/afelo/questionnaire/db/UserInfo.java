package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

@PersistenceCapable
public class UserInfo {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String uname;
	@Persistent
	private String sex;
	@Persistent
	private String age;
	@Persistent
	private String edu;
	@Persistent
	private String occ;
	@Persistent
	private String emp;
	@Persistent
	private String toothloss;
	@Persistent
	private String toothnum;
	@Persistent
	private String dentaltreat;
	@Persistent
	private String prosthesis;
	
	
	public UserInfo(Long id, String uname, String sex, String age, String edu,
			String occ, String emp, String toothloss, String toothnum,
			String dentaltreat, String prosthesis) {
		super();
		this.id = id;
		this.uname = uname;
		this.sex = sex;
		this.age = age;
		this.edu = edu;
		this.occ = occ;
		this.emp = emp;
		this.toothloss = toothloss;
		this.toothnum = toothnum;
		this.dentaltreat = dentaltreat;
		this.prosthesis = prosthesis;
	}
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
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
	public String getAge() {
		return age;
	}
	/**
	 * @param age the age to set
	 */
	public void setAge(String age) {
		this.age = age;
	}
	/**
	 * @return the edu
	 */
	public String getEdu() {
		return edu;
	}
	/**
	 * @param edu the edu to set
	 */
	public void setEdu(String edu) {
		this.edu = edu;
	}
	/**
	 * @return the occ
	 */
	public String getOcc() {
		return occ;
	}
	/**
	 * @param occ the occ to set
	 */
	public void setOcc(String occ) {
		this.occ = occ;
	}
	/**
	 * @return the emp
	 */
	public String getEmp() {
		return emp;
	}
	/**
	 * @param emp the emp to set
	 */
	public void setEmp(String emp) {
		this.emp = emp;
	}
	/**
	 * @return the toothloss
	 */
	public String getToothloss() {
		return toothloss;
	}
	/**
	 * @param toothloss the toothloss to set
	 */
	public void setToothloss(String toothloss) {
		this.toothloss = toothloss;
	}
	/**
	 * @return the toothnum
	 */
	public String getToothnum() {
		return toothnum;
	}
	/**
	 * @param toothnum the toothnum to set
	 */
	public void setToothnum(String toothnum) {
		this.toothnum = toothnum;
	}
	/**
	 * @return the dentaltreat
	 */
	public String getDentaltreat() {
		return dentaltreat;
	}
	/**
	 * @param dentaltreat the dentaltreat to set
	 */
	public void setDentaltreat(String dentaltreat) {
		this.dentaltreat = dentaltreat;
	}
	/**
	 * @return the prosthesis
	 */
	public String getProsthesis() {
		return prosthesis;
	}
	/**
	 * @param prosthesis the prosthesis to set
	 */
	public void setProsthesis(String prosthesis) {
		this.prosthesis = prosthesis;
	}

	
	
	
}
