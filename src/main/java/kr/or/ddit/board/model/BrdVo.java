package kr.or.ddit.board.model;

public class BrdVo {
	private String brd_id;
	private String brd_title;
	private String brd_text;
	private String brd_gn;
	private String brd_brdt;
	private String brd_pid;
	private String brd_rp;
	private int brd_page;
	private int brd_pageSize;
	private int rnum;
	private String brd_user;
	private int brd_del;
	
	
	
	
	
	public int getBrd_del() {
		return brd_del;
	}
	public void setBrd_del(int brd_del) {
		this.brd_del = brd_del;
	}
	public String getBrd_user() {
		return brd_user;
	}
	public void setBrd_user(String brd_user) {
		this.brd_user = brd_user;
	}
	public int getRnum() {
		return rnum;
	}
	public void setRnum(int rnum) {
		this.rnum = rnum;
	}
	public int getBrd_page() {
		return brd_page;
	}
	public void setBrd_page(int brd_page) {
		this.brd_page = brd_page;
	}
	public int getBrd_pageSize() {
		return brd_pageSize;
	}
	public void setBrd_pageSize(int brd_pageSize) {
		this.brd_pageSize = brd_pageSize;
	}
	public String getBrd_id() {
		return brd_id;
	}
	public void setBrd_id(String brd_id) {
		this.brd_id = brd_id;
	}
	public String getBrd_title() {
		return brd_title;
	}
	public void setBrd_title(String brd_title) {
		this.brd_title = brd_title;
	}
	public String getBrd_text() {
		return brd_text;
	}
	public void setBrd_text(String brd_text) {
		this.brd_text = brd_text;
	}
	public String getBrd_gn() {
		return brd_gn;
	}
	public void setBrd_gn(String brd_gn) {
		this.brd_gn = brd_gn;
	}
	public String getBrd_brdt() {
		return brd_brdt;
	}
	public void setBrd_brdt(String brd_brdt) {
		this.brd_brdt = brd_brdt;
	}
	public String getBrd_pid() {
		return brd_pid;
	}
	public void setBrd_pid(String brd_pid) {
		this.brd_pid = brd_pid;
	}
	public String getBrd_rp() {
		return brd_rp;
	}
	public void setBrd_rp(String brd_rp) {
		this.brd_rp = brd_rp;
	}
	@Override
	public String toString() {
		return "BrdVo [brd_id=" + brd_id + ", brd_title=" + brd_title
				+ ", brd_text=" + brd_text + ", brd_gn=" + brd_gn
				+ ", brd_brdt=" + brd_brdt + ", brd_pid=" + brd_pid
				+ ", brd_rp=" + brd_rp + "]";
	}
	
	
	
	
	
}
