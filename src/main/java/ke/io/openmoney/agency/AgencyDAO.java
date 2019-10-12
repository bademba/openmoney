/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.agency;

import com.brian.db.DBConnector;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import javax.xml.bind.annotation.XmlElement;

/**
 *
 * @author BADEMBA
 */
public class AgencyDAO {

    public static final Map<String, AgencyUtils> agencyMap = new HashMap<String, AgencyUtils>();

    @XmlElement(name = "agent")
    public static AgencyUtils createAgency(AgencyUtils agencyUtils) {

        PreparedStatement ps = null;
        Connection conn = null;
        String createAgencyQuery = "INSERT into agency (id,fname,mname,lname,country,currency,doctype,docnum,expiry,phonenumber,city,postalcode,postaladdress,street) values \n"
                + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
        UUID uuid = UUID.randomUUID();
        try {
            conn = DBConnector.getMysqlDBConnection();
            ps = conn.prepareStatement(createAgencyQuery);
            ps.setString(1, uuid.toString());
            ps.setString(2, agencyUtils.getAgencyFirstName());
            ps.setString(3, agencyUtils.getAgencyMiddleName());
            ps.setString(4, agencyUtils.getAgencyLastName());
            ps.setString(5, agencyUtils.getCountry());
            ps.setString(6, agencyUtils.getCurrency());
            ps.setString(7, agencyUtils.getDocument().getDocumentType());
            ps.setString(8, agencyUtils.getDocument().getDocumentNumber());
            ps.setString(9, agencyUtils.getDocument().getDocumentExpiry());
            ps.setString(10, agencyUtils.getAddress().getPhoneNumber());
            ps.setString(11, agencyUtils.getAddress().getCity());
            ps.setString(12, agencyUtils.getAddress().getPostalCode());
            ps.setString(13, agencyUtils.getAddress().getPostalAddress());
            ps.setString(14, agencyUtils.getAddress().getStreet());
            int addDetail = ps.executeUpdate();

            agencyMap.put(uuid.toString(), agencyUtils);
            if (addDetail == 1) {
                System.out.println("Agency  " + agencyUtils + " created");
            } else {
                System.out.println("Agency not created");
            }
        } catch (Exception e) {
        }
        return agencyUtils;
    }

//    public List<AgencyUtils> getAllAgency() {
//        //static HashMap<String, AgencyUtils> agencyMap = new HashMap<String, AgencyUtils>(agen);
//        List<AgencyUtils> getAgencyList = getAgencyList = new ArrayList<AgencyUtils>(agencyMap.values());
//        AgencyUtils getAllAgency = null;
//        Connection con = null;
//        try {
//            
//            con = DBConnector.getMysqlDBConnection();
//            String query = "SELECT id,fname,mname,lname,country,city,currency from remittance.agency;";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                getAllAgency = new AgencyUtils();
//                //getAllAgency.agencyId = rs.getString("id");
//                getAllAgency.agencyFirstName = rs.getString("fname");
//                getAllAgency.agencyMiddleName = rs.getString("mname");
//                getAllAgency.agencyLastName = rs.getString("lname");
//                getAllAgency.country = rs.getString("country");
//                getAllAgency.address.city = rs.getString("city");
//                getAllAgency.currency = rs.getString("currency");
//                getAgencyList.add(getAllAgency);
//                ObjectMapper mapper = new ObjectMapper();
//                String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(getAllAgency);
//                System.out.print(jsonString);
//            }
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//
//        return getAgencyList;
//    }
//       public List<AgencyUtils> getAllAgency(){
//        List<AgencyUtils> getAgencyList = new ArrayList<AgencyUtils>();
//        AgencyUtils agencyUtils = null;
//        Connection con = null;
//        try {
//            con = DBConnector.getMysqlDBConnection();
//            String query = "SELECT fname,mname,lname,country,city,currency from remittance.agency;";
//            Statement stmt = con.createStatement();
//            ResultSet rs = stmt.executeQuery(query);
//            while (rs.next()) {
//                agencyUtils = new AgencyUtils();
//                //agencyUtils.uuid. = rs.getString("id");
//                agencyUtils.agencyFirstName = rs.getString("fname");
//                agencyUtils.agencyMiddleName = rs.getString("mname");
//                agencyUtils.agencyLastName = rs.getString("lname");
//                agencyUtils.country = rs.getString("country");
//                agencyUtils.address.city = rs.getString("city");
//                agencyUtils.currency = rs.getString("currency");
//                getAgencyList.add(agencyUtils);
//                ObjectMapper mapper = new ObjectMapper();
//                String jsonString = mapper.writerWithDefaultPrettyPrinter().writeValueAsString(agencyUtils);
//                System.out.print(jsonString);
//            }
//        } catch (Exception e) {
//        }
//
//        return getAgencyList;
//    }
 
}
