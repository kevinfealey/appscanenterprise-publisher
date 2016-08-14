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
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;


/**
 * 
 *         Contains a listing of all jobs which have identified this issue.
 *       
 * 
 * <p>Java class for SourceJobs complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="SourceJobs">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="source-job" type="{http://www.ibm.com/Rational/AppScanEnterprise}SourceJob" maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "SourceJobs", propOrder = {
    "sourceJob"
})
public class SourceJobs {

    @XmlElement(name = "source-job")
    protected List<SourceJob> sourceJob;

    /**
     * Gets the value of the sourceJob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the sourceJob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getSourceJob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link SourceJob }
     * 
     * 
     */
    public List<SourceJob> getSourceJob() {
        if (sourceJob == null) {
            sourceJob = new ArrayList<SourceJob>();
        }
        return this.sourceJob;
    }

}