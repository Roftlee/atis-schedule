package com.yd.atis.dao;

import com.yd.atis.dto.RouteInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface RouteInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(RouteInfo record);

    int insertSelective(RouteInfo record);

    RouteInfo selectByPrimaryKey(Integer id);

    RouteInfo selectByRandom();

    int updateByPrimaryKeySelective(RouteInfo record);

    int updateByPrimaryKey(RouteInfo record);
}