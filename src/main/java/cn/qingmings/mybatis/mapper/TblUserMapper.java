package cn.qingmings.mybatis.mapper;

import cn.qingmings.mybatis.model.TblUser;

public interface TblUserMapper {
    int deleteByPrimaryKey(Long id);

    int insert(TblUser record);

    int insertSelective(TblUser record);

    TblUser selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(TblUser record);

    int updateByPrimaryKey(TblUser record);
}