package com.pde.pdes.portal.company.po;
import java.io.Serializable;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author SYKCOMPUTER
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@ApiModel(value = "DEMO公司信息", description = "DEMO公司信息")
@TableName("pdes_demo_company")
@Builder
public class CompanyPO implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 4001855409862218714L;
	
	@ApiModelProperty("id")
	@TableId
	private String id;
	
	@ApiModelProperty("name")
	private String name;
	
	@ApiModelProperty("address")
	private String address;

}
