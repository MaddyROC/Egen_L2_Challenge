package io.egenchallenge.pwtstarter.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import io.egenchallenge.pwtstarter.dao.AlertDao;
import io.egenchallenge.pwtstarter.model.Alert;

/**
 * Rest Controller for Alert Controller
 * 
 * @author Madhusudan Hanagal
 *
 */

@RestController
@RequestMapping("/alerts")
public class AController {

	@Autowired
	AlertDao alertrepo;

	/**
	 * read GET request
	 * 
	 * @return
	 */
	@RequestMapping("/read")
	public List<Alert> read() {
		List<Alert> alertList = new ArrayList<>();
		try {
			alertList = alertrepo.read();
		} catch (Exception e) {
			return alertList;
		}
		return alertList;
	}

	/**
	 * readByTimeRange GET Request
	 * 
	 * @param pathVariables
	 * @return
	 */
	@RequestMapping("/readByTimeRange/{sTime}/{eTime}")
	public List<Alert> readByTimeRange(@PathVariable Map<String, String> pathVariables) {
		List<Alert> alertList = new ArrayList<>();
		long sTime = Long.parseLong(pathVariables.get("sTime"));
		long eTime = Long.parseLong(pathVariables.get("eTime"));
		try {
			alertList = alertrepo.readByTimeRange(sTime, eTime);
		} catch (Exception e) {
			return alertList;
		}
		return alertList;
	}
}
