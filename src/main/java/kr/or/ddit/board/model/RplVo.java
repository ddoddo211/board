package kr.or.ddit.board.model;

import java.util.Date;

public class RplVo {

	String rpl_id;
	String rpl_user;
	String rpl_text;
	Date rpl_date;
	String rpl_brd;
	public String getRpl_id() {
		return rpl_id;
	}
	public void setRpl_id(String rpl_id) {
		this.rpl_id = rpl_id;
	}
	public String getRpl_user() {
		return rpl_user;
	}
	public void setRpl_user(String rpl_user) {
		this.rpl_user = rpl_user;
	}
	public String getRpl_text() {
		return rpl_text;
	}
	public void setRpl_text(String rpl_text) {
		this.rpl_text = rpl_text;
	}
	public Date getRpl_date() {
		return rpl_date;
	}
	public void setRpl_date(Date rpl_date) {
		this.rpl_date = rpl_date;
	}
	public String getRpl_brd() {
		return rpl_brd;
	}
	public void setRpl_brd(String rpl_brd) {
		this.rpl_brd = rpl_brd;
	}
	@Override
	public String toString() {
		return "RplVo [rpl_id=" + rpl_id + ", rpl_user=" + rpl_user
				+ ", rpl_text=" + rpl_text + ", rpl_date=" + rpl_date
				+ ", rpl_brd=" + rpl_brd + "]";
	}
	
	
	
	
}
