package io.egenchallenge.pwtstarter.ruleFactory;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;

import io.egenchallenge.pwtstarter.dao.AlertDao;
import io.egenchallenge.pwtstarter.dao.MetricDao;
import io.egenchallenge.pwtstarter.model.Alert;
import io.egenchallenge.pwtstarter.model.Metric;
/**
 * 
 * Rule for OverWeight
 * @author Madhusudan Hanagal
 *
 */
@Rule(name="OWR", description = "Rule for checking the overweight for a personal. If overweight then create alert and make an entry "
		+ " into db.")
public class OverWtRule {
	
	/**
	 * Rule: if the weight of the person shoots 10% over his base weight
	 * @return
	 */
	AlertDao alertRepoDao;
	MetricDao metricRepoDao;
	
	public int baseWeight = 140;
	
	Metric recentWeight;

	/**
	 * Condition Rule statement
	 * @return
	 */
	@Condition
	public boolean checkOWR(){
		metricRepoDao = new MetricDao();
		recentWeight = metricRepoDao.getRecentWeight("-timeStamp");
		System.out.println(recentWeight+" Dhoom");
		return recentWeight.getValue()>((float)baseWeight*1.1);
	}
	/**
	 * Action after rule is executed
	 */
	@Action
	public void createAlert(){
		alertRepoDao = new AlertDao();
		Alert newAlert = new Alert();
		newAlert.setTimeStamp(recentWeight.getTimeStamp());
		newAlert.setValue(recentWeight.getValue());
		newAlert.setUserStatus("User is Over Weight (Above Base weight)");
		alertRepoDao.push(newAlert);
	}
}
