package kr.or.ddit.board.model;

public class FileVo {
	String file_id;
	String file_path;
	String file_brd;
	public String getFile_id() {
		return file_id;
	}
	public void setFile_id(String file_id) {
		this.file_id = file_id;
	}
	public String getFile_path() {
		return file_path;
	}
	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}
	public String getFile_brd() {
		return file_brd;
	}
	public void setFile_brd(String file_brd) {
		this.file_brd = file_brd;
	}
	@Override
	public String toString() {
		return "FileVo [file_id=" + file_id + ", file_path=" + file_path
				+ ", file_brd=" + file_brd + "]";
	}
	
	
	
}
