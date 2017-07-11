package io.egenchallenge.pwtstarter.dao;

import java.util.List;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import io.egenchallenge.pwtstarter.model.Alert;
import io.egenchallenge.pwtstarter.services.InitServices;

/**
 * Alert Data Access Object Class
 * @author Madhusudan Hanagal
 *
 */
@Component
public class AlertDao {
	Datastore dStoreInstance;
	/**
	 * Initiate dstore Instance
	 */
	public AlertDao() {
		this.dStoreInstance = InitServices.getInstance().getDatastore();
	}
	/**
	 * Push Alerts when happens
	 * @param metric
	 */
	public void push(Alert alert) {
		dStoreInstance.save(alert);
	}
	/**
	 * Read All
	 * @return
	 */
	public List<Alert> read() {
		return dStoreInstance.createQuery(Alert.class).asList();
	}
	/**
	 * Read by range
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public List<Alert> readByTimeRange(long sTime, long eTime) {
		Query<Alert> query = dStoreInstance.createQuery(Alert.class);
		query.and(query.criteria("timeStamp").greaterThanOrEq(sTime), query.criteria("timeStamp").lessThanOrEq(eTime));
		return query.asList();
	}
}
