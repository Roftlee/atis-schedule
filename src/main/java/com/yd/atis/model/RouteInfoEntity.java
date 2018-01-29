/**
 * RouteInfoEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.model;

public class RouteInfoEntity  implements java.io.Serializable {
    private Integer routeid;

    private String routename;

    private String routestyle;

    private String routetype;

    private double routePrice;

    private String routeinfo;

    public RouteInfoEntity() {
    }

    public RouteInfoEntity(
           Integer routeid,
           String routename,
           String routestyle,
           String routetype,
           double routePrice,
           String routeinfo) {
           this.routeid = routeid;
           this.routename = routename;
           this.routestyle = routestyle;
           this.routetype = routetype;
           this.routePrice = routePrice;
           this.routeinfo = routeinfo;
    }


    /**
     * Gets the routeid value for this RouteInfoEntity.
     *
     * @return routeid
     */
    public Integer getRouteid() {
        return routeid;
    }


    /**
     * Sets the routeid value for this RouteInfoEntity.
     *
     * @param routeid
     */
    public void setRouteid(Integer routeid) {
        this.routeid = routeid;
    }


    /**
     * Gets the routename value for this RouteInfoEntity.
     *
     * @return routename
     */
    public String getRoutename() {
        return routename;
    }


    /**
     * Sets the routename value for this RouteInfoEntity.
     *
     * @param routename
     */
    public void setRoutename(String routename) {
        this.routename = routename;
    }


    /**
     * Gets the routestyle value for this RouteInfoEntity.
     *
     * @return routestyle
     */
    public String getRoutestyle() {
        return routestyle;
    }


    /**
     * Sets the routestyle value for this RouteInfoEntity.
     *
     * @param routestyle
     */
    public void setRoutestyle(String routestyle) {
        this.routestyle = routestyle;
    }


    /**
     * Gets the routetype value for this RouteInfoEntity.
     *
     * @return routetype
     */
    public String getRoutetype() {
        return routetype;
    }


    /**
     * Sets the routetype value for this RouteInfoEntity.
     *
     * @param routetype
     */
    public void setRoutetype(String routetype) {
        this.routetype = routetype;
    }


    /**
     * Gets the routePrice value for this RouteInfoEntity.
     *
     * @return routePrice
     */
    public double getRoutePrice() {
        return routePrice;
    }


    /**
     * Sets the routePrice value for this RouteInfoEntity.
     *
     * @param routePrice
     */
    public void setRoutePrice(double routePrice) {
        this.routePrice = routePrice;
    }


    /**
     * Gets the routeinfo value for this RouteInfoEntity.
     *
     * @return routeinfo
     */
    public String getRouteinfo() {
        return routeinfo;
    }


    /**
     * Sets the routeinfo value for this RouteInfoEntity.
     *
     * @param routeinfo
     */
    public void setRouteinfo(String routeinfo) {
        this.routeinfo = routeinfo;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof RouteInfoEntity)) return false;
        RouteInfoEntity other = (RouteInfoEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.routeid==null && other.getRouteid()==null) ||
             (this.routeid!=null &&
              this.routeid.equals(other.getRouteid()))) &&
            ((this.routename==null && other.getRoutename()==null) ||
             (this.routename!=null &&
              this.routename.equals(other.getRoutename()))) &&
            ((this.routestyle==null && other.getRoutestyle()==null) ||
             (this.routestyle!=null &&
              this.routestyle.equals(other.getRoutestyle()))) &&
            ((this.routetype==null && other.getRoutetype()==null) ||
             (this.routetype!=null &&
              this.routetype.equals(other.getRoutetype()))) &&
            this.routePrice == other.getRoutePrice() &&
            ((this.routeinfo==null && other.getRouteinfo()==null) ||
             (this.routeinfo!=null &&
              this.routeinfo.equals(other.getRouteinfo())));
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
        if (getRouteid() != null) {
            _hashCode += getRouteid().hashCode();
        }
        if (getRoutename() != null) {
            _hashCode += getRoutename().hashCode();
        }
        if (getRoutestyle() != null) {
            _hashCode += getRoutestyle().hashCode();
        }
        if (getRoutetype() != null) {
            _hashCode += getRoutetype().hashCode();
        }
        _hashCode += new Double(getRoutePrice()).hashCode();
        if (getRouteinfo() != null) {
            _hashCode += getRouteinfo().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(RouteInfoEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "routeInfoEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
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
        elemField.setFieldName("routestyle");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routestyle"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routetype");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routetype"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routePrice");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routePrice"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "double"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("routeinfo");
        elemField.setXmlName(new javax.xml.namespace.QName("", "routeinfo"));
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
