package com.yd.atis.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class AtisInvokeLog {
    private Integer id;

    private String invokeFunc;

    private String invokeParam;

    private Date invokeTime;

    private Integer invokeStatus;

    private String exceptDesp;

    private Date createdTime;

    private Date updatedTime;
}