package io.egenchallenge.pwtstarter.services;

import static org.easyrules.core.RulesEngineBuilder.aNewRulesEngine;
import org.easyrules.api.RulesEngine;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import com.mongodb.MongoClient;

import io.egenchallenge.pwtstarter.ruleFactory.OverWtRule;
import io.egenchallenge.pwtstarter.ruleFactory.UnderWtRule;
/**
 * Initialize Services
 * Database mongo morphia connections
 * RuleEngine Build
 * Singleton Class
 * @author Madhusudan Hanagals
 *
 */
public class InitServices {

	private static Morphia morphia = new Morphia();
	private Datastore dstore = null;
	private static InitServices instance = new InitServices();
	private static RulesEngine weightRules;
	
	/**
	 * Private constructor
	 */
	private InitServices() {
		try {
			//Morphia Mongo
			morphia.mapPackage("io.egenchallenge.pwtstarter.model");
			dstore = morphia.createDatastore(new MongoClient(), "PWTCollections");
			dstore.ensureIndexes();
			//Rule Engines
			weightRules = aNewRulesEngine().build();
			weightRules.registerRule(new OverWtRule());
			weightRules.registerRule(new UnderWtRule());
			
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Some problem occured with the DB connection!");
		}
	}
	
	/**
	 * Getter methods
	 * @return
	 */
	
	public static RulesEngine getWeightRules() {
		return weightRules;
	}
	public static InitServices getInstance() {
		return instance;
	}
	public Datastore getDatastore() {
		return dstore;
	}

}
