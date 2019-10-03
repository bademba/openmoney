/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.agency;

import java.sql.Date;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author BADEMBA
 */
@XmlRootElement(name = "Document")
@XmlAccessorType (XmlAccessType.FIELD)
public class Document {
    @XmlElement(name="documentType")
    public String documentType;
    @XmlElement(name="documentNumber")
    public String documentNumber;
    @XmlElement(name="documentExpiry")
    public String documentExpiry;

    public Document(){}
    
    public String getDocumentType() {
        return documentType;
    }

    public void setDocumentType(String documentType) {
        this.documentType = documentType;
    }

    public String getDocumentNumber() {
        return documentNumber;
    }

    public void setDocumentNumber(String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public String getDocumentExpiry() {
        return documentExpiry;
    }

    public void setDocumentExpiry(String documentExpiry) {
        this.documentExpiry = documentExpiry;
    }
    
    
    
}
