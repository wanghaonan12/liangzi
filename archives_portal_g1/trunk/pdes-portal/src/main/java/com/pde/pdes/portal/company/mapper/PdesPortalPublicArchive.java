package com.pde.pdes.portal.company.mapper;

public interface PdesPortalPublicArchive {
    int deleteByPrimaryKey(Integer id);

    int insert(PdesPortalPublicArchive record);

    int insertSelective(PdesPortalPublicArchive record);

    PdesPortalPublicArchive selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PdesPortalPublicArchive record);

    int updateByPrimaryKey(PdesPortalPublicArchive record);
}