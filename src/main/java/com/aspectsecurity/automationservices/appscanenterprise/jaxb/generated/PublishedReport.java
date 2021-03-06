//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.8-b130911.1802 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.01.29 at 05:53:35 PM EST 
//


package com.aspectsecurity.automationservices.appscanenterprise.jaxb.generated;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlType;


/**
 * Entry that contains information about reports published to network management systems.
 * 
 * <p>Java class for Published-Report complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="Published-Report">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;attribute name="id" use="required" type="{http://www.w3.org/2001/XMLSchema}int" />
 *       &lt;attribute name="report-name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="report-pack-name" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="report-pack-folder" type="{http://www.w3.org/2001/XMLSchema}string" />
 *       &lt;attribute name="href" type="{http://www.w3.org/2001/XMLSchema}string" />
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Published-Report")
public class PublishedReport {

    @XmlAttribute(name = "id", required = true)
    protected int id;
    @XmlAttribute(name = "report-name")
    protected String reportName;
    @XmlAttribute(name = "report-pack-name")
    protected String reportPackName;
    @XmlAttribute(name = "report-pack-folder")
    protected String reportPackFolder;
    @XmlAttribute(name = "href")
    protected String href;

    /**
     * Gets the value of the id property.
     * 
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the value of the id property.
     * 
     */
    public void setId(int value) {
        this.id = value;
    }

    /**
     * Gets the value of the reportName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportName() {
        return reportName;
    }

    /**
     * Sets the value of the reportName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportName(String value) {
        this.reportName = value;
    }

    /**
     * Gets the value of the reportPackName property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPackName() {
        return reportPackName;
    }

    /**
     * Sets the value of the reportPackName property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPackName(String value) {
        this.reportPackName = value;
    }

    /**
     * Gets the value of the reportPackFolder property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getReportPackFolder() {
        return reportPackFolder;
    }

    /**
     * Sets the value of the reportPackFolder property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setReportPackFolder(String value) {
        this.reportPackFolder = value;
    }

    /**
     * Gets the value of the href property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getHref() {
        return href;
    }

    /**
     * Sets the value of the href property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setHref(String value) {
        this.href = value;
    }

}
