/**
 * AtisBasicWebService_PortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.service.basic;

import com.yd.atis.model.*;

public interface AtisBasicWebService_PortType extends java.rmi.Remote {
    public StationInfoEntity[] getAllStation(String name, String password) throws java.rmi.RemoteException, BusinessException;
    public StationInfoEntity[] getAllStationNoRoute(String name, String password) throws java.rmi.RemoteException, BusinessException;
    public StationInfoEntity[] getStationInfoNoRoute(String stationId, String stationName, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public StationInfoEntity[] getStationByGpsNoRoute(Double longitude, Double latitude, Double lonRange, Double latRange, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public SegmentInfoEntity[] getSegmentByRoute(String routeId, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public StationInfoEntity[] getStationBySegment(String segmengtID, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public StationInfoEntity[] getStationInfo(String stationId, String stationName, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public RouteInfoEntity[] getRouteByStation(String stationID, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public RouteInfoEntity[] getRouteInfo(String routeID, String routeName, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public TypeEntity[] getDictByName(String typeName, String name, String password) throws java.rmi.RemoteException, BusinessException;
    public TypeEntity[] getAllDictInfo(String name, String password) throws java.rmi.RemoteException, BusinessException;
    public StationInfoEntity[] getStationByGps(Double longitude, Double latitude, Double lonRange, Double latRange, Double range, String name, String password) throws java.rmi.RemoteException, BusinessException;
}
