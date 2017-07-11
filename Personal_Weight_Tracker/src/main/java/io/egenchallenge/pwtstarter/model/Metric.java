
package io.egenchallenge.pwtstarter.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Metrics Model
 * @author Madhusudan Hanagal
 *
 */
@Entity("metrics")
public class Metric {
	
	@Id
	private long timeStamp;
	private int value;
	
	public Metric() {
    }
	
	@Override
	public String toString() {
		return "Metric [wieght=" + value + ", timestamp=" + timeStamp + "]";
	}

	public long getTimeStamp() {
		return timeStamp;
	}

	public void setTimeStamp(long timeStamp) {
		this.timeStamp = timeStamp;
	}

	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


}
