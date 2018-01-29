/**
 * TypeEntity.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.yd.atis.model;

public class TypeEntity  implements java.io.Serializable {
    private String typename;

    private String itemkey;

    private String itemvalue;

    public TypeEntity() {
    }

    public TypeEntity(
           String typename,
           String itemkey,
           String itemvalue) {
           this.typename = typename;
           this.itemkey = itemkey;
           this.itemvalue = itemvalue;
    }


    /**
     * Gets the typename value for this TypeEntity.
     *
     * @return typename
     */
    public String getTypename() {
        return typename;
    }


    /**
     * Sets the typename value for this TypeEntity.
     *
     * @param typename
     */
    public void setTypename(String typename) {
        this.typename = typename;
    }


    /**
     * Gets the itemkey value for this TypeEntity.
     *
     * @return itemkey
     */
    public String getItemkey() {
        return itemkey;
    }


    /**
     * Sets the itemkey value for this TypeEntity.
     *
     * @param itemkey
     */
    public void setItemkey(String itemkey) {
        this.itemkey = itemkey;
    }


    /**
     * Gets the itemvalue value for this TypeEntity.
     *
     * @return itemvalue
     */
    public String getItemvalue() {
        return itemvalue;
    }


    /**
     * Sets the itemvalue value for this TypeEntity.
     *
     * @param itemvalue
     */
    public void setItemvalue(String itemvalue) {
        this.itemvalue = itemvalue;
    }

    private Object __equalsCalc = null;
    public synchronized boolean equals(Object obj) {
        if (!(obj instanceof TypeEntity)) return false;
        TypeEntity other = (TypeEntity) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true &&
            ((this.typename==null && other.getTypename()==null) ||
             (this.typename!=null &&
              this.typename.equals(other.getTypename()))) &&
            ((this.itemkey==null && other.getItemkey()==null) ||
             (this.itemkey!=null &&
              this.itemkey.equals(other.getItemkey()))) &&
            ((this.itemvalue==null && other.getItemvalue()==null) ||
             (this.itemvalue!=null &&
              this.itemvalue.equals(other.getItemvalue())));
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
        if (getTypename() != null) {
            _hashCode += getTypename().hashCode();
        }
        if (getItemkey() != null) {
            _hashCode += getItemkey().hashCode();
        }
        if (getItemvalue() != null) {
            _hashCode += getItemvalue().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(TypeEntity.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("http://webservice.atis.hisense.com/", "typeEntity"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("typename");
        elemField.setXmlName(new javax.xml.namespace.QName("", "typename"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemkey");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemkey"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "string"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("itemvalue");
        elemField.setXmlName(new javax.xml.namespace.QName("", "itemvalue"));
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
