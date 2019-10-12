/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.agency;

import java.util.Random;
import java.util.UUID;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BADEMBA
 */
@XmlRootElement(name = "agency")
@XmlAccessorType(XmlAccessType.FIELD)
public class AgencyUtils {

    @XmlElement(name = "uuid")
    public String uuid;
    @XmlElement(name = "agencyCode")
    public int agencyCode;
    @XmlElement(name = "agencyFirstName")
    public String agencyFirstName;
    @XmlElement(name = "agencyMiddleName")
    public String agencyMiddleName;
    @XmlElement(name = "agencyLastName")
    public String agencyLastName;
    @XmlElement(name = "country")
    public String country;
    @XmlElement(name = "currency")
    public String currency;
    @XmlElement(name = "document")
    public Document document;
    @XmlElement(name = "address")
    public Address address;

    public AgencyUtils() {
    }

    public AgencyUtils(int agencyCode, String agencyFirstName, String agencyMiddleName, String agencyLastName, String country, String currency, Document document, Address address, String uuid) {
        this.agencyCode = agencyCode;
        this.agencyFirstName = agencyFirstName;
        this.agencyMiddleName = agencyMiddleName;
        this.agencyLastName = agencyLastName;
        this.country = country;
        this.currency = currency;
        this.document = document;
        this.address = address;
        this.uuid = uuid;
    }

    public String getUuid() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }

    public void setUuid(String uuid) {
        this.uuid = uuid;
    }

    public int getAgencyCode() {
        Random rand = new Random();
        int agencyCode = rand.nextInt(10000);
        return agencyCode;
    }

    public void setAgencyCode(int agencyCode) {
        this.agencyCode = agencyCode;
    }

    public String getAgencyFirstName() {
        return agencyFirstName;
    }

    public void setAgencyFirstName(String agencyFirstName) {
        this.agencyFirstName = agencyFirstName;
    }

    public String getAgencyMiddleName() {
        return agencyMiddleName;
    }

    public void setAgencyMiddleName(String agencyMiddleName) {
        this.agencyMiddleName = agencyMiddleName;
    }

    public String getAgencyLastName() {
        return agencyLastName;
    }

    public void setAgencyLastName(String agencyLastName) {
        this.agencyLastName = agencyLastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

}
