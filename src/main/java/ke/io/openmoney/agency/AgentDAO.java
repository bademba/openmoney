/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ke.io.openmoney.agency;

import java.util.List;
import javax.ws.rs.core.Response;

/**
 *
 * @author BADEMBA
 */
public interface AgentDAO {
    public Response createAgency(AgencyUtils agencyUtils);
    public List<AgencyUtils> getAllAgency();
    public AgencyUtils getOneAgency(String id);
    public AgencyUtils updateAgency(int agencyCode);
    
}
