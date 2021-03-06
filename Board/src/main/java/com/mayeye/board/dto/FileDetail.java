package com.mayeye.board.dto;

public class FileDetail {
	
	private String atch_file_id;
	private int file_sn;
	private String ori_name;
	private String save_name;
	private String save_path;
	private int file_size;
	private int num; // board 테이블 수정을 위해 추가
	private String oldKey;
	private int oldSn;
	
	public String getAtch_file_id() {
		return atch_file_id;
	}
	
	public void setAtch_file_id(String atch_file_id) {
		this.atch_file_id = atch_file_id;
	}
	
	public int getFile_sn() {
		return file_sn;
	}

	public void setFile_sn(int file_sn) {
		this.file_sn = file_sn;
	}

	public String getOri_name() {
		return ori_name;
	}
	
	public void setOri_name(String ori_name) {
		this.ori_name = ori_name;
	}
	
	public String getSave_name() {
		return save_name;
	}
	
	public void setSave_name(String save_name) {
		this.save_name = save_name;
	}
	
	public String getSave_path() {
		return save_path;
	}
	
	public void setSave_path(String save_path) {
		this.save_path = save_path;
	}

	public int getFile_size() {
		return file_size;
	}

	public void setFile_size(int file_size) {
		this.file_size = file_size;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public String getOldKey() {
		return oldKey;
	}

	public void setOldKey(String oldKey) {
		this.oldKey = oldKey;
	}

	public int getOldSn() {
		return oldSn;
	}

	public void setOldSn(int oldSn) {
		this.oldSn = oldSn;
	}

}
