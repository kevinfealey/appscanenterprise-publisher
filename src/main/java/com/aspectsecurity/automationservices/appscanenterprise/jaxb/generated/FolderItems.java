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
import javax.xml.bind.annotation.XmlAnyElement;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import org.w3c.dom.Element;


/**
 * Represents a collection of folder items (jobs, report packs, dashboards).
 * 
 * <p>Java class for FolderItems complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="FolderItems">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element ref="{http://www.ibm.com/Rational/AppScanEnterprise}content-scan-job" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/Rational/AppScanEnterprise}report-pack" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/Rational/AppScanEnterprise}dashboard" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;element ref="{http://www.ibm.com/Rational/AppScanEnterprise}import-job" maxOccurs="unbounded" minOccurs="0"/>
 *         &lt;any processContents='lax' namespace='##other' maxOccurs="unbounded" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "FolderItems", propOrder = {
    "contentScanJob",
    "reportPack",
    "dashboard",
    "importJob",
    "any"
})
public class FolderItems {

    @XmlElement(name = "content-scan-job")
    protected List<ContentJob> contentScanJob;
    @XmlElement(name = "report-pack")
    protected List<ReportPack> reportPack;
    protected List<Dashboard> dashboard;
    @XmlElement(name = "import-job")
    protected List<ImportJob> importJob;
    @XmlAnyElement(lax = true)
    protected List<Object> any;

    /**
     * Gets the value of the contentScanJob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the contentScanJob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getContentScanJob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ContentJob }
     * 
     * 
     */
    public List<ContentJob> getContentScanJob() {
        if (contentScanJob == null) {
            contentScanJob = new ArrayList<ContentJob>();
        }
        return this.contentScanJob;
    }

    /**
     * Gets the value of the reportPack property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the reportPack property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getReportPack().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ReportPack }
     * 
     * 
     */
    public List<ReportPack> getReportPack() {
        if (reportPack == null) {
            reportPack = new ArrayList<ReportPack>();
        }
        return this.reportPack;
    }

    /**
     * Gets the value of the dashboard property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the dashboard property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getDashboard().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Dashboard }
     * 
     * 
     */
    public List<Dashboard> getDashboard() {
        if (dashboard == null) {
            dashboard = new ArrayList<Dashboard>();
        }
        return this.dashboard;
    }

    /**
     * Gets the value of the importJob property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the importJob property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getImportJob().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link ImportJob }
     * 
     * 
     */
    public List<ImportJob> getImportJob() {
        if (importJob == null) {
            importJob = new ArrayList<ImportJob>();
        }
        return this.importJob;
    }

    /**
     * Gets the value of the any property.
     * 
     * <p>
     * This accessor method returns a reference to the live list,
     * not a snapshot. Therefore any modification you make to the
     * returned list will be present inside the JAXB object.
     * This is why there is not a <CODE>set</CODE> method for the any property.
     * 
     * <p>
     * For example, to add a new item, do as follows:
     * <pre>
     *    getAny().add(newItem);
     * </pre>
     * 
     * 
     * <p>
     * Objects of the following type(s) are allowed in the list
     * {@link Element }
     * {@link Object }
     * 
     * 
     */
    public List<Object> getAny() {
        if (any == null) {
            any = new ArrayList<Object>();
        }
        return this.any;
    }

}