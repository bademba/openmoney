/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.subagency;

import javax.xml.bind.annotation.XmlElement;
import ke.io.openmoney.agency.Address;
import ke.io.openmoney.agency.AgencyUtils;
import ke.io.openmoney.agency.Document;

/**
 *
 * @author BADEMBA
 */
public class SubAgentUtils extends AgencyUtils {

    @XmlElement(name = "subAgentCode")
    public int subAgentCode;

    public SubAgentUtils(int subAgentCode, String agencyFirstName, String agencyMiddleName, String agencyLastName, String country, String currency, Document document, Address address, String uuid) {
    }

    public int getSubAgentCode() {
        return subAgentCode;
    }

    public void setSubAgentCode(int subAgentCode) {
        this.subAgentCode = subAgentCode;
    }

    
}
