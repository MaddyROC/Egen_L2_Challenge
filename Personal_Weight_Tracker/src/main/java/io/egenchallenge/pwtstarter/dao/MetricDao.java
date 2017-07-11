package io.egenchallenge.pwtstarter.dao;

import java.util.List;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.query.Query;
import org.springframework.stereotype.Component;

import io.egenchallenge.pwtstarter.model.Metric;
import io.egenchallenge.pwtstarter.services.InitServices;
/**
 * Metric Data Access Object
 * @author Madhusudan Hanagal
 *
 */
@Component
public class MetricDao {
	Datastore dStoreInstance;
	/**
	 * Initiate dstore Instance
	 */
	public MetricDao() {
		this.dStoreInstance = InitServices.getInstance().getDatastore();
	}
	/**
	 * Create Metrics coming from sensors
	 * @param metric
	 */
	public void push(Metric metric) {
		dStoreInstance.save(metric);
	}
	/**
	 * Read All
	 * @return
	 */
	public List<Metric> read() {
		return dStoreInstance.createQuery(Metric.class).asList();
	}
	/**
	 * Read by range
	 * @param sTime
	 * @param eTime
	 * @return
	 */
	public List<Metric> readByTimeRange(long sTime, long eTime) {
		Query<Metric> query = dStoreInstance.createQuery(Metric.class);
		query.and(query.criteria("timeStamp").greaterThanOrEq(sTime), query.criteria("timeStamp").lessThanOrEq(eTime));
		return query.asList();
	}
	public Metric getRecentWeight(String sort) {
		return dStoreInstance.createQuery(Metric.class).order(sort).get();
	}

}
