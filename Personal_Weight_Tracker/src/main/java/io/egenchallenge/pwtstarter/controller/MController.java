package io.egenchallenge.pwtstarter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.egenchallenge.pwtstarter.dao.MetricDao;
import io.egenchallenge.pwtstarter.model.Metric;
import io.egenchallenge.pwtstarter.services.InitServices;

@RestController
@RequestMapping(value = "/metrics")
public class MController {

	@Autowired
	MetricDao metricsRepo;
	
	/**
	 * create and save
	 * POST request
	 * 
	 * @param metric
	 */
	@RequestMapping(value = "/create", method = RequestMethod.POST)
	public void push(@RequestBody Metric metric) {
		metricsRepo.push(metric);
		InitServices.getWeightRules().fireRules();
		;
	}

	/**
	 * read GET request
	 * 
	 * @return
	 */
	@RequestMapping(value = "/read", method = RequestMethod.GET)
	public List<Metric> read() {
		List<Metric> metricList = new ArrayList<>();
		try {
			metricList = metricsRepo.read();
		} catch (Exception e) {
			return metricList;
		}
		return metricList;
	}

	/**
	 * readByTimeRange GET Request
	 * 
	 * @param pathVariables
	 * @return
	 */
	@RequestMapping(value = "/readByTimeRange/{sTime}/{eTime}", method = RequestMethod.GET)
	public List<Metric> readByTimeRange(@PathVariable Map<String, String> pathVariables) {
		List<Metric> metricList = new ArrayList<>();
		long sTime = Long.parseLong(pathVariables.get("sTime"));
		long eTime = Long.parseLong(pathVariables.get("eTime"));
		try {
			metricList = metricsRepo.readByTimeRange(sTime, eTime);
		} catch (Exception e) {
			return metricList;
		}
		return metricList;
	}
}
