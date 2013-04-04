package net.bbenarbia.web.dto;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

public class UploadItem {
	private String name;
//	private CommonsMultipartFile fileData;
	private List<MultipartFile> files;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<MultipartFile> getFiles() {
		return files;
	}
	public void setFiles(List<MultipartFile> files) {
		this.files = files;
	}

	
}