package com.pde.pdes.portal.company.service;

import java.util.List;

import com.pde.pdes.portal.company.dto.CompanyDTO;
import com.pde.pdes.portal.company.po.CompanyPO;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

/**
 * DEMO公司信息业务服务接口
 * @author lifp
 * @date 2022/11/02
 */
public interface CompanyService {
	
	/**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
	boolean add(CompanyDTO entity);
	
	/**
     * 根据 ID 删除
     *
     * @param id 主键ID
     */
    boolean deleteById(String id);
	
	/**
     * 根据 ID 查询
     *
     * @param id 主键ID
     */
	CompanyPO findById(String id); 
	
    /**
     * 根据 searchText 条件，模糊匹配
     *
     * @param queryWrapper 实体对象封装操作类（可以为 null）
     */
	List<CompanyPO> find(String searchText);


}
