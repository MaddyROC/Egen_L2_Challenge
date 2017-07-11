package io.egenchallenge.pwtstarter.model;

import org.mongodb.morphia.annotations.Entity;
import org.mongodb.morphia.annotations.Id;

/**
 * Alert Model
 * @author Madhusudan Hanagal
 *
 */
@Entity("alerts")
public class Alert {
	
	@Id
	private long timeStamp;
	private int value;
	private String userStatus;
	
	public Alert() {
	}
	
	

	@Override
	public String toString() {
		return "Alert [timeStamp=" + timeStamp + ", value=" + value + ", userStatus=" + userStatus + "]";
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
	
	public String getUserStatus() {
		return userStatus;
	}

	public void setUserStatus(String userStatus) {
		this.userStatus = userStatus;
	}

}
