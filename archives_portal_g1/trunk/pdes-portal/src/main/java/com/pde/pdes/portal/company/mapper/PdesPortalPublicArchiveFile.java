package com.pde.pdes.portal.company.mapper;

public interface PdesPortalPublicArchiveFile {
    int deleteByPrimaryKey(Integer id);

    int insert(PdesPortalPublicArchiveFile record);

    int insertSelective(PdesPortalPublicArchiveFile record);

    PdesPortalPublicArchiveFile selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PdesPortalPublicArchiveFile record);

    int updateByPrimaryKey(PdesPortalPublicArchiveFile record);
}