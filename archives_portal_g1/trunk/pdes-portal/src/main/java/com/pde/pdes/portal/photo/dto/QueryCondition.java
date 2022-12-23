package com.pde.pdes.portal.photo.dto;

import lombok.Data;

import java.io.Serializable;

@Data
public class QueryCondition implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = -5032796741401844543L;
	
	private int pageNum = 1;
	
	private int pageSize = 20;
	
	private String title;

	private String fileName;

}
