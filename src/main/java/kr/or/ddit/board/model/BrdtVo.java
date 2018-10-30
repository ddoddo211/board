package kr.or.ddit.board.model;

import java.util.Date;

public class BrdtVo {
	String brdt_id;
	String brdt_name;
	int brdt_useable;
	String brdt_user;
	Date brdt_date;
	public String getBrdt_id() {
		return brdt_id;
	}
	public void setBrdt_id(String brdt_id) {
		this.brdt_id = brdt_id;
	}
	public String getBrdt_name() {
		return brdt_name;
	}
	public void setBrdt_name(String brdt_name) {
		this.brdt_name = brdt_name;
	}
	public int getBrdt_useable() {
		return brdt_useable;
	}
	public void setBrdt_useable(int brdt_useable) {
		this.brdt_useable = brdt_useable;
	}
	public String getBrdt_user() {
		return brdt_user;
	}
	public void setBrdt_user(String brdt_user) {
		this.brdt_user = brdt_user;
	}
	public Date getBrdt_date() {
		return brdt_date;
	}
	public void setBrdt_date(Date brdt_date) {
		this.brdt_date = brdt_date;
	}
	@Override
	public String toString() {
		return "BrdtVo [brdt_id=" + brdt_id + ", brdt_name=" + brdt_name
				+ ", brdt_useable=" + brdt_useable + ", brdt_user=" + brdt_user
				+ ", brdt_date=" + brdt_date + "]";
	}
	
	
	
}
