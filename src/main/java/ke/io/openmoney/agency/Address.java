/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.agency;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BADEMBA
 */
@XmlRootElement(name = "Address")
@XmlAccessorType (XmlAccessType.FIELD)
public class Address {
    
    @XmlElement(name="phoneNumber")
    public String phoneNumber;
    @XmlElement(name="city")
    public String city;
    @XmlElement(name="postalAddress")
    public String postalAddress;
    @XmlElement(name="postalCode")
    public String postalCode;
    @XmlElement(name="street")
    public String street;

    public Address(){} 
    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostalAddress() {
        return postalAddress;
    }

    public void setPostalAddress(String postalAddress) {
        this.postalAddress = postalAddress;
    }

    public String getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(String postalCode) {
        this.postalCode = postalCode;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
    
    
    
}
