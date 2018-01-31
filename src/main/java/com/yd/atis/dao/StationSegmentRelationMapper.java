package com.yd.atis.dao;

import com.yd.atis.dto.StationSegmentRelation;
import org.springframework.stereotype.Repository;

@Repository
public interface StationSegmentRelationMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(StationSegmentRelation record);

    int insertSelective(StationSegmentRelation record);

    StationSegmentRelation selectByPrimaryKey(Integer id);

    StationSegmentRelation selectByRandom();

    int updateByPrimaryKeySelective(StationSegmentRelation record);

    int updateByPrimaryKey(StationSegmentRelation record);
}