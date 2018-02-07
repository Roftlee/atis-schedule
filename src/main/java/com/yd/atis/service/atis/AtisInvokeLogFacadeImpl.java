package com.yd.atis.service.atisInvokeLog;

import com.yd.atis.dao.AtisInvokeLogMapper;
import com.yd.atis.dto.AtisInvokeLog;
import com.yd.atis.facade.atis.AtisInvokeLogFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AsiQue
 * @since :2018.02.02 16:38
 */
@Service
public class AtisInvokeLogFacadeImpl implements AtisInvokeLogFacade {

    @Autowired
    private AtisInvokeLogMapper atisInvokeLogMapper;

    @Override
    public int deleteByPrimaryKey(Integer id) {
        return atisInvokeLogMapper.deleteByPrimaryKey(id);
    }

    @Override
    public int insert(AtisInvokeLog record) {
        return atisInvokeLogMapper.insert(record);
    }

    @Override
    public int insertSelective(AtisInvokeLog record) {
        return atisInvokeLogMapper.insertSelective(record);
    }

    @Override
    public AtisInvokeLog selectByPrimaryKey(Integer id) {
        return atisInvokeLogMapper.selectByPrimaryKey(id);
    }

    @Override
    public int updateByPrimaryKeySelective(AtisInvokeLog record) {
        return atisInvokeLogMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public int updateByPrimaryKey(AtisInvokeLog record) {
        return atisInvokeLogMapper.updateByPrimaryKey(record);
    }

    @Override
    public List<AtisInvokeLog> queryAtisInvokeLogList(AtisInvokeLog record) {
        return atisInvokeLogMapper.queryAtisInvokeLogList(record);
    }

    @Override
    public List<AtisInvokeLog> queryAtisInvokeLogListPage(AtisInvokeLog record) {
        return atisInvokeLogMapper.queryAtisInvokeLogList(record);
    }
}
