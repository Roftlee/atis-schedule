/**
 * RealTimeInfo.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.model;

public class RealTimeInfo  implements java.io.Serializable {
    private String busid;

    private String cardid;

    private String busselfid;

    private String productid;

    private Integer routeid;

    private String routename;

    private Integer subrouteid;

    private String segmentid;

    private String segmentname;

    private String rundirection;

    private String stationID;

    private Integer stationseqnum;

    private String stationnum;

    private String stationno;

    private String stationname;

    private String actdatetime;

    private String recdatetime;

    private Double longitude;

    private Double latitude;

    private Double gpsspeed;

    private String isarrlft;

    private String fstsendtime;

    private String lstsentime;

    public RealTimeInfo() {
    }

    public RealTimeInfo(
           String busid,
           String cardid,
           String busselfid,
           String productid,
           Integer routeid,
           String routename,
           Integer subrouteid,
           String segmentid,
           String segmentname,
           String rundirection,
           String stationID,
           Integer stationseqnum,
           String stationnum,
           String stationno,
           String stationname,
           String actdatetime,
           String recdatetime,
           Double longitude,
           Double latitude,
           Double gpsspeed,
           String isarrlft,
           String fstsendtime,
           String lstsentime) {
           this.busid = busid;
           this.cardid = cardid;
           this.busselfid = busselfid;
           this.productid = productid;
           this.routeid = routeid;
           this.routename = routename;
           this.subrouteid = subrouteid;
           this.segmentid = segmentid;
           this.segmentname = segmentname;
           this.rundirection = rundirection;
           this.stationID = stationID;
           this.stationseqnum = stationseqnum;
           this.stationnum = stationnum;
           this.stationno = stationno;
           this.stationname = stationname;
           this.actdatetime = actdatetime;
           this.recdatetime = recdatetime;
           this.longitude = longitude;
           this.latitude = latitude;
           this.gpsspeed = gpsspeed;
           this.isarrlft = isarrlft;
           this.fstsendtime = fstsendtime;
           this.lstsentime = lstsentime;
    }


    /**
     * Gets the busid value for this RealTimeInfo.
     *
     * @return busid
     */
    public String getBusid() {
        return busid;
    }


    /**
     * Sets the busid value for this RealTimeInfo.
     *
     * @param busid
     */
    public void setBusid(String busid) {
        this.busid = busid;
    }


    /**
     * Gets the cardid value for this RealTimeInfo.
     *
     * @return cardid
     */
    public String getCardid() {
        return cardid;
    }


    /**
     * Sets the cardid value for this RealTimeInfo.
     *
     * @param cardid
     */
    public void setCardid(String cardid) {
        this.cardid = cardid;
    }


    /**
     * Gets the busselfid value for this RealTimeInfo.
     *
     * @return busselfid
     */
    public String getBusselfid() {
        return busselfid;
    }


    /**
     * Sets the busselfid value for this RealTimeInfo.
     *
     * @param busselfid
     */
    public void setBusselfid(String busselfid) {
        this.busselfid = busselfid;
    }


    /**
     * Gets the productid value for this RealTimeInfo.
     *
     * @return productid
     */
    public String getProductid() {
        return productid;
    }


    /**
     * Sets the productid value for this RealTimeInfo.
     *
     * @param productid
     */
    public void setProductid(String productid) {
        this.productid = productid;
    }


    /**
     * Gets the routeid value for this RealTimeInfo.
     *
     * @return routeid
     */
    public Integer getRouteid() {
        return routeid;
    }


    /**
     * Sets the routeid value for this RealTimeInfo.
     *
     * @param routeid
     */
    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }


    /**
     * Gets the routename value for this RealTimeInfo.
     *
     * @return routename
     */
    public String getRoutename() {
        return routename;
    }


    /**
     * Sets the routename value for this RealTimeInfo.
     *
     * @param routename
     */
    public void setRoutename(String routename) {
        this.routename = routename;
    }


    /**
     * Gets the subrouteid value for this RealTimeInfo.
     *
     * @return subrouteid
     */
    public Integer getSubrouteid() {
        return subrouteid;
    }


    /**
     * Sets the subrouteid value for this RealTimeInfo.
     *
     * @param subrouteid
     */
    public void setSubrouteid(Integer subrouteid) {
        this.subrouteid = subrouteid;
    }


    /**
     * Gets the segmentid value for this RealTimeInfo.
     *
     * @return segmentid
     */
    public String getSegmentid() {
        return segmentid;
    }


    /**
     * Sets the segmentid value for this RealTimeInfo.
     *
     * @param segmentid
     */
    public void setSegmentid(String segmentid) {
        this.segmentid = segmentid;
    }


    /**
     * Gets the segmentname value for this RealTimeInfo.
     *
     * @return segmentname
     */
    public String getSegmentname() {
        return segmentname;
    }


    /**
     * Sets the segmentname value for this RealTimeInfo.
     *
     * @param segmentname
     */
    public void setSegmentname(String segmentname) {
        this.segmentname = segmentname;
    }


    /**
     * Gets the rundirection value for this RealTimeInfo.
     *
     * @return rundirection
     */
    public String getRundirection() {
        return rundirection;
    }


    /**
     * Sets the rundirection value for this RealTimeInfo.
     *
     * @param rundirection
     */
    public void setRundirection(String rundirection) {
        this.rundirection = rundirection;
    }


    /**
     * Gets the stationID value for this RealTimeInfo.
     *
     * @return stationID
     */
    public String getStationID() {
        return stationID;
    }


    /**
     * Sets the stationID value for this RealTimeInfo.
     *
     * @param stationID
     */
    public void setStationID(String stationID) {
        this.stationID = stationID;
    }


    /**
     * Gets the stationseqnum value for this RealTimeInfo.
     *
     * @return stationseqnum
     */
    public Integer getStationseqnum() {
        return stationseqnum;
    }


    /**
     * Sets the stationseqnum value for this RealTimeInfo.
     *
     * @param stationseqnum
     */
    public void setStationseqnum(Integer stationseqnum) {
        this.stationseqnum = stationseqnum;
    }


    /**
     * Gets the stationnum value for this RealTimeInfo.
     *
     * @return stationnum
     */
    public String getStationnum() {
        return stationnum;
    }


    /**
     * Sets the stationnum value for this RealTimeInfo.
     *
     * @param stationnum
     */
    public void setStationnum(String stationnum) {
        this.stationnum = stationnum;
    }


    /**
     * Gets the stationno value for this RealTimeInfo.
     *
     * @return stationno
     */
    public String getStationno() {
        return stationno;
    }


    /**
     * Sets the stationno value for this RealTimeInfo.
     *
     * @param stationno
     */
    public void setStationno(String stationno) {
        this.stationno = stationno;
    }


    /**
     * Gets the stationname value for this RealTimeInfo.
     *
     * @return stationname
     */
    public String getStationname() {
        return stationname;
    }


    /**
     * Sets the stationname value for this RealTimeInfo.
     *
     * @param stationname
     */
    public void setStationname(String stationname) {
        this.stationname = stationname;
    }


    /**
     * Gets the actdatetime value for this RealTimeInfo.
     *
     * @return actdatetime
     */
    public String getActdatetime() {
        return actdatetime;
    }


    /**
     * Sets the actdatetime value for this RealTimeInfo.
     *
     * @param actdatetime
     */
    public void setActdatetime(String actdatetime) {
        this.actdatetime = actdatetime;
    }


    /**
     * Gets the recdatetime value for this RealTimeInfo.
     *
     * @return recdatetime
     */
    public String getRecdatetime() {
        return recdatetime;
    }


    /**
     * Sets the recdatetime value for this RealTimeInfo.
     *
     * @param recdatetime
     */
    public void setRecdatetime(String recdatetime) {
        this.recdatetime = recdatetime;
    }


    /**
     * Gets the longitude value for this RealTimeInfo.
     *
     * @return longitude
     */
    public Double getLongitude() {
        return longitude;
    }


    /**
     * Sets the longitude value for this RealTimeInfo.
     *
     * @param longitude
     */
    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }


    /**
     * Gets the latitude value for this RealTimeInfo.
     *
     * @return latitude
     */
    public Double getLatitude() {
        return latitude;
    }


    /**
     * Sets the latitude value for this RealTimeInfo.
     *
     * @param latitude
     */
    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }


    /**
     * Gets the gpsspeed value for this RealTimeInfo.
     *
     * @return gpsspeed
     */
    public Double getGpsspeed() {
        return gpsspeed;
    }


    /**
     * Sets the gpsspeed value for this RealTimeInfo.
     *
     * @param gpsspeed
     */
    public void setGpsspeed(Double gpsspeed) {
        this.gpsspeed = gpsspeed;
    }


    /**
     * Gets the isarrlft value for this RealTimeInfo.
     *
     * @return isarrlft
     */
    public String getIsarrlft() {
        return isarrlft;
    }


    /**
     * Sets the isarrlft value for this RealTimeInfo.
     *
     * @param isarrlft
     */
    public void setIsarrlft(String isarrlft) {
        this.isarrlft = isarrlft;
    }


    /**
     * Gets the fstsendtime value for this RealTimeInfo.
     *
     * @return fstsendtime
     */
    public String getFstsendtime() {
        return fstsendtime;
    }


    /**
     * Sets the fstsendtime value for this RealTimeInfo.
     *
     * @param fstsendtime
     */
    public void setFstsendtime(String fstsendtime) {
        this.fstsendtime = fstsendtime;
    }


    /**
     * Gets the lstsentime value for this RealTimeInfo.
     *
     * @return lstsentime
     */
    public String getLstsentime() {
        return lstsentime;
    }


    /**
     * Sets the lstsentime value for this RealTimeInfo.
     *
     * @param lstsentime
     */
    public void setLstsentime(String lstsentime) {
        this.lstsentime = lstsentime;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof RealTimeInfo)) return false;
        RealTimeInfo other = (RealTimeInfo) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.busid==null && other.getBusid()==null) ||
             (this.busid!=null &&
              this.busid.equals(other.getBusid()))) &&
            ((this.cardid==null && other.getCardid()==null) ||
             (this.cardid!=null &&
              this.cardid.equals(other.getCardid()))) &&
            ((this.busselfid==null && other.getBusselfid()==null) ||
             (this.busselfid!=null &&
              this.busselfid.equals(other.getBusselfid()))) &&
            ((this.productid==null && other.getProductid()==null) ||
             (this.productid!=null &&
              this.productid.equals(other.getProductid()))) &&
            ((this.routeid==null && other.getRouteid()==null) ||
             (this.routeid!=null &&
              this.routeid.equals(other.getRouteid()))) &&
            ((this.routename==null && other.getRoutename()==null) ||
             (this.routename!=null &&
              this.routename.equals(other.getRoutename()))) &&
            ((this.subrouteid==null && other.getSubrouteid()==null) ||
             (this.subrouteid!=null &&
              this.subrouteid.equals(other.getSubrouteid()))) &&
            ((this.segmentid==null && other.getSegmentid()==null) ||
             (this.segmentid!=null &&
              this.segmentid.equals(other.getSegmentid()))) &&
            ((this.segmentname==null && other.getSegmentname()==null) ||
             (this.segmentname!=null &&
              this.segmentname.equals(other.getSegmentname()))) &&
            ((this.rundirection==null && other.getRundirection()==null) ||
             (this.rundirection!=null &&
              this.rundirection.equals(other.getRundirection()))) &&
            ((this.stationID==null && other.getStationID()==null) ||
             (this.stationID!=null &&
              this.stationID.equals(other.getStationID()))) &&
            ((this.stationseqnum==null && other.getStationseqnum()==null) ||
             (this.stationseqnum!=null &&
              this.stationseqnum.equals(other.getStationseqnum()))) &&
            ((this.stationnum==null && other.getStationnum()==null) ||
             (this.stationnum!=null &&
              this.stationnum.equals(other.getStationnum()))) &&
            ((this.stationno==null && other.getStationno()==null) ||
             (this.stationno!=null &&
              this.stationno.equals(other.getStationno()))) &&
            ((this.stationname==null && other.getStationname()==null) ||
             (this.stationname!=null &&
              this.stationname.equals(other.getStationname()))) &&
            ((this.actdatetime==null && other.getActdatetime()==null) ||
             (this.actdatetime!=null &&
              this.actdatetime.equals(other.getActdatetime()))) &&
            ((this.recdatetime==null && other.getRecdatetime()==null) ||
             (this.recdatetime!=null &&
              this.recdatetime.equals(other.getRecdatetime()))) &&
            ((this.longitude==null && other.getLongitude()==null) ||
             (this.longitude!=null &&
              this.longitude.equals(other.getLongitude()))) &&
            ((this.latitude==null && other.getLatitude()==null) ||
             (this.latitude!=null &&
              this.latitude.equals(other.getLatitude()))) &&
            ((this.gpsspeed==null && other.getGpsspeed()==null) ||
             (this.gpsspeed!=null &&
              this.gpsspeed.equals(other.getGpsspeed()))) &&
            ((this.isarrlft==null && other.getIsarrlft()==null) ||
             (this.isarrlft!=null &&
              this.isarrlft.equals(other.getIsarrlft()))) &&
            ((this.fstsendtime==null && other.getFstsendtime()==null) ||
             (this.fstsendtime!=null &&
              this.fstsendtime.equals(other.getFstsendtime()))) &&
            ((this.lstsentime==null && other.getLstsentime()==null) ||
             (this.lstsentime!=null &&
              this.lstsentime.equals(other.getLstsentime())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getBusid() != null) {
            _hashCode += getBusid().hashCode();
        }
        if (getCardid() != null) {
            _hashCode += getCardid().hashCode();
        }
        if (getBusselfid() != null) {
            _hashCode += getBusselfid().hashCode();
        }
        if (getProductid() != null) {
            _hashCode += getProductid().hashCode();
        }
        if (getRouteid() != null) {
            _hashCode += getRouteid().hashCode();
        }
        if (getRoutename() != null) {
            _hashCode += getRoutename().hashCode();
        }
        if (getSubrouteid() != null) {
            _hashCode += getSubrouteid().hashCode();
        }
        if (getSegmentid() != null) {
            _hashCode += getSegmentid().hashCode();
        }
        if (getSegmentname() != null) {
            _hashCode += getSegmentname().hashCode();
        }
        if (getRundirection() != null) {
            _hashCode += getRundirection().hashCode();
        }
        if (getStationID() != null) {
            _hashCode += getStationID().hashCode();
        }
        if (getStationseqnum() != null) {
            _hashCode += getStationseqnum().hashCode();
        }
        if (getStationnum() != null) {
            _hashCode += getStationnum().hashCode();
        }
        if (getStationno() != null) {
            _hashCode += getStationno().hashCode();
        }
        if (getStationname() != null) {
            _hashCode += getStationname().hashCode();
        }
        if (getActdatetime() != null) {
            _hashCode += getActdatetime().hashCode();
        }
        if (getRecdatetime() != null) {
            _hashCode += getRecdatetime().hashCode();
        }
        if (getLongitude() != null) {
            _hashCode += getLongitude().hashCode();
        }
        if (getLatitude() != null) {
            _hashCode += getLatitude().hashCode();
        }
        if (getGpsspeed() != null) {
            _hashCode += getGpsspeed().hashCode();
        }
        if (getIsarrlft() != null) {
            _hashCode += getIsarrlft().hashCode();
        }
        if (getFstsendtime() != null) {
            _hashCode += getFstsendtime().hashCode();
        }
        if (getLstsentime() != null) {
            _hashCode += getLstsentime().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RealTimeInfo.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "realTimeInfo"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("busid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "busid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("cardid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "cardid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("busselfid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "busselfid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("productid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "productid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routeid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("subrouteid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "subrouteid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentid");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmentid"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("segmentname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "segmentname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("rundirection");
        elemField.setXmlName(new javax.xml.namespace.QName("", "rundirection"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationID");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationID"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationseqnum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationseqnum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "int"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationnum");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationnum"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationno");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationno"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("stationname");
        elemField.setXmlName(new javax.xml.namespace.QName("", "stationname"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("actdatetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "actdatetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("recdatetime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "recdatetime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("longitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "longitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("latitude");
        elemField.setXmlName(new javax.xml.namespace.QName("", "latitude"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("gpsspeed");
        elemField.setXmlName(new javax.xml.namespace.QName("", "gpsspeed"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("isarrlft");
        elemField.setXmlName(new javax.xml.namespace.QName("", "isarrlft"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("fstsendtime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "fstsendtime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("lstsentime");
        elemField.setXmlName(new javax.xml.namespace.QName("", "lstsentime"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           String mechType,
           Class _javaType,
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}
