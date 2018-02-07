package com.yd.atis.dao;

import com.yd.atis.dto.AtisInvokeStat;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author AsiQue
 * @since :2018.02.07 10:15
 */
@Repository
public interface AtisInvokeStatMapper {

    List<AtisInvokeStat> queryAtisInvokeStatList(AtisInvokeStat atisInvokeStat);
}
