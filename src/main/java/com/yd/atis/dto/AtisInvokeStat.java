package com.yd.atis.dto;

import lombok.*;

/**
 * @author AsiQue
 * @since :2018.02.07 10:12
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AtisInvokeStat {

    private String invokeFunc;

    private Integer todayInvoke;

    private Integer todayEmpty;

    private Integer todayExcept;

    private Integer totalInvoke;

    private Integer totalEmpty;

    private Integer totalExcept;
}
