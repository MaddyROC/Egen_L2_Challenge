package io.egenchallenge.pwtstarter;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


/**
 * Personal Weight Tracker API Start point
 * 
 * @author Madhusudan Hanagal
 *
 */

@SpringBootApplication
public class PWeightTrackerAPI {
	/**
	 * Starting point of Personal Weight Tracker API Starts the Spring boot
	 * application
	 * 
	 * @param args
	 */
	public static void main(String[] args) {
		
		SpringApplication.run(PWeightTrackerAPI.class, args);
	}
}
