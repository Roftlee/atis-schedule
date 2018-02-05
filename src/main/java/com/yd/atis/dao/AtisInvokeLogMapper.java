package com.yd.atis.dao;

import com.yd.atis.dto.AtisInvokeLog;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AtisInvokeLogMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(AtisInvokeLog record);

    int insertSelective(AtisInvokeLog record);

    AtisInvokeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtisInvokeLog record);

    int updateByPrimaryKey(AtisInvokeLog record);

    List<AtisInvokeLog> queryAtisInvokeLogList(AtisInvokeLog record);
}