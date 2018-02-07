package com.yd.atis.facade.atis;

import com.yd.atis.dto.AtisInvokeStat;

import java.util.List;

/**
 * @author AsiQue
 * @since :2018.02.07 10:26
 */
public interface AtisInvokeStatFacade {

    List<AtisInvokeStat> queryAtisInvokeStatList(AtisInvokeStat atisInvokeStat);
}
