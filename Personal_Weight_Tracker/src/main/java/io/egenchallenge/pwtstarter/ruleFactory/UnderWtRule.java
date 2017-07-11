package io.egenchallenge.pwtstarter.ruleFactory;

import org.easyrules.annotation.Action;
import org.easyrules.annotation.Condition;
import org.easyrules.annotation.Rule;
import org.springframework.beans.factory.annotation.Autowired;

import io.egenchallenge.pwtstarter.dao.AlertDao;
import io.egenchallenge.pwtstarter.dao.MetricDao;
import io.egenchallenge.pwtstarter.model.Alert;
import io.egenchallenge.pwtstarter.model.Metric;
/**
 * 
 * Rule for UnderWeight
 * @author Madhusudan Hanagal
 *
 */
@Rule(name = "UWR", description = "Rule for checking the underweight for a personal. If underweight then create alert and make an entry "
		+ " into db.")
public class UnderWtRule {
	
	
	/**
	 * Rule: if the weight of the person shoots 10% over his base weight
	 * @return
	 */
	AlertDao alertRepoDao;
	MetricDao metricRepoDao;
	
	int baseWeight = 140;
	
	Metric recentWeight;
	
	
	/**
	 * Condition Rule statement
	 * @return
	 */
	@Condition
	public boolean checkOWR(){
		metricRepoDao = new MetricDao();
		recentWeight = metricRepoDao.getRecentWeight("-timeStamp");
		return recentWeight.getValue()<((float)baseWeight*0.9);
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
		newAlert.setUserStatus("User is Under Weight (Below Base weight)");
		alertRepoDao.push(newAlert);
	}
}
