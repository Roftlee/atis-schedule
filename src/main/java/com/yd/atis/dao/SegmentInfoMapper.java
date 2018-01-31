package com.yd.atis.dao;

import com.yd.atis.dto.SegmentInfo;
import org.springframework.stereotype.Repository;

@Repository
public interface SegmentInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(SegmentInfo record);

    int insertSelective(SegmentInfo record);

    SegmentInfo selectByPrimaryKey(Integer id);

    SegmentInfo selectByRandom();

    int updateByPrimaryKeySelective(SegmentInfo record);

    int updateByPrimaryKey(SegmentInfo record);
}