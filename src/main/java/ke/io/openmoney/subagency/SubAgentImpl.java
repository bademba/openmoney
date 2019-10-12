/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.subagency;

import com.brian.db.DBConnector;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.logging.Level;
import java.util.logging.Logger;
import ke.io.openmoney.agency.AgencyImpl;

/**
 *
 * @author BADEMBA
 */
public class SubAgentImpl extends AgencyImpl{
    public final String FIND_SINGLE_AGENT = "SELECT * from subagent where subagentcode =?";
    public   SubAgentUtils getSingleSubAgency(int subAgentCode){
        
        SubAgentUtils subAgentUtils = null;
        try {
            Connection conn = DBConnector.getMysqlDBConnection();
            PreparedStatement ps = conn.prepareStatement(FIND_SINGLE_AGENT);
            ps.setString(1, subAgentUtils.getUuid());
            ps.setInt(2, subAgentUtils.getSubAgentCode());
            ps.setString(3, subAgentUtils.getAgencyFirstName());
            ps.setString(4, subAgentUtils.getAgencyMiddleName());
            ps.setString(5, subAgentUtils.getAgencyLastName());
            int addDetail = ps.executeUpdate();
            if(addDetail == 1){
            }
        } catch (Exception e) {
            Logger logger = Logger.getLogger(SubAgentImpl.class.getName());
            logger.log(Level.SEVERE, e.getMessage(), e);
            System.out.println("Error_Message-->" + e.getMessage());
        }
        return null;
    } 
    
}
