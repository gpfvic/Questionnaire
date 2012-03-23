package org.afelo.questionnaire.db;

import javax.jdo.annotations.IdGeneratorStrategy;
import javax.jdo.annotations.PersistenceCapable;
import javax.jdo.annotations.Persistent;
import javax.jdo.annotations.PrimaryKey;

import com.google.appengine.api.datastore.Key;



@PersistenceCapable
public class ChoiceResult {
	
	@PrimaryKey
	@Persistent(valueStrategy=IdGeneratorStrategy.IDENTITY)
	private Long id;
	@Persistent
	private String a_most_q1;
	@Persistent
	private String b_most_q1;
	@Persistent
	private String c_most_q1;
	@Persistent
	private String a_most_q2;
	@Persistent
	private String b_most_q2;
	@Persistent
	private String c_most_q2;
	@Persistent
	private String a_most_q3;
	@Persistent
	private String b_most_q3;
	@Persistent
	private String c_most_q3;
	@Persistent
	private String a_most_q4;
	@Persistent
	private String b_most_q4;
	@Persistent
	private String c_most_q4;
	@Persistent
	private String a_most_q5;
	@Persistent
	private String b_most_q5;
	@Persistent
	private String c_most_q5;
	@Persistent
	private String a_most_q6;
	@Persistent
	private String b_most_q6;
	@Persistent
	private String c_most_q6;
	@Persistent
	private String a_most_q7;
	@Persistent
	private String b_most_q7;
	@Persistent
	private String c_most_q7;
	
	
	
	
	
	
	public ChoiceResult(Long id, String a_most_q1, String b_most_q1,
			String c_most_q1, String a_most_q2, String b_most_q2,
			String c_most_q2, String a_most_q3, String b_most_q3,
			String c_most_q3, String a_most_q4, String b_most_q4,
			String c_most_q4, String a_most_q5, String b_most_q5,
			String c_most_q5, String a_most_q6, String b_most_q6,
			String c_most_q6, String a_most_q7, String b_most_q7,
			String c_most_q7) {
		super();
		this.id = id;
		this.a_most_q1 = a_most_q1;
		this.b_most_q1 = b_most_q1;
		this.c_most_q1 = c_most_q1;
		this.a_most_q2 = a_most_q2;
		this.b_most_q2 = b_most_q2;
		this.c_most_q2 = c_most_q2;
		this.a_most_q3 = a_most_q3;
		this.b_most_q3 = b_most_q3;
		this.c_most_q3 = c_most_q3;
		this.a_most_q4 = a_most_q4;
		this.b_most_q4 = b_most_q4;
		this.c_most_q4 = c_most_q4;
		this.a_most_q5 = a_most_q5;
		this.b_most_q5 = b_most_q5;
		this.c_most_q5 = c_most_q5;
		this.a_most_q6 = a_most_q6;
		this.b_most_q6 = b_most_q6;
		this.c_most_q6 = c_most_q6;
		this.a_most_q7 = a_most_q7;
		this.b_most_q7 = b_most_q7;
		this.c_most_q7 = c_most_q7;
	}
	/**
	 * @return the key
	 */
	public Long getId() {
		return id;
	}
	/**
	 * @param key the key to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the a_most_q1
	 */
	public String getA_most_q1() {
		return a_most_q1;
	}
	/**
	 * @param a_most_q1 the a_most_q1 to set
	 */
	public void setA_most_q1(String a_most_q1) {
		this.a_most_q1 = a_most_q1;
	}
	/**
	 * @return the b_most_q1
	 */
	public String getB_most_q1() {
		return b_most_q1;
	}
	/**
	 * @param b_most_q1 the b_most_q1 to set
	 */
	public void setB_most_q1(String b_most_q1) {
		this.b_most_q1 = b_most_q1;
	}
	/**
	 * @return the c_most_q1
	 */
	public String getC_most_q1() {
		return c_most_q1;
	}
	/**
	 * @param c_most_q1 the c_most_q1 to set
	 */
	public void setC_most_q1(String c_most_q1) {
		this.c_most_q1 = c_most_q1;
	}
	/**
	 * @return the a_most_q2
	 */
	public String getA_most_q2() {
		return a_most_q2;
	}
	/**
	 * @param a_most_q2 the a_most_q2 to set
	 */
	public void setA_most_q2(String a_most_q2) {
		this.a_most_q2 = a_most_q2;
	}
	/**
	 * @return the b_most_q2
	 */
	public String getB_most_q2() {
		return b_most_q2;
	}
	/**
	 * @param b_most_q2 the b_most_q2 to set
	 */
	public void setB_most_q2(String b_most_q2) {
		this.b_most_q2 = b_most_q2;
	}
	/**
	 * @return the c_most_q2
	 */
	public String getC_most_q2() {
		return c_most_q2;
	}
	/**
	 * @param c_most_q2 the c_most_q2 to set
	 */
	public void setC_most_q2(String c_most_q2) {
		this.c_most_q2 = c_most_q2;
	}
	/**
	 * @return the a_most_q3
	 */
	public String getA_most_q3() {
		return a_most_q3;
	}
	/**
	 * @param a_most_q3 the a_most_q3 to set
	 */
	public void setA_most_q3(String a_most_q3) {
		this.a_most_q3 = a_most_q3;
	}
	/**
	 * @return the b_most_q3
	 */
	public String getB_most_q3() {
		return b_most_q3;
	}
	/**
	 * @param b_most_q3 the b_most_q3 to set
	 */
	public void setB_most_q3(String b_most_q3) {
		this.b_most_q3 = b_most_q3;
	}
	/**
	 * @return the c_most_q3
	 */
	public String getC_most_q3() {
		return c_most_q3;
	}
	/**
	 * @param c_most_q3 the c_most_q3 to set
	 */
	public void setC_most_q3(String c_most_q3) {
		this.c_most_q3 = c_most_q3;
	}
	/**
	 * @return the a_most_q4
	 */
	public String getA_most_q4() {
		return a_most_q4;
	}
	/**
	 * @param a_most_q4 the a_most_q4 to set
	 */
	public void setA_most_q4(String a_most_q4) {
		this.a_most_q4 = a_most_q4;
	}
	/**
	 * @return the b_most_q4
	 */
	public String getB_most_q4() {
		return b_most_q4;
	}
	/**
	 * @param b_most_q4 the b_most_q4 to set
	 */
	public void setB_most_q4(String b_most_q4) {
		this.b_most_q4 = b_most_q4;
	}
	/**
	 * @return the c_most_q4
	 */
	public String getC_most_q4() {
		return c_most_q4;
	}
	/**
	 * @param c_most_q4 the c_most_q4 to set
	 */
	public void setC_most_q4(String c_most_q4) {
		this.c_most_q4 = c_most_q4;
	}
	/**
	 * @return the a_most_q5
	 */
	public String getA_most_q5() {
		return a_most_q5;
	}
	/**
	 * @param a_most_q5 the a_most_q5 to set
	 */
	public void setA_most_q5(String a_most_q5) {
		this.a_most_q5 = a_most_q5;
	}
	/**
	 * @return the b_most_q5
	 */
	public String getB_most_q5() {
		return b_most_q5;
	}
	/**
	 * @param b_most_q5 the b_most_q5 to set
	 */
	public void setB_most_q5(String b_most_q5) {
		this.b_most_q5 = b_most_q5;
	}
	/**
	 * @return the c_most_q5
	 */
	public String getC_most_q5() {
		return c_most_q5;
	}
	/**
	 * @param c_most_q5 the c_most_q5 to set
	 */
	public void setC_most_q5(String c_most_q5) {
		this.c_most_q5 = c_most_q5;
	}
	/**
	 * @return the a_most_q6
	 */
	public String getA_most_q6() {
		return a_most_q6;
	}
	/**
	 * @param a_most_q6 the a_most_q6 to set
	 */
	public void setA_most_q6(String a_most_q6) {
		this.a_most_q6 = a_most_q6;
	}
	/**
	 * @return the b_most_q6
	 */
	public String getB_most_q6() {
		return b_most_q6;
	}
	/**
	 * @param b_most_q6 the b_most_q6 to set
	 */
	public void setB_most_q6(String b_most_q6) {
		this.b_most_q6 = b_most_q6;
	}
	/**
	 * @return the c_most_q6
	 */
	public String getC_most_q6() {
		return c_most_q6;
	}
	/**
	 * @param c_most_q6 the c_most_q6 to set
	 */
	public void setC_most_q6(String c_most_q6) {
		this.c_most_q6 = c_most_q6;
	}
	/**
	 * @return the a_most_q7
	 */
	public String getA_most_q7() {
		return a_most_q7;
	}
	/**
	 * @param a_most_q7 the a_most_q7 to set
	 */
	public void setA_most_q7(String a_most_q7) {
		this.a_most_q7 = a_most_q7;
	}
	/**
	 * @return the b_most_q7
	 */
	public String getB_most_q7() {
		return b_most_q7;
	}
	/**
	 * @param b_most_q7 the b_most_q7 to set
	 */
	public void setB_most_q7(String b_most_q7) {
		this.b_most_q7 = b_most_q7;
	}
	/**
	 * @return the c_most_q7
	 */
	public String getC_most_q7() {
		return c_most_q7;
	}
	/**
	 * @param c_most_q7 the c_most_q7 to set
	 */
	public void setC_most_q7(String c_most_q7) {
		this.c_most_q7 = c_most_q7;
	}
	
	
	
	

}
