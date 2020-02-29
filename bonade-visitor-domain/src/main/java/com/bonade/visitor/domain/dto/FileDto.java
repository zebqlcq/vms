package com.bonade.visitor.domain.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @ClassName:  FileDto   
 * @Description:
 * @author: lcq 
 * @date:   2019年12月31日 上午9:30:45   
 * @version 1.0
 */
public class FileDto {

    @ApiModelProperty(value = "文件扩展名", name = "extension", example = "")
    private String extension;

    @ApiModelProperty(value = "文件名称", name = "fileName", example = "")
    private String fileName;
    
    @ApiModelProperty(value = "文件路径", name = "filePath", example = "")
    private String filePath;
    
    @ApiModelProperty(value = "原始文件名", name = "originName", example = "")
    private String originName;
    
    @ApiModelProperty(value = "文件大小", name = "size", example = "")
    private String size;

	public String getExtension() {
		return extension;
	}

	public void setExtension(String extension) {
		this.extension = extension;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFilePath() {
		return filePath;
	}

	public void setFilePath(String filePath) {
		this.filePath = filePath;
	}

	public String getOriginName() {
		return originName;
	}

	public void setOriginName(String originName) {
		this.originName = originName;
	}

	public String getSize() {
		return size;
	}

	public void setSize(String size) {
		this.size = size;
	}

}
