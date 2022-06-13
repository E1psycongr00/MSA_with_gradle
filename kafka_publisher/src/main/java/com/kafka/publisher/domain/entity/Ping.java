package com.kafka.publisher.domain.entity;

import java.io.Serializable;

// 반드시 직렬화 객체로 만들어야 된다.  ==> implements Serializable 하면 됨.
public class Ping implements Serializable {
	
	String mesg;
	String name;
	
	public Ping() {
	}

	public Ping(String mesg, String name) {
		super();
		this.mesg = mesg;
		this.name = name;
	}

	public String getMesg() {
		return mesg;
	}

	public void setMesg(String mesg) {
		this.mesg = mesg;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Ping [mesg=" + mesg + ", name=" + name + "]";
	}

}
