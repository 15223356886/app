package com.ysy.app.db.dao.user;

import com.ysy.app.db.po.user.TblUserInfo;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;
@Mapper
public interface TblUserInfoMapper {
    int deleteByPrimaryKey(String userId);

    int insert(TblUserInfo record);

    int insertSelective(TblUserInfo record);

    TblUserInfo selectByPrimaryKey(String userId);

    int updateByPrimaryKeySelective(TblUserInfo record);

    int updateByPrimaryKey(TblUserInfo record);

    List<TblUserInfo> selectUser(Map<String,Object> map);
}