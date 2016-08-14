//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.29 at 05:53:35 PM EST 
//


package com.aspectsecurity.automationservices.appscanenterprise.jaxb.generated;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java class for TaintResultSetType complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="TaintResultSetType">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="ignoredClass" type="{http://www.w3.org/2001/XMLSchema}string" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element name="TaintResult" type="{http://www.ibm.com/Rational/AppScanEnterprise}TaintResultType" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *       &lt;attribute name="scanStartTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *       &lt;attribute name="scanEndTime" use="required" type="{http://www.w3.org/2001/XMLSchema}dateTime" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "TaintResultSetType", propOrder = {
    "ignoredClass",
    "taintResult"
})
public class TaintResultSetType {

    protected List<String> ignoredClass;
    @XmlElement(name = "TaintResult")
    protected List<TaintResultType> taintResult;
    @XmlAttribute(name = "scanStartTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scanStartTime;
    @XmlAttribute(name = "scanEndTime", required = true)
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar scanEndTime;

    /**
     * Gets the value of the ignoredClass property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the ignoredClass property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getIgnoredClass().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link String }
     * 
     * 
     */
    public List<String> getIgnoredClass() {
        if (ignoredClass == null) {
            ignoredClass = new ArrayList<String>();
        }
        return this.ignoredClass;
    }

    /**
     * Gets the value of the taintResult property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the taintResult property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getTaintResult().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link TaintResultType }
     * 
     * 
     */
    public List<TaintResultType> getTaintResult() {
        if (taintResult == null) {
            taintResult = new ArrayList<TaintResultType>();
        }
        return this.taintResult;
    }

    /**
     * Gets the value of the scanStartTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getScanStartTime() {
        return scanStartTime;
    }

    /**
     * Sets the value of the scanStartTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setScanStartTime(XMLGregorianCalendar value) {
        this.scanStartTime = value;
    }

    /**
     * Gets the value of the scanEndTime property.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getScanEndTime() {
        return scanEndTime;
    }

    /**
     * Sets the value of the scanEndTime property.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setScanEndTime(XMLGregorianCalendar value) {
        this.scanEndTime = value;
    }

}
