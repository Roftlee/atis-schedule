package com.yd.atis.dao;

import com.yd.atis.dto.StationInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface StationInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StationInfo record);

    int insertSelective(StationInfo record);

    StationInfo selectByPrimaryKey(Integer id);

    StationInfo selectByRandom();

    int updateByPrimaryKeySelective(StationInfo record);

    int updateByPrimaryKey(StationInfo record);
}