package org.afelo.questionnaire.db;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import javax.jdo.PersistenceManager;
import javax.jdo.Query;

import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.KeyFactory;

public class DBDao {
	
	
	
	
	public boolean saveUserDentalExp(String sessionid, String type, String lose_tooth,
			String num_teeth, String replace_front_teeth,
			String replace_back_teeth, String treatment, String where, String other_where){
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean flag = true;
		Query query = pm.newQuery(UserDentalExpDB.class, "sessionid=='" + sessionid + "'");
		try {
			List<UserDentalExpDB> results = (List<UserDentalExpDB>) query.execute(query);
			if (results.isEmpty()) {
				UserDentalExpDB udedb = new UserDentalExpDB(sessionid, type, lose_tooth,
						num_teeth, replace_front_teeth,replace_back_teeth, treatment, where,other_where);
				pm.makePersistent(udedb);

			} else {
				flag = false;
			}
		} finally {
			query.closeAll();
		}
		
		
		return flag;
	}
	
	public boolean saveUserMissingTooth(String sessionid, String look, String other_look,String eating,
			String other_eating, String comfort, String other_comfort,
			String time_restored, String time_last, String risks,
			String other_risks, String cost_replacement, String other_cost_replacement,String remove,
			String fix, String implant, String max_pay, String reason_not_pay, String other_reason) { 
		// TODO Auto-generated method stub
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean flag = true;
		Query query = pm.newQuery(UserMissingToothDB.class, "sessionid=='" + sessionid + "'");
		try {
			List<UserMissingToothDB> results = (List<UserMissingToothDB>) query.execute(query);
			if (results.isEmpty()) {
				UserMissingToothDB umtdb = new UserMissingToothDB(sessionid, look, other_look,eating, other_eating, comfort,other_comfort, time_restored, time_last,
						risks, other_risks, cost_replacement,other_cost_replacement, remove, fix,implant, max_pay, reason_not_pay,other_reason
				);
				pm.makePersistent(umtdb);

			} else {
				flag = false;
			}
		} finally {
			query.closeAll();
		}
		
		
		return flag;
		
	}
	
	public boolean saveQuestionnaireAnswer(String sessionid, String q1_most,
			String q1_least, String q2_most, String q2_least, String q3_most,
			String q3_least, String q4_most, String q4_least, String q5_most,
			String q5_least, String q6_most, String q6_least, String q7_most,
			String q7_least) {
		// TODO Auto-generated method stub
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean flag = true;
		Query query = pm.newQuery(QuestionnaireAnswerDB.class, "sessionid=='" + sessionid + "'");
		try {
			List<QuestionnaireAnswerDB> results = (List<QuestionnaireAnswerDB>) query.execute(query);
			if (results.isEmpty()) {
				QuestionnaireAnswerDB qadb = new QuestionnaireAnswerDB(sessionid, q1_most,
						q1_least, q2_most, q2_least, q3_most,
						q3_least, q4_most, q4_least, q5_most,
						q5_least, q6_most, q6_least, q7_most,
						q7_least);
				pm.makePersistent(qadb);

			} else {
			}
		} finally {
			query.closeAll();
		}
		
		
		return flag;
		
		
		
	}
	
	
	public boolean saveUserDetails(String sessionid, String sex, String age,
	String edcuation, String work, String salary, String comments)  {
		// TODO Auto-generated method stub
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean flag = true;
		Query query = pm.newQuery(UserDetailsDB.class, "sessionid=='" + sessionid + "'");
		try {
			List<UserDetailsDB> results = (List<UserDetailsDB>) query.execute(query);
			if (results.isEmpty()) {
				UserDetailsDB uddb = new UserDetailsDB(sessionid, sex, age, edcuation, work, salary, comments);
				pm.makePersistent(uddb);

			} else {
				flag = false;
			}
		} finally {
			query.closeAll();
		}
		
		
		return flag;
		
	}

	
	
	
	//----------------
	


	public boolean register(String uname, String pwd, String age, String sex) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		boolean flag = true;
		// String query = "select from " + User.class.getName();
		// List<User> users = (List<User>) pm.newQuery(query).execute();
		Query query = pm.newQuery(User.class, "uname=='" + uname + "'");
		try {
			List<User> results = (List<User>) query.execute(query);
			if (results.isEmpty()) {
				Long timeInMillis = System.currentTimeMillis();
				User user = new User(timeInMillis, uname, sex,
						Integer.parseInt(age), null, -1, null, 0, 0, 0, 0, 0);
				pm.makePersistent(user);
				timeInMillis = System.currentTimeMillis();
				Admin_Login vote_login = new Admin_Login(timeInMillis, uname, pwd);
				pm.makePersistent(vote_login);

			} else {
				flag = false;
			}
		} finally {
			query.closeAll();
		}

		return flag;
	}

	/**
	 * login
	 * 
	 * @param uname
	 * @param pwd
	 * @return
	 */
	public boolean login(String uname, String pwd) {
		PersistenceManager pm = PMF.get().getPersistenceManager();
		Query query = pm.newQuery(Admin_Login.class);
		query.setFilter("uname==unameParam && pwd==pwdParam");
		query.declareParameters("String unameParam");
		query.declareParameters("String pwdParam");
		try {
			List<User> results = (List<User>) query.execute(Arrays.asList(uname, pwd));
			if (!results.isEmpty()) {
				return true;
			}
		} finally {
			query.closeAll();
			pm.close();
		}

		return false;
	}

	public void saveUserInfo(String uname, String sex, String age, String edu,
			String occ, String emp, String toothloss, String toothnum,
			String dentaltreat, String prosthesis) {

		Long id = System.currentTimeMillis();

		UserInfo userInfo = new UserInfo(id, uname, sex, age, edu, occ, emp,
				toothloss, toothnum, dentaltreat, prosthesis);
		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(userInfo);
		} finally {
			pm.close();
		}

	}

	public void saveVoteResult(String a_most_q1, String a_most_q2,
			String a_most_q3, String a_most_q4, String a_most_q5,
			String a_most_q6, String a_most_q7, String b_most_q1,
			String b_most_q2, String b_most_q3, String b_most_q4,
			String b_most_q5, String b_most_q6, String b_most_q7,
			String c_most_q1, String c_most_q2, String c_most_q3,
			String c_most_q4, String c_most_q5, String c_most_q6,
			String c_most_q7) {

		Long id = System.currentTimeMillis();

		ChoiceResult voteResult = new ChoiceResult(id, a_most_q1, a_most_q2,
				a_most_q3, a_most_q4, a_most_q5, a_most_q6, a_most_q7,
				b_most_q1, b_most_q2, b_most_q3, b_most_q4, b_most_q5,
				b_most_q6, b_most_q7, c_most_q1, c_most_q2, c_most_q3,
				c_most_q4, c_most_q5, c_most_q6, c_most_q7);

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			pm.makePersistent(voteResult);
		} finally {
			pm.close();
		}
	}

	public void insertData() {
		String look[] = new String[10];
		String eating[] = new String[10];
		String comfort[] = new String[10];
		String worktime[] = new String[10];
		String risk[] = new String[10];
		String cost[] = new String[10];
		
		String look_exp[] = new String[10];
		String eating_exp[] = new String[10];
		String comfort_exp[] = new String[10];
		String worktime_exp[] = new String[10];
		String risk_exp[] = new String[10];
		String cost_exp[] = new String[10];

		look[0] = "Like natural";
		look[1] = "Artificial, fake";
		look_exp[0] = "Like a natural healthy tooth, improve appearance, support shape of face and smiling";
		look_exp[1] = "Noticeable difference between  healthy natural tooth and artificial tooth in colour, shape, etc.";			
		
		eating[0] = "Like natural";
		eating[1] = "Compromised";
		eating_exp[0] ="Eating, tasting, feeling the food like a natural tooth, biting with a bit more care, can swallow all food from the mouth. ";
		eating_exp[1] ="Can not bite tough, sticky food, eating with care, feeling like a foreign object in your mouth, food may get stuck under the prosthesis.";

		comfort[0] = "Fixed, comfortable";
		comfort[1] = "Removable, less comfortable";
		comfort_exp[0] = "Fixed to your teeth or jawbone, secured and stabilised replacement can’t be removed by your self. Comfortable, can be cleaned like natural teeth. ";
		comfort_exp[1] = "Removable, may slip and move in the mouth while eating and speaking, easy to remove, replace and clean, Less comfortable. ";
				

		worktime[0] = "99 out of 100";
		worktime[1] = "90 out of 100";
		worktime[2] = "80 out of 100";
		worktime[3] = "60 out of 100";
		worktime_exp[0] = "5 years later, 99 out of 100 prostheses will still function and in use. 5 year survival rate 99%";
		worktime_exp[1] = "5 years later, 90 out of 100 prostheses will still function and in use. 5 year survival rate 90%";
		worktime_exp[2] = "5 years later, 80 out of 100 prosthesis will still function and in use. 5 year survival rate 80%";
		worktime_exp[3] = "5 years later, 60 out of 100 prosthesis will still function and in use. 5 year survival rate 60%";

		risk[0] = "Complex surgery";
		risk[1] = "Minor surgery";
		risk[2] = "Significant tooth removal";
		risk[3] = "Minor tooth removal";
		risk_exp[0] = "Like two extractions. Need to go through 2 minor surgeries on the jaw bone in order to provide better results. Swelling and bruising may develop after treatment for 7-14 days, but preserves jaw in long term and does not grind/drill other teeth.";
		risk_exp[1] = "Like an extraction. Need to go through minor surgery on the jaw bone in order to provide better results. Swelling and bruising may develop after treatment for 7-14 days, but preserves jaw in long term and does not grind/drill other teeth.";
		risk_exp[2] = "Preparation, like a big filling. Need to remove significant  amount of your natural teeth hard tissue in order to place such a  prosthesis, secondary decay may develop in a few years, may experience jaw bone loss on the missing teeth site, but no swelling";
		risk_exp[3] = "Preparation, like a small filling.  Need to remove small amount of natural teeth, secondary caries may develop in a few years, may experience jaw bone loss on the missing teeth site, but no swelling";
		

		cost[0] = "£ 250";
		cost[1] = "£ 500";
		cost[2] = "£ 2000";
		cost[3] = "£ 3000";
		cost_exp[0]  = "250 pounds will need to be paid. ";
		cost_exp[1]  = "500 pounds will need to be paid. ";
		cost_exp[2]  = "2000 pounds will need to be paid. ";
		cost_exp[3]  = "3000 pounds will need to be paid. ";

		Choice choice[] = new Choice[200];
		int i = 0; // id can't be zero, so start from 1

		// Questionnaire 1
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[3], risk[1], cost[0], look_exp[0], eating_exp[1], comfort_exp[0],
				worktime_exp[3], risk_exp[2], cost_exp[0],new Long(1), new Long(1));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[0],
				worktime[3], risk[2], cost[0],look_exp[0], eating_exp[1], comfort_exp[0],
				worktime_exp[3], risk_exp[2], cost_exp[0], new Long(1), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[0], risk[3], cost[2],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[0], risk_exp[3], cost_exp[2], new Long(1), new Long(1));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null, new Long(1), new Long(1));

		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[2], risk[0], cost[0],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[0], cost_exp[0], new Long(2), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[1], risk[2], cost[2],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[1], risk_exp[2], cost_exp[2], new Long(2), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[2], risk[1], cost[2],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[1], cost_exp[2], new Long(2), new Long(1));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(2), new Long(1));

		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[1], risk[0], cost[2], look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[0], cost_exp[2], new Long(3), new Long(1));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[0],
				worktime[0], risk[3], cost[0],look_exp[0], eating_exp[1], comfort_exp[0],
				worktime_exp[0], risk_exp[3], cost_exp[0], new Long(3), new Long(1));
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[1],
				worktime[1], risk[2], cost[0],look_exp[0], eating_exp[0], comfort_exp[1],
				worktime_exp[1], risk_exp[2], cost_exp[0], new Long(3), new Long(1));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(3), new Long(1));

		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[2], risk[0], cost[2],look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[0], cost_exp[2], new Long(4), new Long(1));
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[1],
				worktime[1], risk[3], cost[1],look_exp[0], eating_exp[0], comfort_exp[1],
				worktime_exp[1], risk_exp[3], cost_exp[1], new Long(4), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[0], risk[2], cost[0],look_exp[1], eating_exp[1], comfort_exp[0],
				worktime_exp[0], risk_exp[2], cost_exp[0], new Long(4), new Long(1));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(4), new Long(1));

		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[0], risk[1], cost[0],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[0], risk_exp[1], cost_exp[0], new Long(5), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[3], risk[3], cost[3],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[3], risk_exp[3], cost_exp[3], new Long(5), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[1], risk[2], cost[0],look_exp[1], eating_exp[1], comfort_exp[0],
				worktime_exp[1], risk_exp[2], cost_exp[0], new Long(5), new Long(1));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(5), new Long(1));

		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[1], risk[0], cost[3],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[0], cost_exp[3], new Long(6), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[3], risk[2], cost[1],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[3], risk_exp[2], cost_exp[1], new Long(6), new Long(1));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[2], risk[3], cost[2], look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[3], cost_exp[2],new Long(6), new Long(1));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(6), new Long(1));

		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[0], risk[1], cost[1], look_exp[1], eating_exp[1], comfort_exp[0],
				worktime_exp[0], risk_exp[1], cost_exp[1], new Long(7), new Long(1));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[3], risk[2], cost[3],look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[3], risk_exp[2], cost_exp[3], new Long(7), new Long(1));
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[1], risk[3], cost[1],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[3], cost_exp[1], new Long(7), new Long(1));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(7), new Long(1));

		// Questionnaire 2

		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[3], risk[1], cost[1],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[3], risk_exp[1], cost_exp[1], new Long(1), new Long(2));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[0],
				worktime[1], risk[3], cost[1],look_exp[0], eating_exp[1], comfort_exp[0],
				worktime_exp[1], risk_exp[3], cost_exp[1], new Long(1), new Long(2));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[3], risk[3], cost[3],look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[3], risk_exp[3], cost_exp[3], new Long(1), new Long(2));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(1), new Long(2));

		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[1],
				worktime[3], risk[1], cost[1],look_exp[0], eating_exp[0], comfort_exp[1],
				worktime_exp[3], risk_exp[1], cost_exp[1], new Long(2), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[0], risk[2], cost[1],look_exp[1], eating_exp[1], comfort_exp[0],
				worktime_exp[0], risk_exp[2], cost_exp[1], new Long(2), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[2], risk[2], cost[2],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[2], risk_exp[2], cost_exp[2], new Long(2), new Long(2));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(2), new Long(2));

		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[2], risk[1], cost[3],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[1], cost_exp[3], new Long(3), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[1], risk[2], cost[2],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[2], cost_exp[2], new Long(3), new Long(2));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[3], risk[3], cost[3],look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[3], risk_exp[3], cost_exp[3], new Long(3), new Long(2));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(3), new Long(2));

		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[0],
				worktime[3], risk[1], cost[1],look_exp[0], eating_exp[1], comfort_exp[0],
				worktime_exp[3], risk_exp[1], cost_exp[1], new Long(4), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[0], risk[3], cost[1],look_exp[1], eating_exp[1], comfort_exp[0],
				worktime_exp[0], risk_exp[3], cost_exp[1], new Long(4), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[1], risk[2], cost[1],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[2], cost_exp[1], new Long(4), new Long(2));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(4), new Long(2));

		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[2], risk[0], cost[0],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[2], risk_exp[0], cost_exp[0], new Long(5), new Long(2));
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[1],
				worktime[0], risk[2], cost[0], look_exp[0], eating_exp[0], comfort_exp[1],
				worktime_exp[0], risk_exp[2], cost_exp[0],new Long(5), new Long(2));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[0],
				worktime[3], risk[3], cost[1],look_exp[0], eating_exp[1], comfort_exp[0],
				worktime_exp[3], risk_exp[3], cost_exp[1], new Long(5), new Long(2));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(5), new Long(2));

		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[1], risk[0], cost[2],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[0], cost_exp[2], new Long(6), new Long(2));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[0], risk[2], cost[0],look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[0], risk_exp[2], cost_exp[0], new Long(6), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[3], risk[3], cost[3],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[3], risk_exp[3], cost_exp[3], new Long(6), new Long(2));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(6), new Long(2));

		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[2], risk[1], cost[0], look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[1], cost_exp[0],new Long(7), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[2], risk[3], cost[3],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[3], cost_exp[3], new Long(7), new Long(2));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[2], risk[2], cost[1],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[2], risk_exp[2], cost_exp[1], new Long(7), new Long(2));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(7), new Long(2));

		// questionnaire 3
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[1], risk[1], cost[0],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[1], cost_exp[0], new Long(1), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[0], risk[3], cost[3],look_exp[1], eating_exp[1], comfort_exp[0],
				worktime_exp[0], risk_exp[3], cost_exp[3], new Long(1), new Long(3));
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[1],
				worktime[1], risk[2], cost[2],look_exp[0], eating_exp[0], comfort_exp[1],
				worktime_exp[1], risk_exp[2], cost_exp[2], new Long(1), new Long(3));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(1), new Long(3));

		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[3], risk[0], cost[1],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[3], risk_exp[0], cost_exp[1], new Long(2), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[1],
				worktime[1], risk[3], cost[3],look_exp[1], eating_exp[0], comfort_exp[1],
				worktime_exp[1], risk_exp[3], cost_exp[3], new Long(2), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[0],
				worktime[0], risk[3], cost[1],look_exp[1], eating_exp[1], comfort_exp[0],
				worktime_exp[0], risk_exp[3], cost_exp[1], new Long(2), new Long(3));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(2), new Long(3));

		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[0], risk[0], cost[3],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[0], risk_exp[0], cost_exp[3], new Long(3), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[2], risk[3], cost[0],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[3], cost_exp[0], new Long(3), new Long(3));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[2], risk[3], cost[2],look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[3], cost_exp[2], new Long(3), new Long(3));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(3), new Long(3));

		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[0], risk[1], cost[1],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[0], risk_exp[1], cost_exp[1], new Long(4), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[3], risk[2], cost[2],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[3], risk_exp[2], cost_exp[2], new Long(4), new Long(3));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[0],
				worktime[1], risk[3], cost[1],look_exp[0], eating_exp[1], comfort_exp[0],
				worktime_exp[1], risk_exp[3], cost_exp[1], new Long(4), new Long(3));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(4), new Long(3));

		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[3], risk[1], cost[2],look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[3], risk_exp[1], cost_exp[2], new Long(5), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[1], risk[2], cost[1],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[2], cost_exp[1], new Long(5), new Long(3));
		choice[i] = new Choice(new Long(++i), look[0], eating[1], comfort[1],
				worktime[3], risk[3], cost[2], look_exp[0], eating_exp[1], comfort_exp[1],
				worktime_exp[3], risk_exp[3], cost_exp[2],new Long(5), new Long(3));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(5), new Long(3));

		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[1], risk[1], cost[2],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[1], risk_exp[1], cost_exp[2], new Long(6), new Long(3));
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[0], risk[3], cost[2],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[0], risk_exp[3], cost_exp[2], new Long(6), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[0], comfort[0],
				worktime[2], risk[3], cost[3],look_exp[1], eating_exp[0], comfort_exp[0],
				worktime_exp[2], risk_exp[3], cost_exp[3], new Long(6), new Long(3));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null,null, null, null, null, null,
				null, new Long(6), new Long(3));

		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[0], risk[0], cost[3],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[0], risk_exp[0], cost_exp[3], new Long(7), new Long(3));
		choice[i] = new Choice(new Long(++i), look[1], eating[1], comfort[1],
				worktime[2], risk[3], cost[0],look_exp[1], eating_exp[1], comfort_exp[1],
				worktime_exp[2], risk_exp[3], cost_exp[0], new Long(7), new Long(3));
		choice[i] = new Choice(new Long(++i), look[0], eating[0], comfort[0],
				worktime[1], risk[2], cost[3],look_exp[0], eating_exp[0], comfort_exp[0],
				worktime_exp[1], risk_exp[2], cost_exp[3], new Long(7), new Long(3));
		choice[i] = new Choice(new Long(++i), null, null, null, null, null,
				null, null, null, null, null, null,
				null,new Long(7), new Long(3));
		
		
		//questionnaire 4
		choice[i] = new Choice(new Long(++i),look[1],eating[0],comfort[0],worktime[1], 
				risk[0],cost[0],look_exp[1],eating_exp[0],comfort_exp[0],worktime_exp[1], 
				risk_exp[0],cost_exp[0],new Long(1),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[1],comfort[1],worktime[3], 
				risk[2],cost[3],look_exp[0],eating_exp[1],comfort_exp[1],worktime_exp[3], 
				risk_exp[2],cost_exp[3],new Long(1),new Long(4));
choice[i] = new Choice(new Long(++i),look[1],eating[0],comfort[1],worktime[0], 
				risk[3],cost[3],look_exp[1],eating_exp[0],comfort_exp[1],worktime_exp[0], 
				risk_exp[3],cost_exp[3],new Long(1),new Long(4));
choice[i] = new Choice(new Long(++i),null,null,null,null,null,null,null,null,null,null,null,null,
								new Long(1),new Long(4));

choice[i] = new Choice(new Long(++i),look[1],eating[1],comfort[1],worktime[3], 
				risk[0],cost[1],look_exp[1],eating_exp[1],comfort_exp[1],worktime_exp[3], 
				risk_exp[0],cost_exp[1],new Long(2),new Long(4));
choice[i] = new Choice(new Long(++i),look[1],eating[0],comfort[0],worktime[2], 
				risk[2],cost[2],look_exp[1],eating_exp[0],comfort_exp[0],worktime_exp[2], 
				risk_exp[2],cost_exp[2],new Long(2),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[0],comfort[0],worktime[2], 
				risk[2],cost[0],look_exp[0],eating_exp[0],comfort_exp[0],worktime_exp[2], 
				risk_exp[2],cost_exp[0],new Long(2),new Long(4));
choice[i] = new Choice(new Long(++i),null,null,null,null,null,null,null,null,null,null,null,null,
	new Long(2),new Long(4));

choice[i] = new Choice(new Long(++i),look[0],eating[0],comfort[0],worktime[0], 
	risk[0],cost[3],look_exp[0],eating_exp[0],comfort_exp[0],worktime_exp[0], 
	risk_exp[0],cost_exp[3],new Long(3),new Long(4));
choice[i] = new Choice(new Long(++i),look[1],eating[0],comfort[1],worktime[1], 
	risk[2],cost[0],look_exp[1],eating_exp[0],comfort_exp[1],worktime_exp[1], 
	risk_exp[2],cost_exp[0],new Long(3),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[1],comfort[0],worktime[3], 
	risk[2],cost[0],look_exp[0],eating_exp[1],comfort_exp[0],worktime_exp[3], 
	risk_exp[2],cost_exp[0],new Long(3),new Long(4));
choice[i] = new Choice(new Long(++i),null,null,null,null,null,null,null,null,null,null,null,null,
	new Long(3),new Long(4));

choice[i] = new Choice(new Long(++i),look[0],eating[1],comfort[1],worktime[2], 
	risk[1],cost[2],look_exp[0],eating_exp[1],comfort_exp[1],worktime_exp[2], 
	risk_exp[1],cost_exp[2],new Long(4),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[0],comfort[0],worktime[2], 
	risk[3],cost[0],look_exp[0],eating_exp[0],comfort_exp[0],worktime_exp[2], 
	risk_exp[3],cost_exp[0],new Long(4),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[1],comfort[1],worktime[0], 
	risk[2],cost[0],look_exp[0],eating_exp[1],comfort_exp[1],worktime_exp[0], 
	risk_exp[2],cost_exp[0],new Long(4),new Long(4));
choice[i] = new Choice(new Long(++i),null,null,null,null,null,null,null,null,null,null,null,null,
	new Long(4),new Long(4));

choice[i] = new Choice(new Long(++i),look[1],eating[1],comfort[0],worktime[1], 
	risk[0],cost[0],look_exp[1],eating_exp[1],comfort_exp[0],worktime_exp[1], 
	risk_exp[0],cost_exp[0],new Long(5),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[1],comfort[0],worktime[2], 
	risk[3],cost[2],look_exp[0],eating_exp[1],comfort_exp[0],worktime_exp[2], 
	risk_exp[3],cost_exp[2],new Long(5),new Long(4));
choice[i] = new Choice(new Long(++i),look[1],eating[0],comfort[1],worktime[3], 
	risk[2],cost[3],look_exp[1],eating_exp[0],comfort_exp[1],worktime_exp[3], 
	risk_exp[2],cost_exp[3],new Long(5),new Long(4));
choice[i] = new Choice(new Long(++i),null,null,null,null,null,null,null,null,null,null,null,null,
	new Long(5),new Long(4));

choice[i] = new Choice(new Long(++i),look[1],eating[1],comfort[1],worktime[2], 
	risk[1],cost[2],look_exp[1],eating_exp[1],comfort_exp[1],worktime_exp[2], 
	risk_exp[1],cost_exp[2],new Long(6),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[1],comfort[1],worktime[3], 
	risk[2],cost[2],look_exp[0],eating_exp[1],comfort_exp[1],worktime_exp[3], 
	risk_exp[2],cost_exp[2],new Long(6),new Long(4));
choice[i] = new Choice(new Long(++i),look[1],eating[0],comfort[0],worktime[0], 
	risk[2],cost[0],look_exp[1],eating_exp[0],comfort_exp[0],worktime_exp[0], 
	risk_exp[2],cost_exp[0],new Long(6),new Long(4));
choice[i] = new Choice(new Long(++i),null,null,null,null,null,null,null,null,null,null,null,null,
	new Long(6),new Long(4));

choice[i] = new Choice(new Long(++i),look[0],eating[0],comfort[0],worktime[0], 
	risk[0],cost[3],look_exp[0],eating_exp[0],comfort_exp[0],worktime_exp[0], 
	risk_exp[0],cost_exp[3],new Long(7),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[0],comfort[1],worktime[2], 
	risk[2],cost[0],look_exp[0],eating_exp[0],comfort_exp[1],worktime_exp[2], 
	risk_exp[2],cost_exp[0],new Long(7),new Long(4));
choice[i] = new Choice(new Long(++i),look[0],eating[1],comfort[1],worktime[0], 
	risk[3],cost[0],look_exp[0],eating_exp[1],comfort_exp[1],worktime_exp[0], 
	risk_exp[3],cost_exp[0],new Long(7),new Long(4));
choice[i] = new Choice(new Long(++i),null,null,null,null,null,null,null,null,null,null,null,null,
	new Long(7),new Long(4));
		
		
		

		int choice_size = i + 1;
		System.out.println(i);

		PersistenceManager pm = PMF.get().getPersistenceManager();
		try {
			// id can't be zero
			for (i = 0; i < choice_size; i++) {
				pm.makePersistent(choice[i]);
			}

		} finally {
			pm.close();
		}

	}






}
