package com.ysy.app.db.dao;

import com.ysy.app.db.po.TblDataDicInfo;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface TblDataDicInfoMapper {
    int deleteByPrimaryKey(String dataDicId);

    int insert(TblDataDicInfo record);

    int insertSelective(TblDataDicInfo record);

    TblDataDicInfo selectByPrimaryKey(String dataDicId);

    int updateByPrimaryKeySelective(TblDataDicInfo record);

    int updateByPrimaryKey(TblDataDicInfo record);
}