package com.yd.atis.service.atis;

import com.yd.atis.dao.AtisInvokeStatMapper;
import com.yd.atis.dto.AtisInvokeStat;
import com.yd.atis.facade.atis.AtisInvokeStatFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author AsiQue
 * @since :2018.02.07 10:29
 */
@Service
public class AtisInvokeStatFacadeImpl implements AtisInvokeStatFacade {

    @Autowired
    private AtisInvokeStatMapper atisInvokeStatMapper;

    @Override
    public List<AtisInvokeStat> queryAtisInvokeStatList(AtisInvokeStat atisInvokeStat) {

        return atisInvokeStatMapper.queryAtisInvokeStatList(AtisInvokeStat.builder().build());
    }
}
