package com.yd.atis.facade.atis;

import com.yd.atis.dto.AtisInvokeLog;

import java.util.List;

/**
 * @author AsiQue
 * @since :2018.02.02 16:15
 */
public interface AtisInvokeLogFacade {

    int deleteByPrimaryKey(Integer id);

    int insert(AtisInvokeLog record);

    int insertSelective(AtisInvokeLog record);

    AtisInvokeLog selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(AtisInvokeLog record);

    int updateByPrimaryKey(AtisInvokeLog record);

    List<AtisInvokeLog> queryAtisInvokeLogList(AtisInvokeLog record);

    List<AtisInvokeLog> queryAtisInvokeLogListPage(AtisInvokeLog record);
}
