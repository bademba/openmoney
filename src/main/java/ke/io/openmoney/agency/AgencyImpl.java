/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.agency;

import com.brian.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.UUID;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ws.rs.core.Response;

/**
 *
 * @author BADEMBA
 */
public class AgencyImpl implements AgentDAO {

    private static final String FIND_ALL_AGENCY = "SELECT * from remittance.agency";
    private static final String FIND_ONE = "SELECT agencycode,fname,mname,lname,country,currency from agency where id =?";
    public  final String CREATE_AGENCY = "INSERT INTO agency(id,agencycode,fname,mname,lname,country,currency,doctype,docnum,expiry,phonenumber,city,postalcode,postaladdress,street) VALUES \n"
            + "(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
    private static final String UPDATE_AGENCY = "update agency set fname=?,mname=?,lname=?,country=? WHERE agencycode=?";

    //create agency
    public Response createAgency(AgencyUtils agencyUtils)  {
        Document doc = new Document();
        agencyUtils.document = doc;
        Address addr = new Address();
        agencyUtils.address = addr;
        try {
            Connection conn = DBConnector.getMysqlDBConnection();
            PreparedStatement ps = conn.prepareStatement(CREATE_AGENCY);
            ps.setString(1, agencyUtils.getUuid());
            ps.setInt(2, agencyUtils.getAgencyCode());
            ps.setString(3, agencyUtils.getAgencyFirstName());
            ps.setString(4, agencyUtils.getAgencyMiddleName());
            ps.setString(5, agencyUtils.getAgencyLastName());
            ps.setString(6, agencyUtils.getCountry());
            ps.setString(7, agencyUtils.getCurrency());
            ps.setString(8, agencyUtils.getDocument().getDocumentType());
            ps.setString(9, agencyUtils.getDocument().getDocumentNumber());
            ps.setString(10, agencyUtils.getDocument().getDocumentExpiry());
            ps.setString(11, agencyUtils.getAddress().getPhoneNumber());
            ps.setString(12, agencyUtils.getAddress().getCity());
            ps.setString(13, agencyUtils.getAddress().getPostalCode());
            ps.setString(14, agencyUtils.getAddress().getPostalAddress());
            ps.setString(15, agencyUtils.getAddress().getStreet());
            int addDetail = ps.executeUpdate();
            String agencyCreatedRes =  "{\"response\":\"success\"}";
            if (addDetail == 1) {
                System.out.println("Agency created NOE"+ agencyUtils.getAgencyCode());
            }
        } catch (SQLException e) {
            Logger logger = Logger.getLogger(AgencyImpl.class.getName());
            logger.log(Level.SEVERE, e.getMessage(), e);
            System.out.println("Error_Message-->" + e.getMessage());
            //throw new RuntimeException(e);
        }
        System.out.println(agencyUtils); 
        String agencyCreatedRes =  "{\"response\":\"success\"}";
        return Response.status(201).entity(agencyCreatedRes).build();
        

    }

    //get all agencies
    public List<AgencyUtils> getAllAgency() {
        Connection conn = null;
        PreparedStatement ps = null;
        List<AgencyUtils> listAgency = new ArrayList<AgencyUtils>();
        try {
            conn = DBConnector.getMysqlDBConnection();
            ps = conn.prepareStatement(FIND_ALL_AGENCY);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                AgencyUtils agencyUtils = new AgencyUtils();
                agencyUtils.setUuid(rs.getString("id"));
                agencyUtils.setAgencyCode(rs.getInt("agencycode"));
                agencyUtils.setAgencyFirstName(rs.getString("fname"));
                agencyUtils.setAgencyMiddleName(rs.getString("mname"));
                agencyUtils.setAgencyLastName(rs.getString("lname"));
                agencyUtils.setCountry(rs.getString("country"));
                agencyUtils.setCurrency(rs.getString("currency"));
                listAgency.add(agencyUtils);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return listAgency;
    }

    /*
     get details of an agency
     */
    public AgencyUtils getOneAgency(String id) {
        Connection conn = null;
        PreparedStatement ps = null;
        AgencyUtils agencyUtils = null;
        try {
            conn = DBConnector.getMysqlDBConnection();
            ps = conn.prepareStatement(FIND_ONE);
            ps.setString(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                agencyUtils = new AgencyUtils();
                agencyUtils.setAgencyCode(rs.getInt("agencyCode"));
                agencyUtils.setAgencyFirstName(rs.getString("fname"));
                agencyUtils.setAgencyMiddleName(rs.getString("mname"));
                agencyUtils.setAgencyLastName(rs.getString("lname"));
                agencyUtils.setCountry(rs.getString("country"));
                agencyUtils.setCurrency(rs.getString("currency"));
                return agencyUtils;
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return agencyUtils;
    }

    //update an agency
    public AgencyUtils updateAgency(int agencyCode) {
        Connection conn = null;
        PreparedStatement ps = null;
        AgencyUtils agencyUtils = null;
        try {
            conn = DBConnector.getMysqlDBConnection();
            ps = conn.prepareStatement(UPDATE_AGENCY);
            agencyUtils = new AgencyUtils();
            ps.setInt(1, agencyCode);
            ps.setString(2, agencyUtils.getAgencyFirstName());
            ps.setString(3, agencyUtils.getAgencyMiddleName());
            ps.setString(4, agencyUtils.getAgencyLastName());
            ps.setString(5, agencyUtils.getCountry());
            int update = ps.executeUpdate();
            if (update == 1) {
                System.out.println(agencyUtils);
                return agencyUtils;
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        System.out.println(ps);
        return agencyUtils;
    }

}
