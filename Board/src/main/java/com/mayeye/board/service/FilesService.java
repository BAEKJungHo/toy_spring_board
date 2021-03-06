package com.mayeye.board.service;

import java.util.List;
import java.util.Map;

import com.mayeye.board.dto.FileDetail;
import com.mayeye.board.dto.FileMaster;

public interface FilesService {
	
	public List<Map<String, Object>> selectFileDetailList(Map<String, Object> map);
	public void insertFileMaster(FileMaster fileMaster);
	public void insertFileDetail(FileDetail fileDetail);
	public List<FileDetail> findFileDetailList(String atch_file_no);
	public FileDetail findFileDetail(FileDetail fileDetail);
	public void fileDelete(FileDetail fileDetail);	
	public void masterDelete(String oldKey);
	public void updateBoardKey(FileDetail fileDetail);
	public void detailKeyUpdate(FileDetail fileDetail);
	public FileDetail getKeyByNum(int num);
	public int checkDataToFD(int num);
	
}
