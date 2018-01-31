package com.yd.atis.dto;

import lombok.*;

import java.util.Date;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class RouteInfo {
    private Integer id;

    private String routeId;

    private String routeName;

    private Double routePrice;

    private Integer routeStyle;

    private String routeInfo;

    private Date createdTime;

    private Date updatedTime;
}